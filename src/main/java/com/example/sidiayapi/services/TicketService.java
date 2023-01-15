package com.example.sidiayapi.services;

import com.example.sidiayapi.entities.Ticket;
import com.example.sidiayapi.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {
    @Autowired
    TicketRepository ticketRepository;

    public ResponseEntity<List<Ticket>> get(int count) {
        List<Ticket> tickets = ticketRepository.findAll();

        if (count < 1) {
            return new ResponseEntity<>(tickets, HttpStatusCode.valueOf(200));
        } else {
            // Получение среза массива
            return new ResponseEntity<>(
                    tickets.subList(0, Math.min(count, tickets.size())),
                    HttpStatusCode.valueOf(200)
            );
        }
    }
}
