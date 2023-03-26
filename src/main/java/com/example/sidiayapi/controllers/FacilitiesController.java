//package com.example.sidiayapi.controllers;
//
//import com.example.sidiayapi.entities.Facilities;
//import com.example.sidiayapi.services.FacilitiesService;
//import com.example.sidiayapi.utils.Logger;
//import com.example.sidiayapi.utils.NetworkStates;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@Controller
//@RequestMapping("/facilities")
//public class FacilitiesController {
//    @Autowired
//    FacilitiesService facilitiesService;
//
//    private final String logTitle = FacilitiesController.class.toString();
//
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
//    @GetMapping("/get")
//    public ResponseEntity<List<Facilities>> get() {
//        return facilitiesService.get();
//    }
//}
