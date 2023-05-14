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
    private final MaterialsRepository materialsRepository;

    public TicketsService(TicketsRepository ticketsRepository,
                          UsersRepository usersRepository,
                          EquipmentRepository equipmentRepository,
                          FacilitiesRepository facilitiesRepository,
                          TransportRepository transportRepository,
                          MaterialsRepository materialsRepository,
                          SectorsRepository sectorsRepository) {
        this.ticketsRepository = ticketsRepository;
        this.usersRepository = usersRepository;
        this.equipmentRepository = equipmentRepository;
        this.facilitiesRepository = facilitiesRepository;
        this.transportRepository = transportRepository;
        this.materialsRepository = materialsRepository;
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
        // TODO("implement ticket addition")
        throw new NotYetImplementedException("Adding new ticket not implemented");
//        if (Validator.anyNull(
//                ticket.getFacilities(),
//                ticket.getService(),
//                ticket.getKind(),
//                ticket.getPlaneDate(),
//                ticket.getPriority(),
//                ticket.getExecutors())
//        ) {
//            ticket.setStatus(StatusesEnum.NOT_FORMED.value);
//        } else {
//            ticket.setStatus(StatusesEnum.NEW.value);
//        }
//
//        ticket.setCreationDate(LocalDate.now());
//
//        return ticketsRepository.save(ticket);
    }

    public Tickets update(Tickets newTicket, Long userId) {
        // TODO("implement ticket update")
        Tickets ticket = findTicketById(newTicket.getId());

        List<ITicketUpdateOperation> ticketUpdateOperations = Arrays.asList(
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

        ITicketUpdateOperation operation = ticketUpdateOperations
                .stream()
                .filter(op -> op.getStatus().value == ticket.getStatus())
                .findFirst()
                .orElseThrow(() -> new NotYetImplementedException("Ticket status not yet handled"));

        Logger.log("\nNew ticket status: " + newTicket.getStatus() + "."
                + "\n   Found ticket status: " + ticket.getStatus()
                + "\n   Executing update operation..");
        return operation.update(ticket, newTicket, ticketsRepository, userId);
    }


    public TicketData getData(Long userId) {
        // TODO("implement ticket data selection by user id")

        return new TicketData(
                usersRepository.findAll(),
                equipmentRepository.findAll(),
                facilitiesRepository.findAll(),
                transportRepository.findAll(),
                materialsRepository.findAll()
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
