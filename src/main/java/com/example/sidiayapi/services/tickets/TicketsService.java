package com.example.sidiayapi.services.tickets;

import com.example.sidiayapi.entities.Tickets;
import com.example.sidiayapi.enums.StatusesEnum;
import com.example.sidiayapi.exceptions.ApiExceptions;
import com.example.sidiayapi.repositories.TicketsRepository;
import com.example.sidiayapi.services.tickets.operations.ITicketUpdateOperation;
import com.example.sidiayapi.services.tickets.operations.TicketUpdateNotFormed;
import com.example.sidiayapi.utils.Logger;
import com.example.sidiayapi.utils.Validator;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class TicketsService {
    TicketsRepository ticketsRepository;
    final ObjectMapper mapper = new ObjectMapper();

    public TicketsService(TicketsRepository ticketsRepository) {
        this.ticketsRepository = ticketsRepository;
    }

    public List<Tickets> getByUserId(Long id) {
        Logger.log("Validating id");
        if (id < 0) {
            throw new ApiExceptions.WrongParamsException();
        }
        Logger.log("Id is correct");

        Logger.log("Sending sql request..");
        return ticketsRepository.findTicketsByUserId(id);
    }

    public void add(Map<String, Object> ticket) {
        Tickets newTicket = mapper.convertValue(ticket, Tickets.class);

        if (Validator.anyNull(
                newTicket.getFacilities(),
                newTicket.getEquipment(),
                newTicket.getTransport(),
                newTicket.getExecutorId(),
                newTicket.getBrigades())
        ) {
            newTicket.setStatus(StatusesEnum.NOT_FORMED.value);
        } else {
            newTicket.setStatus(StatusesEnum.NEW.value);
        }

        ticketsRepository.save(newTicket);
    }

    public ResponseEntity<Tickets> update(Long senderId, Tickets newTicket) {
        Logger.log("Checking ticket id..");
        if (newTicket.getId() == null) {
            Logger.log("Error. Ticket id is null.");
            throw new ApiExceptions.NotFoundException("Ticket not found");
        }

        Logger.log("Searching for ticket in db..");
        Optional<Tickets> ticketOptional = ticketsRepository.findById(newTicket.getId());
        if (ticketOptional.isEmpty()) {
            Logger.log("Error. Ticket not found");
            throw new ApiExceptions.NotFoundException("Ticket not found");
        }

        Logger.log("Ticket found.");
        Tickets ticket = ticketOptional.get();

        List<ITicketUpdateOperation> ticketUpdateOperations = new ArrayList<>();
        ticketUpdateOperations.add(new TicketUpdateNotFormed());

        for (ITicketUpdateOperation operation : ticketUpdateOperations) {
            if (operation.getStatus().value == ticket.getStatus()) {
                Logger.log("Ticket status: " + newTicket.getStatus() + ". Executing update operation..");
                return new ResponseEntity<>(operation.update(
                        senderId,
                        ticket,
                        newTicket,
                        ticketsRepository
                ), HttpStatus.OK);
            }
        }
        throw new ApiExceptions.NotYetHandled("Ticket status not yet handled");
    }
}
