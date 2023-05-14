package com.example.sidiayapi.services.tickets.operations;

import com.example.sidiayapi.entities.Tickets;
import com.example.sidiayapi.entities.Users;
import com.example.sidiayapi.enums.StatusesEnum;
import com.example.sidiayapi.exceptions.NotYetImplementedException;
import com.example.sidiayapi.repositories.TicketsRepository;


public final class TicketUpdateDenied implements ITicketUpdateOperation {
    private final StatusesEnum status = StatusesEnum.REJECTED;

    @Override
    public Tickets update(Tickets foundTicket,
                          Tickets newTicket,
                          TicketsRepository ticketsRepository,
                          Users sender) {
        throw new NotYetImplementedException("Status: " + status.value + " not handled");
    }
    @Override
    public StatusesEnum getStatus() {
        return status;
    }
}
