package com.example.sidiayapi.controllers.ticketkind;

import com.example.sidiayapi.entities.TicketKind;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface ITicketKindController {
    ResponseEntity<String> test();
    ResponseEntity<List<TicketKind>> get(Map<String, Object> params);
    ResponseEntity<List<TicketKind>> get(final int count);
}
