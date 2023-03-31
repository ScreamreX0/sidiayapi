package com.example.sidiayapi.services.tickets.operations;

import com.example.sidiayapi.entities.Tickets;
import com.example.sidiayapi.enums.StatusesEnum;
import com.example.sidiayapi.exceptions.NotYetImplementedException;
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
        // Allowed new statuses
        List<Integer> allowedNewStatuses = Arrays.asList(
                StatusesEnum.COMPLETED.value,
                StatusesEnum.SUSPENDED.value
        );

        if (Validator.anyNull(newTicket.getStatus())) {
            Logger.log("    ERROR. New ticket status is null");
            throw new WrongParamsException("    New ticket status is null");
        } else if (!allowedNewStatuses.contains(newTicket.getStatus())) {
            Logger.log("    ERROR. Wrong status: " + newTicket.getStatus()
                    + ". Allowed values: " + Helper.arrToStr(allowedNewStatuses));
            throw new NotYetImplementedException("Status not yet implemented");
        }

        Logger.log("    New ticket status: " + newTicket.getStatus());

        if (newTicket.getStatus() == StatusesEnum.COMPLETED.value) {
            if (Validator.anyNull(newTicket.getCompletedWork(), newTicket.getClosingDate())) {
                Logger.log("    ERROR. Completed work or closing date is null");
                throw new WrongParamsException("Completed work or closing date is null");
            }
            ticket.setCompletedWork(newTicket.getCompletedWork());
            ticket.setClosingDate(newTicket.getClosingDate());
        }

        ticket.setStatus(newTicket.getStatus());

        return ticketsRepository.save(ticket);
    }

    @Override
    public StatusesEnum getStatus() {
        return status;
    }
}
