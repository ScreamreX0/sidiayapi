package com.example.sidiayapi.services;

import com.example.sidiayapi.entities.TicketKinds;
import com.example.sidiayapi.entities.Tickets;
import com.example.sidiayapi.entities.Users;
import com.example.sidiayapi.models.AddTicketParams;
import com.example.sidiayapi.repositories.TicketsKindsRepository;
import com.example.sidiayapi.repositories.TicketsRepository;
import com.example.sidiayapi.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;

@Service
public class TicketsService {
    @Autowired
    TicketsRepository ticketsRepository;

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    TicketsKindsRepository ticketsKindsRepository;

    public List<Tickets> get() {
        return ticketsRepository.findAll();
    }

    public Boolean add(AddTicketParams params) {
        Tickets ticket = new Tickets(
                params.getPriority(),
                params.getKind(),
                removeQuotes(params.getPlane_date()),
                removeQuotes(params.getExpiration_date()),
                removeQuotes(params.getCreation_date()),
                removeQuotes(params.getCompleted_work()),
                removeQuotes(params.getDescription()),
                removeQuotes(params.getName()),
                removeQuotes(params.getStatus()),
                removeQuotes(params.getService())
        );

        ticketsRepository.save(ticket);
        return true;
    }

    private String removeQuotes(String str) {
        return str.substring(1, str.length() - 1);
    }
}
