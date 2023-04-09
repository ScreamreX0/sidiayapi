package com.example.sidiayapi.services.tickets.operations;

import com.example.sidiayapi.entities.Tickets;
import com.example.sidiayapi.enums.StatusesEnum;
import com.example.sidiayapi.repositories.TicketsRepository;
import com.example.sidiayapi.utils.Logger;
import com.example.sidiayapi.utils.Validator;

import java.util.function.Consumer;


public final class TicketUpdateNotFormed implements ITicketUpdateOperation {
    private final StatusesEnum status = StatusesEnum.NOT_FORMED;

    @Override
    public Tickets update(Long senderId,
                          Tickets ticket,
                          Tickets newTicket,
                          TicketsRepository ticketsRepository) {
        Logger.log("    Updating fields that not null");

        updateTicketField(newTicket.getFacilities(), ticket::setFacilities, "facilities");
        updateTicketField(newTicket.getService(), ticket::setService, "service");
        updateTicketField(newTicket.getKind(), ticket::setKind, "kind");
        updateTicketField(newTicket.getPlane_date(), ticket::setPlane_date, "plane date");
        updateTicketField(newTicket.getPriority(), ticket::setPriority, "priority");
        updateTicketField(newTicket.getExecutor_id(), ticket::setExecutor_id, "executor");

        Logger.log("    Checking starred fields..");
        if (!Validator.anyNull(
                ticket.getFacilities(),
                ticket.getService(),
                ticket.getKind(),
                ticket.getPlane_date(),
                ticket.getPriority(),
                ticket.getExecutor_id()
        )) {
            Logger.log("    All fields are not null. Updating ticket status..");
            ticket.setStatus(StatusesEnum.NEW.value);
        } else {
            Logger.log("    Some fields are empty. Status - NOT_FORMED");
        }
        Logger.log("    Saving ticket..");
        return ticketsRepository.save(ticket);
    }

    @Override
    public StatusesEnum getStatus() {
        return status;
    }

    private <T> void updateTicketField(T newValue, Consumer<T> setter, String fieldName) {
        if (newValue != null) {
            Logger.log("    Updating " + fieldName + "..");
            setter.accept(newValue);
        }
    }
}
