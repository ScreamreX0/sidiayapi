//package com.example.sidiayapi.services.tickets.operations;
//
//import com.example.sidiayapi.entities.Tickets;
//import com.example.sidiayapi.enums.StatusesEnum;
//import com.example.sidiayapi.exceptions.NotYetImplementedException;
//import com.example.sidiayapi.exceptions.WrongParamsException;
//import com.example.sidiayapi.repositories.TicketsRepository;
//import com.example.sidiayapi.utils.Logger;
//import com.example.sidiayapi.utils.Validator;
//
//
//public final class TicketUpdateNew implements ITicketUpdateOperation {
//    private final StatusesEnum status = StatusesEnum.NEW;
//
//    @Override
//    public Tickets update(Tickets ticket,
//                          Tickets newTicket,
//                          TicketsRepository ticketsRepository,
//                          Long userId) {
//
//        Integer newTicketStatus = newTicket.getStatus();
//        checkFields(userId, ticket, newTicketStatus);
//        boolean isCurrentUserAnExecutor = isUserAnExecutor(userId, ticket);
//
//        if (isCurrentUserAnExecutor) {
//            if (newTicketStatus == StatusesEnum.DENIED.value) {
//                if (Validator.anyNull(
//                        newTicket.getCompletedWork(),
//                        newTicket.getClosingDate()
//                )) {
//                    String message = "Completed work or closing date is null";
//                    Logger.log(message);
//                    throw new WrongParamsException(message);
//                }
//
//                updateTicketField(newTicketStatus, ticket::setStatus, "status");
//                updateTicketField(newTicket.getCompletedWork(), ticket::setCompletedWork, "completed_work");
//                updateTicketField(newTicket.getClosingDate(), ticket::setClosingDate, "closing_date");
//                return ticketsRepository.save(ticket);
//            } else if (newTicketStatus == StatusesEnum.ACCEPTED.value) {
//                updateTicketField(newTicketStatus, ticket::setStatus, "status");
//                return ticketsRepository.save(ticket);
//            }
//        } else {
//            if (newTicketStatus == StatusesEnum.CLOSED.value) {
//                updateTicketField(newTicketStatus, ticket::setStatus, "status");
//                updateTicketField(newTicket.getClosingDate(), ticket::setClosingDate, "closing_date");
//                return ticketsRepository.save(ticket);
//            }
//        }
//
//        throw new NotYetImplementedException(status.value, newTicketStatus, isCurrentUserAnExecutor);
//    }
//
//    @Override
//    public StatusesEnum getStatus() {
//        return status;
//    }
//}
