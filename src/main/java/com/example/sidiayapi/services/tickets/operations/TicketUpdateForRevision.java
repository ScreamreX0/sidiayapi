package com.example.sidiayapi.services.tickets.operations;

import com.example.sidiayapi.entities.Tickets;
import com.example.sidiayapi.entities.Users;
import com.example.sidiayapi.enums.StatusesEnum;
import com.example.sidiayapi.exceptions.NotYetImplementedException;
import com.example.sidiayapi.repositories.TicketsRepository;


public final class TicketUpdateForRevision implements ITicketUpdateOperation {
    private final StatusesEnum status = StatusesEnum.FOR_REVISION;

    @Override
    public Tickets update(Tickets foundTicket,
                          Tickets newTicket,
                          TicketsRepository ticketsRepository,
                          Users sender) {
        Integer newTicketStatus = newTicket.getStatus();
        if (newTicketStatus == StatusesEnum.ACCEPTED.value) {
            checkRequiredFields(newTicket.getExecutors(), newTicket.getPlaneDate());
            foundTicket.setExecutors(newTicket.getExecutors());
            foundTicket.setPlaneDate(newTicket.getPlaneDate());
            foundTicket.setStatus(StatusesEnum.ACCEPTED.value);
            return ticketsRepository.save(foundTicket);
        } else if (newTicketStatus == StatusesEnum.REJECTED.value) {
            checkRequiredFields(newTicket.getReasonForRejection());
            foundTicket.setReasonForRejection(newTicket.getReasonForRejection());
            foundTicket.setStatus(StatusesEnum.REJECTED.value);
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
