package com.example.sidiayapi.services.tickets.operations;

import com.example.sidiayapi.entities.Tickets;
import com.example.sidiayapi.enums.StatusesEnum;
import com.example.sidiayapi.exceptions.NotYetImplementedException;
import com.example.sidiayapi.repositories.TicketsRepository;


public final class TicketUpdateCompleted implements ITicketUpdateOperation {
    private final StatusesEnum status = StatusesEnum.COMPLETED;

//    @Override
//    public Tickets update(Long senderId,
//                          Tickets ticket,
//                          Tickets newTicket,
//                          TicketsRepository ticketsRepository) {
//    }
    @Override
    public StatusesEnum getStatus() {
        return status;
    }
}
