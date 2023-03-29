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
        Logger.log("    Updating fields with null-check");
        if (newTicket.getFacilities() != null) {
            Logger.log("    Updating facilities..");
            ticket.setFacilities(newTicket.getFacilities());
        }
//        Logger.log("    Done. updating equipment..");
//        if (ticketUpdatesMap.getEquipment() != null) {
//            foundTicket.setEquipment(ticketUpdatesMap.getEquipment());
//        }
//        Logger.log("    Done. updating transport..");
//        if (ticketUpdatesMap.getTransport() != null) {
//            foundTicket.setTransport(ticketUpdatesMap.getTransport());
//        }
//        Logger.log("    Done. updating brigades..");
//        if (ticketUpdatesMap.getBrigades() != null) {
//            foundTicket.setBrigades(ticketUpdatesMap.getBrigades());
//        }
//        Logger.log("    Done. updating executor..");
//        if (ticketUpdatesMap.getExecutorId() != null) {
//            foundTicket.setExecutorId(ticketUpdatesMap.getExecutorId());
//        }

        Logger.log("    Done.");
        Logger.log("    Checking for all needed fields in ticket are not null..");
        if (!Validator.anyNull(
                ticket.getFacilities(),
                ticket.getEquipment(),
                ticket.getTransport(),
                ticket.getExecutorId(),
                ticket.getBrigades())
        ) {
            Logger.log("    All fields are not null. Updating ticket status..");
            ticket.setStatus(StatusesEnum.NEW.value);
        }
        Logger.log("    Saving ticket..");
        return ticketsRepository.save(ticket);
    }
    @Override
    public StatusesEnum getStatus() {
        return status;
    }
}
