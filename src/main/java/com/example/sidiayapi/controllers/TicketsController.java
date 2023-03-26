//package com.example.sidiayapi.controllers;
//
//import com.example.sidiayapi.entities.Tickets;
//import com.example.sidiayapi.exceptions.ApiExceptions;
//import com.example.sidiayapi.models.AddTicketParams;
//import com.example.sidiayapi.services.TicketsService;
//import com.example.sidiayapi.utils.Logger;
//import com.example.sidiayapi.utils.NetworkStates;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@Controller
//@RequestMapping("/tickets")
//public class TicketsController implements ITicketsController {
//    @Autowired
//    TicketsService ticketsService;
//
//    private final String logTitle = TicketsController.class.toString();
//
//    @Override
//    @GetMapping
//    public ResponseEntity<String> test() {
//        try {
//            return ResponseEntity.ok(null);
//        } catch (Exception exception) {
//            Logger.log(logTitle, exception.getStackTrace());
//            return new ResponseEntity<>("", NetworkStates.BadRequest.getCode());
//        }
//    }
//
//    @Override
//    @GetMapping("/get")
//    public ResponseEntity<List<Tickets>> get() {
//        return new ResponseEntity<>(ticketsService.get(), HttpStatus.OK);
//    }
//
//    @Override
//    @PostMapping("/add")
//    public ResponseEntity<Boolean> add(@ModelAttribute AddTicketParams tickets, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            throw new ApiExceptions.WrongParamsFormatException(bindingResult.getAllErrors().toString());
//        }
//
//        return new ResponseEntity<>(ticketsService.add(tickets), HttpStatus.OK);
//    }
//}
//
//
//
//
//
