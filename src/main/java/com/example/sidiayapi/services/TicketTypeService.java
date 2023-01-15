package com.example.sidiayapi.services;

import com.example.sidiayapi.entities.TicketType;
import com.example.sidiayapi.repositories.TicketTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketTypeService {
    @Autowired
    TicketTypeRepository ticketTypeRepository;

    public ResponseEntity<List<TicketType>> get(int count) {
        List<TicketType> ticketTypes = ticketTypeRepository.findAll();

        if (count < 1) {
            return new ResponseEntity<>(ticketTypes, HttpStatusCode.valueOf(200));
        } else {
            // Получение среза массива
            return new ResponseEntity<>(
                    ticketTypes.subList(0, Math.min(count, ticketTypes.size())),
                    HttpStatusCode.valueOf(200)
            );
        }
    }
}
