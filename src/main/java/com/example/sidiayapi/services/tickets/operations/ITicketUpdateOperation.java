package com.example.sidiayapi.services.tickets.operations;

import com.example.sidiayapi.entities.Tickets;
import com.example.sidiayapi.entities.Users;
import com.example.sidiayapi.enums.JobTitlesEnum;
import com.example.sidiayapi.enums.StatusesEnum;
import com.example.sidiayapi.exceptions.NotYetImplementedException;
import com.example.sidiayapi.exceptions.WrongCredentialsException;
import com.example.sidiayapi.exceptions.WrongParamsException;
import com.example.sidiayapi.repositories.TicketsRepository;
import com.example.sidiayapi.utils.Validator;

public interface ITicketUpdateOperation {
    default Tickets update(Tickets foundTicket,
                           Tickets newTicket,
                           TicketsRepository ticketsRepository,
                           Users sender) {
        throw new NotYetImplementedException("Status code " + getStatus().value + " not handled");
    }

    StatusesEnum getStatus();

    default void checkRequiredFields(Object... values) {
        if (Validator.anyNull(values)) {
            throw new WrongParamsException("Not all required fields are filled");
        }
    }

    default void checkForPermissions(JobTitlesEnum[] jobTitles, Integer currentUserJobTitle) {
        for (JobTitlesEnum jobTitle : jobTitles) if (jobTitle.value == currentUserJobTitle) return;
        throw new WrongCredentialsException("Access to perform this operation by the current user is denied");
    }
}
