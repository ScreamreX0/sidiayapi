package com.example.sidiayapi.services.tickets.operations;

import com.example.sidiayapi.entities.Tickets;
import com.example.sidiayapi.enums.StatusesEnum;
import com.example.sidiayapi.exceptions.NotFoundException;
import com.example.sidiayapi.exceptions.NotYetImplementedException;
import com.example.sidiayapi.exceptions.WrongParamsException;
import com.example.sidiayapi.repositories.TicketsRepository;
import org.springframework.dao.DataIntegrityViolationException;

public interface ITicketUpdateOperation {
    default Tickets update(Tickets ticket,
                           Tickets newTicket,
                           TicketsRepository ticketsRepository,
                           Long userId) {
        throw new NotYetImplementedException("Status code " + getStatus().value + " not handled");
    }

    StatusesEnum getStatus();
    default Boolean isCurrentUserExecutor(Long userId, Tickets ticket) {
        if (ticket == null || ticket.getExecutor_id() == null || ticket.getAuthor_id() == null) {
            throw new DataIntegrityViolationException("Ticket has no author or executor");
        }

        if (ticket.getExecutor_id().getId().equals(userId)) {
            return true;
        } else if (ticket.getAuthor_id().getId().equals(userId)) {
            return false;
        } else {
            return null;
        }
    }
}
