package com.example.sidiayapi.services.tickets.operations;

import com.example.sidiayapi.entities.Tickets;
import com.example.sidiayapi.enums.StatusesEnum;
import com.example.sidiayapi.exceptions.NotYetImplementedException;
import com.example.sidiayapi.exceptions.WrongParamsException;
import com.example.sidiayapi.repositories.TicketsRepository;
import com.example.sidiayapi.utils.Logger;
import com.example.sidiayapi.utils.Validator;


public final class TicketUpdateNew implements ITicketUpdateOperation {
    private final StatusesEnum status = StatusesEnum.NEW;

    @Override
    public Tickets update(Long senderId,
                          Tickets ticket,
                          Tickets newTicket,
                          TicketsRepository ticketsRepository) {
        if (Validator.anyNull(newTicket.getStatus())) {
            Logger.log("    ERROR. New ticket status is null");
            throw new WrongParamsException("    New ticket status is null");
        }

        Logger.log("    New ticket status: " + newTicket.getStatus());

        if (newTicket.getStatus() == StatusesEnum.DENIED.value) {
            if (Validator.anyNull(newTicket.getCompletedWork(), newTicket.getClosingDate())) {
                Logger.log("    ERROR. Completed work or closing date is null");
                throw new WrongParamsException("Completed work or closing date is null");
            }
            ticket.setCompletedWork(newTicket.getCompletedWork());
            ticket.setClosingDate(newTicket.getClosingDate());
        }

        if (newTicket.getStatus() != StatusesEnum.DENIED.value
                && newTicket.getStatus() != StatusesEnum.ACCEPTED.value) {
            Logger.log("    ERROR. Wrong status: " + newTicket.getStatus());
            throw new NotYetImplementedException("Status not yet implemented");
        }

        ticket.setStatus(newTicket.getStatus());
        return ticketsRepository.save(ticket);
    }

    @Override
    public StatusesEnum getStatus() {
        return status;
    }
}
