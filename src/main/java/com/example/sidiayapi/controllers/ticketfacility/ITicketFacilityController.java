package com.example.sidiayapi.controllers.ticketfacility;

import com.example.sidiayapi.entities.TicketsFacilities;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface ITicketFacilityController {
    ResponseEntity<String> test();
    ResponseEntity<List<TicketsFacilities>> get(Map<String, Object> params);
    ResponseEntity<List<TicketsFacilities>> get(final int count);
}
