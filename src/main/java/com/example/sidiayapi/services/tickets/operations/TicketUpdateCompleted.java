package com.example.sidiayapi.services.tickets.operations;

import com.example.sidiayapi.entities.Tickets;
import com.example.sidiayapi.entities.Users;
import com.example.sidiayapi.enums.JobTitlesEnum;
import com.example.sidiayapi.enums.StatusesEnum;
import com.example.sidiayapi.exceptions.NotYetImplementedException;
import com.example.sidiayapi.repositories.TicketsRepository;


public final class TicketUpdateCompleted implements ITicketUpdateOperation {
    private final StatusesEnum status = StatusesEnum.COMPLETED;

    @Override
    public Tickets update(Tickets foundTicket,
                          Tickets newTicket,
                          TicketsRepository ticketsRepository,
                          Users sender) {
        checkForPermissions(new JobTitlesEnum[]{JobTitlesEnum.SECTION_CHIEF}, sender.getEmployee().getJobTitle());
        Integer newTicketStatus = newTicket.getStatus();
        if (newTicketStatus == StatusesEnum.QUALITY_CHECKING.value) {
            checkRequiredFields(newTicket.getQualityControllers());
            foundTicket.setQualityControllers(newTicket.getQualityControllers());
            foundTicket.setStatus(StatusesEnum.QUALITY_CHECKING.value);
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
