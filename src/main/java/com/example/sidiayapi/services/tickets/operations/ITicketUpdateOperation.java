package com.example.sidiayapi.services.tickets.operations;

import com.example.sidiayapi.entities.Tickets;
import com.example.sidiayapi.enums.StatusesEnum;
import com.example.sidiayapi.repositories.TicketsRepository;
import org.modelmapper.ModelMapper;

public interface ITicketUpdateOperation {
    Tickets update(Long senderId,
                   Tickets foundTicket,
                   TicketDTO ticketUpdatesMap,
                   TicketsRepository ticketsRepository,
                   ModelMapper mapper);

    StatusesEnum getStatus();
}
