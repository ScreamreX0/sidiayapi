package com.example.sidiayapi.controllers.tickettype;

import com.example.sidiayapi.entities.TicketTypes;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface ITicketTypeController {
    ResponseEntity<String> test();
    ResponseEntity<List<TicketTypes>> get(Map<String, Object> params);
    ResponseEntity<List<TicketTypes>> get(final int count);
}
