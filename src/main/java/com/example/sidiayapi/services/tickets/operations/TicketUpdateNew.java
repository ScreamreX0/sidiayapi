package com.example.sidiayapi.services.tickets.operations;

import com.example.sidiayapi.entities.Tickets;
import com.example.sidiayapi.entities.Users;
import com.example.sidiayapi.enums.JobTitlesEnum;
import com.example.sidiayapi.enums.StatusesEnum;
import com.example.sidiayapi.exceptions.NotYetImplementedException;
import com.example.sidiayapi.repositories.TicketsRepository;

public final class TicketUpdateNew implements ITicketUpdateOperation {
    private final StatusesEnum status = StatusesEnum.NEW;

    @Override
    public Tickets update(Tickets foundTicket,
                          Tickets newTicket,
                          TicketsRepository ticketsRepository,
                          Users sender) {
        checkForPermissions(new JobTitlesEnum[]{JobTitlesEnum.DISPATCHER}, sender.getEmployee().getJobTitle());
        Integer newTicketStatus = newTicket.getStatus();
        if (newTicketStatus == StatusesEnum.EVALUATED.value) {
            checkRequiredFields(newTicket.getPriority(), newTicket.getAssessedValue(), newTicket.getAssessedValueDescription());
            foundTicket.setPriority(newTicket.getPriority());
            foundTicket.setAssessedValue(newTicket.getAssessedValue());
            foundTicket.setAssessedValueDescription(newTicket.getAssessedValueDescription());
            foundTicket.setDispatcher(sender);
            foundTicket.setStatus(StatusesEnum.EVALUATED.value);
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
