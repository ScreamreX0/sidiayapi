package com.example.sidiayapi.controllers;

import com.example.sidiayapi.dto.TicketData;
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
    public ResponseEntity<Tickets> add(@RequestBody Tickets ticket) {
        return new ResponseEntity<>(ticketsService.add(ticket), HttpStatus.OK);
    }

    @PostMapping("/update/{senderId}")
    public ResponseEntity<Tickets> update(@PathVariable Long senderId,
                                          @RequestBody Tickets ticket) {
        return ticketsService.update(senderId, ticket);
    }

    // Ticket data - data that used in ticket creating, updating, filtering components.
    @GetMapping("/get-data")
    public ResponseEntity<TicketData> get() {
        return new ResponseEntity<>(ticketsService.getData(), HttpStatus.OK);
    }
}

