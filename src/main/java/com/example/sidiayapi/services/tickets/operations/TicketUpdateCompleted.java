package com.example.sidiayapi.services.tickets.operations;

import com.example.sidiayapi.entities.Tickets;
import com.example.sidiayapi.enums.StatusesEnum;
import com.example.sidiayapi.exceptions.WrongParamsException;
import com.example.sidiayapi.repositories.TicketsRepository;
import com.example.sidiayapi.utils.Helper;
import com.example.sidiayapi.utils.Logger;
import com.example.sidiayapi.utils.Validator;

import java.util.Arrays;
import java.util.List;


public final class TicketUpdateCompleted implements ITicketUpdateOperation {
    private final StatusesEnum status = StatusesEnum.COMPLETED;

    @Override
    public Tickets update(Long senderId,
                          Tickets ticket,
                          Tickets newTicket,
                          TicketsRepository ticketsRepository) {
        List<Integer> allowedNewStatuses = Arrays.asList(
                StatusesEnum.FOR_REVISION.value,
                StatusesEnum.CLOSED.value
        );

        Helper.checkNewTicketStatus(allowedNewStatuses, newTicket.getStatus());

        Logger.log("    New ticket status: " + newTicket.getStatus());

        if (newTicket.getStatus() == StatusesEnum.FOR_REVISION.value) {
            if (Validator.anyNull(newTicket.getImprovement_reason())) {
                Logger.log("    ERROR. Improvement reason is null");
                throw new WrongParamsException("Improvement reason is null");
            }
            ticket.setImprovement_reason(newTicket.getImprovement_reason());
        }

        ticket.setStatus(newTicket.getStatus());

        return ticketsRepository.save(ticket);
    }

    @Override
    public StatusesEnum getStatus() {
        return status;
    }
}
