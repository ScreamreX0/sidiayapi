package com.example.sidiayapi.services.tickets.operations;

import com.example.sidiayapi.entities.Tickets;
import com.example.sidiayapi.entities.Users;
import com.example.sidiayapi.enums.StatusesEnum;
import com.example.sidiayapi.exceptions.NotYetImplementedException;
import com.example.sidiayapi.exceptions.WrongParamsException;
import com.example.sidiayapi.repositories.TicketsRepository;
import com.example.sidiayapi.utils.Logger;
import com.example.sidiayapi.utils.Validator;

public final class TicketUpdateNew implements ITicketUpdateOperation {
    private final StatusesEnum status = StatusesEnum.NEW;

    @Override
    public Tickets update(Tickets foundTicket,
                          Tickets newTicket,
                          TicketsRepository ticketsRepository,
                          Users sender) {
        Integer newTicketStatus = newTicket.getStatus();
        checkParams(foundTicket, newTicketStatus);

        if (newTicketStatus == StatusesEnum.EVALUATED.value) {
            if (Validator.anyNull(
                    newTicket.getPriority(),
                    newTicket.getAssessedValue(),
                    newTicket.getAssessedValueDescription()
            )) {
                throw new WrongParamsException("Not all required fields are filled");
            }

            foundTicket.setPriority(newTicket.getPriority());
            foundTicket.setAssessedValue(newTicket.getAssessedValue());
            foundTicket.setAssessedValueDescription(newTicket.getAssessedValueDescription());
            foundTicket.setStatus(StatusesEnum.EVALUATED.value);
            return ticketsRepository.save(foundTicket);
        } else if (newTicketStatus == StatusesEnum.CANCELED.value) {
            foundTicket.setStatus(StatusesEnum.CANCELED.value);
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
