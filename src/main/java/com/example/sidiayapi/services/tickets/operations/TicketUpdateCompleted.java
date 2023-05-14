package com.example.sidiayapi.services.tickets.operations;

import com.example.sidiayapi.entities.Tickets;
import com.example.sidiayapi.entities.Users;
import com.example.sidiayapi.enums.StatusesEnum;
import com.example.sidiayapi.exceptions.NotYetImplementedException;
import com.example.sidiayapi.exceptions.WrongParamsException;
import com.example.sidiayapi.repositories.TicketsRepository;
import com.example.sidiayapi.utils.Logger;


public final class TicketUpdateCompleted implements ITicketUpdateOperation {
    private final StatusesEnum status = StatusesEnum.COMPLETED;

    @Override
    public Tickets update(Tickets foundTicket,
                          Tickets newTicket,
                          TicketsRepository ticketsRepository,
                          Users sender) {
        throw new NotYetImplementedException("Status code " + getStatus().value + " not handled");
//        Integer newTicketStatus = newTicket.getStatus();
//        checkFields(userId, ticket, newTicketStatus);
//        boolean isCurrentUserAnExecutor = isUserAnExecutor(userId, ticket);
//
//        if (!isCurrentUserAnExecutor) {
//            if (newTicketStatus == StatusesEnum.FOR_REVISION.value) {
//                if (newTicket.getImprovementComment() == null) {
//                    Logger.log("Improvement reason is null");
//                    throw new WrongParamsException("Improvement reason is null");
//                }
//                ticket.setImprovementComment(newTicket.getImprovementComment());
//            } else if (newTicketStatus == StatusesEnum.CLOSED.value) {
//                updateTicketField(newTicketStatus, ticket::setStatus, "status");
//                updateTicketField(newTicket.getClosingDate(), ticket::setClosingDate, "closing_date");
//                return ticketsRepository.save(ticket);
//            }
//        }
//
//        throw new NotYetImplementedException(status.value, newTicketStatus, isCurrentUserAnExecutor);
    }

    @Override
    public StatusesEnum getStatus() {
        return status;
    }
}
