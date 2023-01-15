package com.example.sidiayapi.controllers.ticketstate;

import com.example.sidiayapi.entities.TicketState;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface ITicketStateController {
    ResponseEntity<String> test();
    ResponseEntity<List<TicketState>> get(Map<String, Object> params);
    ResponseEntity<List<TicketState>> get(final int count);
}
