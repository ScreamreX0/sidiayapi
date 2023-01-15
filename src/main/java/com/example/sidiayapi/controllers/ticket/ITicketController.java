package com.example.sidiayapi.controllers.ticket;

import com.example.sidiayapi.entities.Ticket;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface ITicketController {
    ResponseEntity<String> test();
    ResponseEntity<List<Ticket>> get(Map<String, Object> params);
    ResponseEntity<List<Ticket>> get(final int count);
}
