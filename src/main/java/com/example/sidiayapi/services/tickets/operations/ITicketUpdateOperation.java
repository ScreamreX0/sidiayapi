package com.example.sidiayapi.services.tickets.operations;

import com.example.sidiayapi.entities.Tickets;
import com.example.sidiayapi.enums.StatusesEnum;
import com.example.sidiayapi.exceptions.NotYetImplementedException;
import com.example.sidiayapi.exceptions.WrongCredentialsException;
import com.example.sidiayapi.exceptions.WrongParamsException;
import com.example.sidiayapi.repositories.TicketsRepository;
import com.example.sidiayapi.utils.Logger;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.function.Consumer;

public interface ITicketUpdateOperation {
    default Tickets update(Tickets ticket,
                           Tickets newTicket,
                           TicketsRepository ticketsRepository,
                           Long userId) {
        throw new NotYetImplementedException("Status code " + getStatus().value + " not handled");
    }

    StatusesEnum getStatus();

    default <T> void updateTicketField(T newValue, Consumer<T> setter, String fieldName) {
        if (newValue != null) {
            Logger.log("Updating " + fieldName + "..");
            setter.accept(newValue);
        }
    }

    default void checkFields(Long userId, Tickets ticket, Integer status) {
        if (ticket == null) throw new DataIntegrityViolationException("Ticket is null");
        if (ticket.getExecutor_id() == null) throw new DataIntegrityViolationException("Ticket has no executor");
        if (ticket.getAuthor_id() == null) throw new DataIntegrityViolationException("Ticket has no author");
        if (userId == null) throw new WrongCredentialsException("Current user is unauthorized");
        if (!ticket.getExecutor_id().getId().equals(userId) && !ticket.getAuthor_id().getId().equals(userId)) throw new WrongCredentialsException("Current user is neither the author nor the executor");
        if (status == null) throw new WrongParamsException("New status is null");
    }

    default Boolean isUserAnExecutor(Long userId, Tickets ticket) {
        try {
            if (ticket.getAuthor_id().getId().equals(userId)) {
                return false;
            } else if (ticket.getExecutor_id().getId().equals(userId)) {
                return true;
            } else {
                throw new NullPointerException();
            }
        } catch (NullPointerException e) {
            throw new DataIntegrityViolationException("Ticket has no executor or author");
        }
    }
}
