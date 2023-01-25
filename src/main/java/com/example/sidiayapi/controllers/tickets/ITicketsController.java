package com.example.sidiayapi.controllers.tickets;

import com.example.sidiayapi.entities.Tickets;
import com.example.sidiayapi.models.AddTicketParams;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import java.util.*;

public interface ITicketsController {
    ResponseEntity<String> test();
    ResponseEntity<List<Tickets>> get();
    ResponseEntity<Boolean> add(AddTicketParams params, BindingResult bindingResult);
}
