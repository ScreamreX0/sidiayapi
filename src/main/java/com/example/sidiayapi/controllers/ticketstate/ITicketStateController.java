package com.example.sidiayapi.controllers.ticketstate;

import com.example.sidiayapi.entities.TicketStates;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface ITicketStateController {
    ResponseEntity<String> test();
    ResponseEntity<List<TicketStates>> get(Map<String, Object> params);
    ResponseEntity<List<TicketStates>> get(final int count);
}
