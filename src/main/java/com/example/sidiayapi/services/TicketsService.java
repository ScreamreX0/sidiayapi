package com.example.sidiayapi.services;

import com.example.sidiayapi.entities.Tickets;
import com.example.sidiayapi.repositories.TicketsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class TicketsService {
    @Autowired
    TicketsRepository ticketsRepository;

    public List<Tickets> get() {
        return ticketsRepository.findAll();
    }

    public Boolean add(HashMap<String, Object> params) {
        ticketsRepository.save(new Tickets(

        ));
        return true;
    }
}
