//package com.example.sidiayapi.services.tickets.operations;
//
//import com.example.sidiayapi.entities.Tickets;
//import com.example.sidiayapi.enums.StatusesEnum;
//import com.example.sidiayapi.repositories.TicketsRepository;
//import com.example.sidiayapi.utils.Logger;
//import com.example.sidiayapi.utils.Validator;
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.BeanUtils;
//
//
//public final class TicketUpdateNotFormed implements ITicketUpdateOperation {
//    private final StatusesEnum status = StatusesEnum.NOT_FORMED;
//
//    @Override
//    public Tickets update(Long senderId,
//                          Tickets foundTicket,
//                          TicketDTO ticketUpdates,
//                          TicketsRepository ticketsRepository,
//                          ModelMapper mapper) {
//
//        Logger.log("    Updating fields with null-check");
//        Logger.log("    updating facilities..");
//        if (ticketUpdates.getFacilities() != null) {
//            BeanUtils.copyProperties();
//            foundTicket.setFacilities(ticketUpdates.getFacilities());
//        }
//        Logger.log("    Done. updating equipment..");
//        if (ticketUpdatesMap.getEquipment() != null) {
//            foundTicket.setEquipment(ticketUpdatesMap.getEquipment());
//        }
//        Logger.log("    Done. updating transport..");
//        if (ticketUpdatesMap.getTransport() != null) {
//            foundTicket.setTransport(ticketUpdatesMap.getTransport());
//        }
//        Logger.log("    Done. updating brigades..");
//        if (ticketUpdatesMap.getBrigades() != null) {
//            foundTicket.setBrigades(ticketUpdatesMap.getBrigades());
//        }
//        Logger.log("    Done. updating executor..");
//        if (ticketUpdatesMap.getExecutorId() != null) {
//            foundTicket.setExecutorId(ticketUpdatesMap.getExecutorId());
//        }
//
//        Logger.log("    Done.");
//        Logger.log("    Checking for all needed fields in ticket are not null..");
//        if (!Validator.anyNull(
//                foundTicket.getFacilities(),
//                foundTicket.getEquipment(),
//                foundTicket.getTransport(),
//                foundTicket.getExecutorId(),
//                foundTicket.getBrigades())
//        ) {
//            Logger.log("    All fields are not null. Updating ticket status..");
//            foundTicket.setStatus(StatusesEnum.NEW.value);
//        }
//        Logger.log("    Saving ticket..");
//        return ticketsRepository.save(foundTicket);
//    }
//    @Override
//    public StatusesEnum getStatus() {
//        return status;
//    }
//}
