package com.example.sidiayapi.services;

import com.example.sidiayapi.entities.TicketKind;
import com.example.sidiayapi.repositories.TicketKindRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketKindService {
    @Autowired
    TicketKindRepository ticketKindRepository;

    public ResponseEntity<List<TicketKind>> get(int count) {
        List<TicketKind> ticketKinds = ticketKindRepository.findAll();

        if (count < 1) {
            return new ResponseEntity<>(ticketKinds, HttpStatusCode.valueOf(200));
        } else {
            // Получение среза массива
            return new ResponseEntity<>(
                    ticketKinds.subList(0, Math.min(count, ticketKinds.size())),
                    HttpStatusCode.valueOf(200)
            );
        }
    }
}
