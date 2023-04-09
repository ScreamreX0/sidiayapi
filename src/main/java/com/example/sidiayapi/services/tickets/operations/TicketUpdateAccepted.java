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


public final class TicketUpdateAccepted implements ITicketUpdateOperation {
    private final StatusesEnum status = StatusesEnum.ACCEPTED;

    @Override
    public Tickets update(Long senderId,
                          Tickets ticket,
                          Tickets newTicket,
                          TicketsRepository ticketsRepository) {
        List<Integer> allowedNewStatuses = Arrays.asList(
                StatusesEnum.COMPLETED.value,
                StatusesEnum.SUSPENDED.value
        );

        Helper.checkNewTicketStatus(allowedNewStatuses, newTicket.getStatus());

        Logger.log("    New ticket status: " + newTicket.getStatus());

        if (newTicket.getStatus() == StatusesEnum.COMPLETED.value) {
            if (Validator.anyNull(newTicket.getCompleted_work(), newTicket.getClosing_date())) {
                Logger.log("    ERROR. Completed work or closing date is null");
                throw new WrongParamsException("Completed work or closing date is null");
            }
            ticket.setCompleted_work(newTicket.getCompleted_work());
            ticket.setClosing_date(newTicket.getClosing_date());
        }

        ticket.setStatus(newTicket.getStatus());

        return ticketsRepository.save(ticket);
    }

    @Override
    public StatusesEnum getStatus() {
        return status;
    }
}
