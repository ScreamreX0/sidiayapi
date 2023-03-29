package com.example.sidiayapi.services.tickets.operations;

import com.example.sidiayapi.entities.Tickets;
import com.example.sidiayapi.enums.StatusesEnum;
import com.example.sidiayapi.repositories.TicketsRepository;

public interface ITicketUpdateOperation {
    Tickets update(Long senderId,
                   Tickets ticket,
                   Tickets newTicket,
                   TicketsRepository ticketsRepository);

    StatusesEnum getStatus();
}
