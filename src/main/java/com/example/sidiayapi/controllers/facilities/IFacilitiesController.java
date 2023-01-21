package com.example.sidiayapi.controllers.facilities;

import com.example.sidiayapi.entities.Facilities;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface IFacilitiesController {
    ResponseEntity<String> test();
    ResponseEntity<List<Facilities>> get();
}
