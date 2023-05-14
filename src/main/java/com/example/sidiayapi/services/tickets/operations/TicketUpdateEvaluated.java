package com.example.sidiayapi.services.tickets.operations;

import com.example.sidiayapi.entities.Tickets;
import com.example.sidiayapi.entities.Users;
import com.example.sidiayapi.enums.StatusesEnum;
import com.example.sidiayapi.exceptions.NotYetImplementedException;
import com.example.sidiayapi.repositories.TicketsRepository;

public final class TicketUpdateEvaluated implements ITicketUpdateOperation {
    private final StatusesEnum status = StatusesEnum.EVALUATED;

    @Override
    public Tickets update(Tickets foundTicket,
                          Tickets newTicket,
                          TicketsRepository ticketsRepository,
                          Users sender) {
        Integer newTicketStatus = newTicket.getStatus();
        checkParams(foundTicket, newTicketStatus);

        if (newTicketStatus == StatusesEnum.SUSPENDED.value) {
            checkRequiredFields(newTicket.getReasonForSuspension());
            foundTicket.setReasonForSuspension(newTicket.getReasonForSuspension());
            foundTicket.setStatus(StatusesEnum.SUSPENDED.value);
            return ticketsRepository.save(foundTicket);
        } else if (newTicketStatus == StatusesEnum.ACCEPTED.value) {
            checkRequiredFields(newTicket.getExecutors(), newTicket.getPlaneDate());
            foundTicket.setExecutors(newTicket.getExecutors());
            foundTicket.setPlaneDate(newTicket.getPlaneDate());
            return ticketsRepository.save(foundTicket);
        } else if (newTicketStatus == StatusesEnum.REJECTED.value) {
            checkRequiredFields(newTicket.getReasonForRejection());
            foundTicket.setReasonForRejection(newTicket.getReasonForRejection());
            return ticketsRepository.save(foundTicket);
        } else if (newTicketStatus == StatusesEnum.CANCELED.value) {
            checkRequiredFields(newTicket.getReasonForCancellation());
            foundTicket.setReasonForCancellation(newTicket.getReasonForCancellation());
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