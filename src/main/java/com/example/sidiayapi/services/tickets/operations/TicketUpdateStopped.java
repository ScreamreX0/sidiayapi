package com.example.sidiayapi.services.tickets.operations;

import com.example.sidiayapi.enums.StatusesEnum;


public final class TicketUpdateStopped implements ITicketUpdateOperation {
    private final StatusesEnum status = StatusesEnum.SUSPENDED;

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
