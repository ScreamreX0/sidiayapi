package com.example.sidiayapi.services.tickets;

import com.example.sidiayapi.dto.TicketData;
import com.example.sidiayapi.entities.Tickets;
import com.example.sidiayapi.enums.StatusesEnum;
import com.example.sidiayapi.exceptions.NotFoundException;
import com.example.sidiayapi.exceptions.NotYetImplementedException;
import com.example.sidiayapi.exceptions.WrongParamsException;
import com.example.sidiayapi.repositories.*;
import com.example.sidiayapi.services.tickets.operations.*;
import com.example.sidiayapi.utils.Logger;
import com.example.sidiayapi.utils.Validator;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class TicketsService {
    private final TicketsRepository ticketsRepository;
    private final UsersRepository usersRepository;
    private final EquipmentRepository equipmentRepository;
    private final FacilitiesRepository facilitiesRepository;
    private final KindsRepository kindsRepository;
    private final PrioritiesRepository prioritiesRepository;
    private final ServicesRepository servicesRepository;
    private final TransportRepository transportRepository;

    public TicketsService(TicketsRepository ticketsRepository,
                          UsersRepository usersRepository,
                          EquipmentRepository equipmentRepository,
                          FacilitiesRepository facilitiesRepository,
                          KindsRepository kindsRepository,
                          PrioritiesRepository prioritiesRepository,
                          ServicesRepository servicesRepository,
                          TransportRepository transportRepository) {
        this.ticketsRepository = ticketsRepository;
        this.usersRepository = usersRepository;
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

    public Tickets add(Tickets ticket) {
        if (Validator.anyNull(
                ticket.getFacilities(),
                ticket.getService(),
                ticket.getKind(),
                ticket.getPlane_date(),
                ticket.getPriority(),
                ticket.getExecutor_id())
        ) {
            ticket.setStatus(StatusesEnum.NOT_FORMED.value);
        } else {
            ticket.setStatus(StatusesEnum.NEW.value);
        }

        ticket.setCreation_date(LocalDate.now());

        return ticketsRepository.save(ticket);
    }

    public Tickets update(Tickets newTicket, Long userId) {
        Tickets ticket = checkTicketId(newTicket.getId());

        List<ITicketUpdateOperation> ticketUpdateOperations = Arrays.asList(
                new TicketUpdateNotFormed(),
                new TicketUpdateNew(),
                new TicketUpdateAccepted(),
                new TicketUpdateClosed(),
                new TicketUpdateDenied(),
                new TicketUpdateCompleted(),
                new TicketUpdateSuspended(),
                new TicketUpdateForRevision()
        );

        ITicketUpdateOperation operation = ticketUpdateOperations
                .stream()
                .filter(op -> op.getStatus().value == ticket.getStatus())
                .findFirst()
                .orElseThrow(() -> new NotYetImplementedException("Ticket status not yet handled"));

        Logger.log("Ticket status: " + newTicket.getStatus() + ". Executing update operation..");
        return operation.update(ticket, newTicket, ticketsRepository, userId);
    }


    public TicketData getData() {
        return new TicketData(
                usersRepository.findAll(),
                equipmentRepository.findAll(),
                facilitiesRepository.findAll(),
                kindsRepository.findAll(),
                prioritiesRepository.findAll(),
                servicesRepository.findAll(),
                transportRepository.findAll()
        );
    }

    private Tickets checkTicketId(Long id) {
        if (id == null) {
            Logger.log("Error. Ticket id is null.");
            throw new NotFoundException("Ticket not found");
        }
        Logger.log("Searching for ticket in db..");
        Optional<Tickets> ticketOptional = ticketsRepository.findById(id);
        if (ticketOptional.isEmpty()) {
            Logger.log("Error. Ticket not found");
            throw new NotFoundException("Ticket not found");
        }
        Logger.log("Ticket found.");
        return ticketOptional.get();
    }
}
