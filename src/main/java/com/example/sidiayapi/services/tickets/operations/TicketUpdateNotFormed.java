package com.example.sidiayapi.services.tickets.operations;

import com.example.sidiayapi.entities.Tickets;
import com.example.sidiayapi.enums.StatusesEnum;
import com.example.sidiayapi.exceptions.NotYetImplementedException;
import com.example.sidiayapi.exceptions.WrongCredentialsException;
import com.example.sidiayapi.exceptions.WrongParamsException;
import com.example.sidiayapi.repositories.TicketsRepository;
import com.example.sidiayapi.utils.Logger;
import com.example.sidiayapi.utils.Validator;

import java.util.function.Consumer;


public final class TicketUpdateNotFormed implements ITicketUpdateOperation {
    private final StatusesEnum status = StatusesEnum.NOT_FORMED;

    @Override
    public Tickets update(Tickets ticket,
                          Tickets newTicket,
                          TicketsRepository ticketsRepository,
                          Long userId) {
        Logger.log("Updating fields that not null");

        Boolean isCurrentUserExecutor = isCurrentUserExecutor(userId, ticket);

        if (newTicket.getStatus() == null) {
            throw new WrongParamsException("Status is empty");
        }

        if (isCurrentUserExecutor == null) {
            throw new WrongCredentialsException("Current user is unauthorized");
        } else if (isCurrentUserExecutor) {
            throw new WrongParamsException("This status not supporting an executor");
        } else {
            if (newTicket.getStatus() == StatusesEnum.NEW.value) {
                Logger.log("Checking starred fields..");
                if (!Validator.anyNull(
                        ticket.getFacilities(),
                        ticket.getService(),
                        ticket.getKind(),
                        ticket.getPriority(),
                        ticket.getExecutor_id(),
                        ticket.getPlane_date()
                )) {
                    Logger.log("All fields are not null. Updating ticket status..");
                    ticket.setStatus(newTicket.getStatus());

                    updateTicketField(newTicket.getName(), ticket::setName, "name");
                    updateTicketField(newTicket.getFacilities(), ticket::setFacilities, "facilities");
                    updateTicketField(newTicket.getService(), ticket::setService, "service");
                    updateTicketField(newTicket.getKind(), ticket::setKind, "kind");
                    updateTicketField(newTicket.getPriority(), ticket::setPriority, "priority");
                    updateTicketField(newTicket.getExecutor_id(), ticket::setExecutor_id, "executor");
                    updateTicketField(newTicket.getPlane_date(), ticket::setPlane_date, "plane date");

                    Logger.log("Saving ticket..");
                    return ticketsRepository.save(ticket);
                } else {
                    Logger.log("Not all required fields are filled");
                    throw new WrongParamsException("Not all required fields are filled");
                }
            } else if (newTicket.getStatus() == StatusesEnum.NOT_FORMED.value) {
                ticket.setStatus(newTicket.getStatus());

                updateTicketField(newTicket.getName(), ticket::setName, "name");
                updateTicketField(newTicket.getFacilities(), ticket::setFacilities, "facilities");
                updateTicketField(newTicket.getService(), ticket::setService, "service");
                updateTicketField(newTicket.getKind(), ticket::setKind, "kind");
                updateTicketField(newTicket.getPriority(), ticket::setPriority, "priority");
                updateTicketField(newTicket.getExecutor_id(), ticket::setExecutor_id, "executor");
                updateTicketField(newTicket.getPlane_date(), ticket::setPlane_date, "plane date");

                Logger.log("Saving ticket..");
                return ticketsRepository.save(ticket);
            } else {
                throw new NotYetImplementedException("Status code " + newTicket.getStatus() + " not supported");
            }
        }
    }

    @Override
    public StatusesEnum getStatus() {
        return status;
    }

    private <T> void updateTicketField(T newValue, Consumer<T> setter, String fieldName) {
        if (newValue != null) {
            Logger.log("Updating " + fieldName + "..");
            setter.accept(newValue);
        }
    }
}
