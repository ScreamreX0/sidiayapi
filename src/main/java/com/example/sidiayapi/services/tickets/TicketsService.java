package com.example.sidiayapi.services.tickets;

import com.example.sidiayapi.dto.TicketData;
import com.example.sidiayapi.entities.*;
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
    private final TransportRepository transportRepository;

    private final List<ITicketUpdateOperation> ticketUpdateOperations = Arrays.asList(
            new TicketUpdateNew(),
            new TicketUpdateEvaluated(),
            new TicketUpdateDenied(),
            new TicketUpdateAccepted(),
            new TicketUpdateSuspended(),
            new TicketUpdateCompleted(),
            new TicketUpdateQualityChecking(),
            new TicketUpdateClosed(),
            new TicketUpdateForRevision()
    );

    public TicketsService(TicketsRepository ticketsRepository,
                          UsersRepository usersRepository,
                          EquipmentRepository equipmentRepository,
                          FacilitiesRepository facilitiesRepository,
                          TransportRepository transportRepository) {
        this.ticketsRepository = ticketsRepository;
        this.usersRepository = usersRepository;
        this.equipmentRepository = equipmentRepository;
        this.facilitiesRepository = facilitiesRepository;
        this.transportRepository = transportRepository;
    }

    public List<Tickets> getByUserId(Long id) {
        // TODO("Implement")

        Logger.log("Validating id");
        if (id < 0) {
            throw new WrongParamsException();
        }
        Logger.log("Id is correct");

        Logger.log("Sending sql request..");
        return ticketsRepository.findTicketsByUserId(id);
    }

    public Tickets add(Tickets ticket) {
        Tickets newTicket = new Tickets();

        if (Validator.anyNull(
                ticket.getAuthor(),
                ticket.getFacilities(),
                ticket.getTicketName(),
                ticket.getDescriptionOfWork(),
                ticket.getKind(),
                ticket.getService()
        )) {
            throw new WrongParamsException("Not all required fields are filled");
        }

        newTicket.setStatus(StatusesEnum.NEW.value);
        newTicket.setAuthor(ticket.getAuthor());
        newTicket.setCreationDate(LocalDate.now());
        newTicket.setTicketName(ticket.getTicketName());
        newTicket.setDescriptionOfWork(ticket.getDescriptionOfWork());
        newTicket.setKind(ticket.getKind());
        newTicket.setService(ticket.getService());
        newTicket.setFacilities(ticket.getFacilities());
        newTicket.setEquipment(ticket.getEquipment());
        newTicket.setTransport(ticket.getTransport());

        return ticketsRepository.save(newTicket);
    }

    public Tickets update(Tickets newTicket, Long userId) {
        Tickets foundTicket = findTicketById(newTicket.getId());
        ITicketUpdateOperation operation = ticketUpdateOperations
                .stream()
                .filter(itOperation -> itOperation.getStatus().value == foundTicket.getStatus())
                .findFirst()
                .orElseThrow(() -> new NotYetImplementedException("Ticket status not yet handled"));
        Logger.log("\nNew ticket status: " + newTicket.getStatus() + "."
                + "\n   Found ticket status: " + foundTicket.getStatus()
                + "\n   Executing update operation..");
        return operation.update(foundTicket, newTicket, ticketsRepository, userId);
    }


    public TicketData getData(Long userId) {
        // TODO("implement ticket data selection by user id")

        return new TicketData(
                usersRepository.findAll(),
                equipmentRepository.findAll(),
                facilitiesRepository.findAll(),
                transportRepository.findAll()
        );
    }

    private Tickets findTicketById(Long id) {
        if (id == null) throw new NotFoundException("Ticket not found");
        Logger.log("Searching for ticket in db..");
        Optional<Tickets> ticketOptional = ticketsRepository.findById(id);
        if (ticketOptional.isEmpty()) {
            Logger.log("Ticket not found");
            throw new NotFoundException("Ticket not found");
        }
        Logger.log("Ticket found.");
        return ticketOptional.get();
    }
}
