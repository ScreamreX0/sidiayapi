package com.example.sidiayapi.services.tickets.operations;

import com.example.sidiayapi.entities.Tickets;
import com.example.sidiayapi.entities.Users;
import com.example.sidiayapi.enums.StatusesEnum;
import com.example.sidiayapi.exceptions.NotYetImplementedException;
import com.example.sidiayapi.exceptions.WrongParamsException;
import com.example.sidiayapi.repositories.TicketsRepository;
import com.example.sidiayapi.utils.Validator;
import org.springframework.dao.DataIntegrityViolationException;

public interface ITicketUpdateOperation {
    default Tickets update(Tickets foundTicket,
                           Tickets newTicket,
                           TicketsRepository ticketsRepository,
                           Users sender) {
        throw new NotYetImplementedException("Status code " + getStatus().value + " not handled");
    }

    StatusesEnum getStatus();

    default void checkParams(Tickets ticket, Integer status) {
        if (ticket == null) throw new DataIntegrityViolationException("Ticket is null");
        if (ticket.getAuthor() == null) throw new DataIntegrityViolationException("Ticket has no author");
        if (status == null) throw new WrongParamsException("New status is null");
    }

    default void checkRequiredFields(Object... values) {
        if (Validator.anyNull(values)) {
            throw new WrongParamsException("Not all required fields are filled");
        }
    }
}
