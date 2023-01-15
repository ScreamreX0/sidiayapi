package com.example.sidiayapi.controllers.tickettype;

import com.example.sidiayapi.entities.TicketType;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface ITicketTypeController {
    ResponseEntity<String> test();
    ResponseEntity<List<TicketType>> get(Map<String, Object> params);
    ResponseEntity<List<TicketType>> get(final int count);
}
