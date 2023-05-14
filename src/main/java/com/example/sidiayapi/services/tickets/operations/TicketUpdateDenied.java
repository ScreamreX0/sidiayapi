//package com.example.sidiayapi.services.tickets.operations;
//
//import com.example.sidiayapi.entities.Tickets;
//import com.example.sidiayapi.enums.StatusesEnum;
//import com.example.sidiayapi.exceptions.NotYetImplementedException;
//import com.example.sidiayapi.repositories.TicketsRepository;
//
//
//public final class TicketUpdateDenied implements ITicketUpdateOperation {
//    private final StatusesEnum status = StatusesEnum.DENIED;
//
//    @Override
//    public Tickets update(Tickets ticket,
//                          Tickets newTicket,
//                          TicketsRepository ticketsRepository,
//                          Long userId) {
//        throw new NotYetImplementedException("Status: " + status.value + " not handled");
//    }
//    @Override
//    public StatusesEnum getStatus() {
//        return status;
//    }
//}
