package com.example.sidiayapi.controllers;

import com.example.sidiayapi.entities.Tickets;
import com.example.sidiayapi.repositories.TicketsRepository;
import com.example.sidiayapi.services.tickets.TicketsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/tickets")
public class TicketsController {
    TicketsService ticketsService;
    TicketsRepository ticketsRepository;

    public TicketsController(TicketsService ticketsService, TicketsRepository ticketsRepository) {
        this.ticketsService = ticketsService;
        this.ticketsRepository = ticketsRepository;
    }

    @GetMapping("/get-by-id/{id}")
    public ResponseEntity<List<Tickets>> get(@PathVariable Long id) {
        return new ResponseEntity<>(ticketsService.getByUserId(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Object> add(@RequestBody Map<String, Object> ticket) {
        ticketsService.add(ticket);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

//    @PostMapping("/update/{senderId}/{ticketId}/{ticketStatus}")
//    public ResponseEntity<Tickets> update(@PathVariable Long senderId,
//                                          @PathVariable Long ticketId,
//                                          @PathVariable Integer ticketStatus,
//                                          @RequestBody TicketDTO ticket) {
//        return ticketsService.update(senderId, ticketId, ticket, ticketStatus);
//    }
}

