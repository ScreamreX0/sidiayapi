package com.example.sidiayapi.controllers.ticket;

import com.example.sidiayapi.entities.Tickets;
import com.example.sidiayapi.models.AddTicketParams;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.*;

public interface ITicketController {
    ResponseEntity<String> test();
    ResponseEntity<List<Tickets>> get();
    ResponseEntity<Boolean> add(HashMap<String, Object> params);
}
