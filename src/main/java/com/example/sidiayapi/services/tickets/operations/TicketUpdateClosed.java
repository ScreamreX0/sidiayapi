package com.example.sidiayapi.services.tickets.operations;

import com.example.sidiayapi.entities.Tickets;
import com.example.sidiayapi.enums.StatusesEnum;
import com.example.sidiayapi.exceptions.NotYetImplementedException;
import com.example.sidiayapi.repositories.TicketsRepository;


public final class TicketUpdateClosed implements ITicketUpdateOperation {
    private final StatusesEnum status = StatusesEnum.CLOSED;

    @Override
    public Tickets update(Tickets ticket,
                          Tickets newTicket,
                          TicketsRepository ticketsRepository,
                          Long userId) {
        throw new NotYetImplementedException("Status code " + getStatus().value + " not handled");
    }
    @Override
    public StatusesEnum getStatus() {
        return status;
    }
}
