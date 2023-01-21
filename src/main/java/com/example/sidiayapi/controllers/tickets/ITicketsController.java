package com.example.sidiayapi.controllers.tickets;

import com.example.sidiayapi.entities.Tickets;
import org.springframework.http.ResponseEntity;

import java.util.*;

public interface ITicketsController {
    ResponseEntity<String> test();
    ResponseEntity<List<Tickets>> get();
    ResponseEntity<Boolean> add(HashMap<String, Object> params);
}
