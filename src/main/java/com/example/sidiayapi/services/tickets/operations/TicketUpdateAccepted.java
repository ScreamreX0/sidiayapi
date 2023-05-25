package com.example.sidiayapi.services.tickets.operations;

import com.example.sidiayapi.entities.Tickets;
import com.example.sidiayapi.entities.Users;
import com.example.sidiayapi.enums.StatusesEnum;
import com.example.sidiayapi.exceptions.NotYetImplementedException;
import com.example.sidiayapi.repositories.TicketsRepository;


public final class TicketUpdateAccepted implements ITicketUpdateOperation {
    private final StatusesEnum status = StatusesEnum.ACCEPTED;

    @Override
    public Tickets update(Tickets foundTicket,
                          Tickets newTicket,
                          TicketsRepository ticketsRepository,
                          Users sender) {
        Integer newTicketStatus = newTicket.getStatus();
        if (newTicketStatus == StatusesEnum.COMPLETED.value) {
            checkRequiredFields(newTicket.getCompletedWork());
            foundTicket.setCompletedWork(newTicket.getCompletedWork());
            foundTicket.setStatus(StatusesEnum.COMPLETED.value);
            return ticketsRepository.save(foundTicket);
        } else {
            throw new NotYetImplementedException("Not yet implemented. Current ticket status: " + getStatus());
        }
    }

    @Override
    public StatusesEnum getStatus() {
        return status;
    }
}
