package com.example.sidiayapi.services.tickets.operations;

import com.example.sidiayapi.entities.Tickets;
import com.example.sidiayapi.enums.StatusesEnum;
import com.example.sidiayapi.exceptions.NotYetImplementedException;
import com.example.sidiayapi.exceptions.WrongParamsException;
import com.example.sidiayapi.repositories.TicketsRepository;
import com.example.sidiayapi.utils.Logger;
import com.example.sidiayapi.utils.Validator;


public final class TicketUpdateNotFormed implements ITicketUpdateOperation {
    private final StatusesEnum status = StatusesEnum.NOT_FORMED;

    @Override
    public Tickets update(Tickets ticket,
                          Tickets newTicket,
                          TicketsRepository ticketsRepository,
                          Long userId) {

        Integer newTicketStatus = newTicket.getStatus();
        checkFields(userId, ticket, newTicketStatus);
        boolean isCurrentUserAnExecutor = isUserAnExecutor(userId, ticket);

        if (isCurrentUserAnExecutor) {
            throw new WrongParamsException("This status not supporting an executor");
        } else {
            if (newTicketStatus != StatusesEnum.NEW.value && newTicketStatus != StatusesEnum.NOT_FORMED.value) {
                throw new NotYetImplementedException(status.value, newTicketStatus, false);
            }

            if (newTicketStatus == StatusesEnum.NEW.value) {
                Logger.log("Checking starred fields..");
                if (Validator.anyNull(
                        newTicket.getFacilities(),
                        newTicket.getService(),
                        newTicket.getKind(),
                        newTicket.getPriority(),
                        newTicket.getExecutor_id(),
                        newTicket.getPlane_date()
                )) {
                    Logger.log("Not all required fields are filled."
                            + "\n   facilities: " + newTicket.getFacilities()
                            + "\n   service: " + newTicket.getService()
                            + "\n   kind: " + newTicket.getKind()
                            + "\n   priority: " + newTicket.getPriority()
                            + "\n   executor: " + newTicket.getExecutor_id()
                            + "\n   plane_date: " + newTicket.getPlane_date()
                    );
                    throw new WrongParamsException("Not all required fields are filled");
                }
            }

            updateTicketField(newTicketStatus, ticket::setStatus, "status");
            updateTicketField(newTicket.getName(), ticket::setName, "name");
            updateTicketField(newTicket.getFacilities(), ticket::setFacilities, "facilities");
            updateTicketField(newTicket.getService(), ticket::setService, "service");
            updateTicketField(newTicket.getKind(), ticket::setKind, "kind");
            updateTicketField(newTicket.getPriority(), ticket::setPriority, "priority");
            updateTicketField(newTicket.getExecutor_id(), ticket::setExecutor_id, "executor");
            updateTicketField(newTicket.getPlane_date(), ticket::setPlane_date, "plane date");
            updateTicketField(newTicket.getDescription(), ticket::setDescription, "description");
            updateTicketField(newTicket.getName(), ticket::setName, "name");

            Logger.log("Saving ticket..");

            return ticketsRepository.save(ticket);
        }
    }

    @Override
    public StatusesEnum getStatus() {
        return status;
    }
}
