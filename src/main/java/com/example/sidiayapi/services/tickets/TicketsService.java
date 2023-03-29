package com.example.sidiayapi.services.tickets;

import com.example.sidiayapi.entities.Tickets;
import com.example.sidiayapi.exceptions.ApiExceptions;
import com.example.sidiayapi.repositories.TicketsRepository;
import com.example.sidiayapi.utils.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TicketsService {
    TicketsRepository ticketsRepository;
    final ModelMapper modelMapper = new ModelMapper();

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
//        Tickets newTicket = mapper.convertValue(ticket, Tickets.class);
//
//        if (Validator.anyNull(
//                newTicket.getFacilities(),
//                newTicket.getEquipment(),
//                newTicket.getTransport(),
//                newTicket.getExecutorId(),
//                newTicket.getBrigades())
//        ) {
//            newTicket.setStatus(StatusesEnum.NOT_FORMED.value);
//        } else {
//            newTicket.setStatus(StatusesEnum.NEW.value);
//        }
//
//        ticketsRepository.save(newTicket);
    }

//    public ResponseEntity<Tickets> update(Long senderId,
//                                          Long id,
//                                          TicketDTO ticketDto,
//                                          Integer ticketStatus) {
//        Logger.log("Searching for ticket in db..");
//        Optional<Tickets> ticketOptional = ticketsRepository.findById(id);
//        if (ticketOptional.isEmpty()) throw new ApiExceptions.NotFoundException("Ticket not found");
//
//        Logger.log("Ticket found.");
//        Tickets foundTicket = ticketOptional.get();
//
//        List<ITicketUpdateOperation> ticketUpdateOperations = new ArrayList<>();
//        ticketUpdateOperations.add(new TicketUpdateNotFormed());
//
//        for (ITicketUpdateOperation operation : ticketUpdateOperations) {
//            if (operation.getStatus().value == ticketStatus) {
//                Logger.log("Ticket status: " + ticketStatus + ". Executing update operation..");
//                return new ResponseEntity<>(operation.update(
//                        senderId,
//                        foundTicket,
//                        ticketDto,
//                        ticketsRepository,
//                        modelMapper
//                ), HttpStatus.OK);
//            }
//        }
//        throw new ApiExceptions.NotYetHandled("Ticket status not yet handled");
//    }
}
