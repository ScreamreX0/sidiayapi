package com.example.sidiayapi.services;

import com.example.sidiayapi.entities.TicketStates;
import com.example.sidiayapi.repositories.TicketStateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketStateService {
    @Autowired
    TicketStateRepository ticketStateRepository;

    public ResponseEntity<List<TicketStates>> get(int count) {
        List<TicketStates> ticketStates = ticketStateRepository.findAll();

        if (count < 1) {
            return new ResponseEntity<>(ticketStates, HttpStatusCode.valueOf(200));
        } else {
            // Получение среза массива
            return new ResponseEntity<>(
                    ticketStates.subList(0, Math.min(count, ticketStates.size())),
                    HttpStatusCode.valueOf(200)
            );
        }
    }
}
