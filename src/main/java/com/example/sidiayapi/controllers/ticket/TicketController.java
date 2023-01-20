package com.example.sidiayapi.controllers.ticket;

import com.example.sidiayapi.entities.Tickets;
import com.example.sidiayapi.models.AddTicketParams;
import com.example.sidiayapi.services.TicketService;
import com.example.sidiayapi.utils.Logger;
import com.example.sidiayapi.utils.NetworkStates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/tickets")
public class TicketController implements ITicketController {
    @Autowired
    TicketService ticketService;

    private final String logTitle = TicketController.class.toString();

    @Override
    @GetMapping
    public ResponseEntity<String> test() {
        try {
            return ResponseEntity.ok(null);
        } catch (Exception exception) {
            Logger.log(logTitle, exception.getStackTrace());
            return new ResponseEntity<>("", NetworkStates.BadRequest.getCode());
        }
    }

    @Override
    @PostMapping("/")
    public ResponseEntity<List<Tickets>> get() {
        return new ResponseEntity<>(ticketService.get(), HttpStatus.OK);
    }

    @Override
    @PostMapping("/add")
    public ResponseEntity<Boolean> add(HashMap<String, Object> params) {
        return new ResponseEntity<>(ticketService.add(params), HttpStatus.OK);
    }
}
