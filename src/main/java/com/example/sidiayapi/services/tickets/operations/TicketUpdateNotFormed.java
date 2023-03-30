package com.example.sidiayapi.services.tickets.operations;

import com.example.sidiayapi.entities.Tickets;
import com.example.sidiayapi.enums.StatusesEnum;
import com.example.sidiayapi.repositories.TicketsRepository;
import com.example.sidiayapi.utils.Logger;
import com.example.sidiayapi.utils.Validator;


public final class TicketUpdateNotFormed implements ITicketUpdateOperation {
    private final StatusesEnum status = StatusesEnum.NOT_FORMED;

    @Override
    public Tickets update(Long senderId,
                          Tickets ticket,
                          Tickets newTicket,
                          TicketsRepository ticketsRepository) {
        Logger.log("    Updating fields that not null");
        if (newTicket.getFacilities() != null) {
            Logger.log("    Updating facilities..");
            ticket.setFacilities(newTicket.getFacilities());
        }
        if (newTicket.getEquipment() != null) {
            Logger.log("    Done. updating equipment..");
            ticket.setEquipment(ticket.getEquipment());
        }
        if (newTicket.getTransport() != null) {
            Logger.log("    Done. updating transport..");
            ticket.setTransport(newTicket.getTransport());
        }
        if (newTicket.getBrigades() != null) {
            Logger.log("    Done. updating brigades..");
            ticket.setBrigades(newTicket.getBrigades());
        }
        if (newTicket.getExecutorId() != null) {
            Logger.log("    Done. updating executor..");
            ticket.setExecutorId(newTicket.getExecutorId());
        }

        Logger.log("    Done.");
        Logger.log("    Checking all fields in the ticket for emptiness..");
        if (!Validator.anyNull(
                ticket.getFacilities(),
                ticket.getEquipment(),
                ticket.getTransport(),
                ticket.getExecutorId(),
                ticket.getBrigades())
        ) {
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
}
