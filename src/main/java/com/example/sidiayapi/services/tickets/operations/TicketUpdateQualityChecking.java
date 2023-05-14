package com.example.sidiayapi.services.tickets.operations;

import com.example.sidiayapi.entities.Tickets;
import com.example.sidiayapi.entities.Users;
import com.example.sidiayapi.enums.StatusesEnum;
import com.example.sidiayapi.exceptions.NotYetImplementedException;
import com.example.sidiayapi.repositories.TicketsRepository;

import java.time.LocalDate;

public final class TicketUpdateQualityChecking implements ITicketUpdateOperation {
    private final StatusesEnum status = StatusesEnum.QUALITY_CHECKING;

    @Override
    public Tickets update(Tickets foundTicket,
                          Tickets newTicket,
                          TicketsRepository ticketsRepository,
                          Users sender) {
        Integer newTicketStatus = newTicket.getStatus();

        if (newTicketStatus == StatusesEnum.CLOSED.value) {
            foundTicket.setStatus(newTicket.getStatus());
            foundTicket.setStatus(StatusesEnum.CLOSED.value);
            foundTicket.setClosingDate(LocalDate.now());
            return ticketsRepository.save(foundTicket);
        } else if (newTicketStatus == StatusesEnum.FOR_REVISION.value) {
            checkRequiredFields(newTicket.getImprovementComment());
            foundTicket.setImprovementComment(newTicket.getImprovementComment());
            foundTicket.setStatus(StatusesEnum.FOR_REVISION.value);
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
