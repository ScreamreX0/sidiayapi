package com.example.sidiayapi.controllers.facility;

import com.example.sidiayapi.entities.Facilities;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface IFacilityController {
    ResponseEntity<String> test();
    ResponseEntity<List<Facilities>> get(Map<String, Object> params);
    ResponseEntity<List<Facilities>> get(final int count);
}
