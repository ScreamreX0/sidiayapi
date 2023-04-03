package com.example.sidiayapi.services.tickets;

import com.example.sidiayapi.dto.TicketData;
import com.example.sidiayapi.entities.Facilities;
import com.example.sidiayapi.entities.Kinds;
import com.example.sidiayapi.entities.Priorities;
import com.example.sidiayapi.entities.Tickets;
import com.example.sidiayapi.enums.StatusesEnum;
import com.example.sidiayapi.exceptions.NotFoundException;
import com.example.sidiayapi.exceptions.NotYetImplementedException;
import com.example.sidiayapi.exceptions.WrongParamsException;
import com.example.sidiayapi.repositories.*;
import com.example.sidiayapi.services.tickets.operations.*;
import com.example.sidiayapi.utils.Logger;
import com.example.sidiayapi.utils.Validator;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TicketsService {
    private final TicketsRepository ticketsRepository;
    private final EmployeesRepository employeesRepository;
    private final EquipmentRepository equipmentRepository;
    private final FacilitiesRepository facilitiesRepository;
    private final KindsRepository kindsRepository;
    private final PrioritiesRepository prioritiesRepository;
    private final ServicesRepository servicesRepository;
    private final TransportRepository transportRepository;
    private final ObjectMapper mapper = new ObjectMapper();

    public TicketsService(TicketsRepository ticketsRepository,
                          EmployeesRepository employeesRepository,
                          EquipmentRepository equipmentRepository,
                          FacilitiesRepository facilitiesRepository,
                          KindsRepository kindsRepository,
                          PrioritiesRepository prioritiesRepository,
                          ServicesRepository servicesRepository,
                          TransportRepository transportRepository) {
        this.ticketsRepository = ticketsRepository;
        this.employeesRepository = employeesRepository;
        this.equipmentRepository = equipmentRepository;
        this.facilitiesRepository = facilitiesRepository;
        this.kindsRepository = kindsRepository;
        this.prioritiesRepository = prioritiesRepository;
        this.servicesRepository = servicesRepository;
        this.transportRepository = transportRepository;
    }

    public List<Tickets> getByUserId(Long id) {
        Logger.log("Validating id");
        if (id < 0) {
            throw new WrongParamsException();
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
            throw new NotFoundException("Ticket not found");
        }

        Logger.log("Searching for ticket in db..");
        Optional<Tickets> ticketOptional = ticketsRepository.findById(newTicket.getId());
        if (ticketOptional.isEmpty()) {
            Logger.log("Error. Ticket not found");
            throw new NotFoundException("Ticket not found");
        }

        Logger.log("Ticket found.");
        Tickets ticket = ticketOptional.get();

        List<ITicketUpdateOperation> ticketUpdateOperations = Arrays.asList(
                new TicketUpdateNotFormed(),
                new TicketUpdateNew(),
                new TicketUpdateAccepted(),
                new TicketUpdateClosed(),
                new TicketUpdateDenied(),
                new TicketUpdateCompleted(),
                new TicketUpdateStopped(),
                new TicketUpdateForRevision()
        );

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
        throw new NotYetImplementedException("Ticket status not yet handled");
    }


    public TicketData getData() {
        return new TicketData(
                employeesRepository.findAll(),
                equipmentRepository.findAll(),
                facilitiesRepository.findAll(),
                kindsRepository.findAll(),
                prioritiesRepository.findAll(),
                servicesRepository.findAll(),
                transportRepository.findAll()
        );
    }
}
