package com.example.sidiayapi.services;

import com.example.sidiayapi.entities.Tickets;
import com.example.sidiayapi.models.AddTicketParams;
import com.example.sidiayapi.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@Service
public class TicketService {
    @Autowired
    TicketRepository ticketRepository;

    public List<Tickets> get() {
        return ticketRepository.findAll();
    }

    public Boolean add(HashMap<String, Object> params) {
        ticketRepository.save(new Tickets());
        return true;
    }
}
