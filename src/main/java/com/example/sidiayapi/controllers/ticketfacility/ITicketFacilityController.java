package com.example.sidiayapi.controllers.ticketfacility;

import com.example.sidiayapi.entities.TicketFacility;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface ITicketFacilityController {
    ResponseEntity<String> test();
    ResponseEntity<List<TicketFacility>> get(Map<String, Object> params);
    ResponseEntity<List<TicketFacility>> get(final int count);
}
