package com.example.sidiayapi.controllers.ticketkind;

import com.example.sidiayapi.entities.TicketKinds;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface ITicketKindController {
    ResponseEntity<String> test();
    ResponseEntity<List<TicketKinds>> get(Map<String, Object> params);
    ResponseEntity<List<TicketKinds>> get(final int count);
}
