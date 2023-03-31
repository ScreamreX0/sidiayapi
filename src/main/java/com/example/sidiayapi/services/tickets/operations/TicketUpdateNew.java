package com.example.sidiayapi.services.tickets.operations;

import com.example.sidiayapi.entities.Tickets;
import com.example.sidiayapi.enums.StatusesEnum;
import com.example.sidiayapi.exceptions.NotYetImplementedException;
import com.example.sidiayapi.exceptions.WrongParamsException;
import com.example.sidiayapi.repositories.TicketsRepository;
import com.example.sidiayapi.utils.Helper;
import com.example.sidiayapi.utils.Logger;
import com.example.sidiayapi.utils.Validator;
import org.springframework.util.StringUtils;
import org.yaml.snakeyaml.util.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public final class TicketUpdateNew implements ITicketUpdateOperation {
    private final StatusesEnum status = StatusesEnum.NEW;

    @Override
    public Tickets update(Long senderId,
                          Tickets ticket,
                          Tickets newTicket,
                          TicketsRepository ticketsRepository) {
        List<Integer> allowedNewStatuses = Arrays.asList(StatusesEnum.DENIED.value, StatusesEnum.ACCEPTED.value);

        Helper.checkNewTicketStatus(allowedNewStatuses, newTicket.getStatus());

        Logger.log("    New ticket status: " + newTicket.getStatus());

        if (newTicket.getStatus() == StatusesEnum.DENIED.value) {
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
