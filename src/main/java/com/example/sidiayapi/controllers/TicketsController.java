package com.example.sidiayapi.controllers;

import com.example.sidiayapi.dto.TicketData;
import com.example.sidiayapi.entities.Tickets;
import com.example.sidiayapi.services.tickets.TicketsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tickets")
public class TicketsController {
    TicketsService ticketsService;

    public TicketsController(TicketsService ticketsService) {
        this.ticketsService = ticketsService;
    }

    @GetMapping("/get-by-id/{id}")
    public ResponseEntity<List<Tickets>> getById(@PathVariable Long id) {
        return new ResponseEntity<>(ticketsService.getByUserId(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Tickets> add(@RequestBody Tickets ticket) {
        return new ResponseEntity<>(ticketsService.add(ticket), HttpStatus.OK);
    }

    @PostMapping("/update/{currentUserId}")
    public ResponseEntity<Tickets> update(@RequestBody Tickets ticket, @PathVariable Long currentUserId) {
        return new ResponseEntity<>(ticketsService.update(ticket, currentUserId), HttpStatus.OK);
    }

    @GetMapping("/get-data/{currentUserId}")
    public ResponseEntity<TicketData> getData(@PathVariable Long currentUserId) {
        return new ResponseEntity<>(ticketsService.getData(currentUserId), HttpStatus.OK);
    }

    @GetMapping("/get-history/{currentUserId}")
    public ResponseEntity<List<Tickets>> getHistory(@PathVariable Long currentUserId) {
        return new ResponseEntity<>(ticketsService.getHistory(currentUserId), HttpStatus.OK);
    }
}

