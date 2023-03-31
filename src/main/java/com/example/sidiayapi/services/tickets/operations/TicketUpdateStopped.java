package com.example.sidiayapi.services.tickets.operations;

import com.example.sidiayapi.entities.Tickets;
import com.example.sidiayapi.enums.StatusesEnum;
import com.example.sidiayapi.exceptions.NotYetImplementedException;
import com.example.sidiayapi.exceptions.WrongParamsException;
import com.example.sidiayapi.repositories.TicketsRepository;
import com.example.sidiayapi.utils.Helper;
import com.example.sidiayapi.utils.Logger;
import com.example.sidiayapi.utils.Validator;

import java.util.List;


public final class TicketUpdateStopped implements ITicketUpdateOperation {
    private final StatusesEnum status = StatusesEnum.SUSPENDED;

    @Override
    public Tickets update(Long senderId,
                          Tickets ticket,
                          Tickets newTicket,
                          TicketsRepository ticketsRepository) {
        // Allowed new statuses
        List<Integer> allowedNewStatuses = List.of(StatusesEnum.ACCEPTED.value);

        if (Validator.anyNull(newTicket.getStatus())) {
            Logger.log("    ERROR. New ticket status is null");
            throw new WrongParamsException("    New ticket status is null");
        } else if (!allowedNewStatuses.contains(newTicket.getStatus())) {
            Logger.log("    ERROR. Wrong status: " + newTicket.getStatus()
                    + ". Allowed values: " + Helper.arrToStr(allowedNewStatuses));
            throw new NotYetImplementedException("Status not yet implemented");
        }

        Logger.log("    New ticket status: " + newTicket.getStatus());

        ticket.setStatus(newTicket.getStatus());

        return ticketsRepository.save(ticket);
    }

    @Override
    public StatusesEnum getStatus() {
        return status;
    }
}
