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
    default Tickets update(Tickets foundTicket,
                           Tickets newTicket,
                           TicketsRepository ticketsRepository,
                           Long userId) {
        throw new NotYetImplementedException("Status code " + getStatus().value + " not handled");
    }

    StatusesEnum getStatus();

    default void checkParams(Long userId, Tickets ticket, Integer status) {
        if (ticket == null) throw new DataIntegrityViolationException("Ticket is null");
        if (ticket.getAuthor() == null) throw new DataIntegrityViolationException("Ticket has no author");
        if (userId == null) throw new WrongCredentialsException("Current user is unauthorized");
        if (status == null) throw new WrongParamsException("New status is null");
    }
}
