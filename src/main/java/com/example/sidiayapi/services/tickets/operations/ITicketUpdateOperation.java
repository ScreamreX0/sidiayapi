package com.example.sidiayapi.services.tickets.operations;

import com.example.sidiayapi.entities.Tickets;
import com.example.sidiayapi.enums.StatusesEnum;
import com.example.sidiayapi.exceptions.NotYetImplementedException;
import com.example.sidiayapi.repositories.TicketsRepository;

public interface ITicketUpdateOperation {
    default Tickets update(Long senderId,
                           Tickets ticket,
                           Tickets newTicket,
                           TicketsRepository ticketsRepository) {
        throw new NotYetImplementedException("Status code " + getStatus().value + " not handled");
    }

    StatusesEnum getStatus();
}
