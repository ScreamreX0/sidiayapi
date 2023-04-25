package com.example.sidiayapi.services.tickets.operations;

import com.example.sidiayapi.entities.Tickets;
import com.example.sidiayapi.enums.StatusesEnum;
import com.example.sidiayapi.repositories.TicketsRepository;
import com.example.sidiayapi.utils.Helper;
import com.example.sidiayapi.utils.Logger;


public final class TicketUpdateSuspended implements ITicketUpdateOperation {
    private final StatusesEnum status = StatusesEnum.SUSPENDED;

    @Override
    public Tickets update(Tickets ticket,
                          Tickets newTicket,
                          TicketsRepository ticketsRepository,
                          Long userId) {
        Helper.checkNewTicketStatus(newTicket.getStatus());

        Logger.log("    New ticket status: " + newTicket.getStatus());

        ticket.setStatus(StatusesEnum.ACCEPTED.value);

        return ticketsRepository.save(ticket);
    }

    @Override
    public StatusesEnum getStatus() {
        return status;
    }
}
