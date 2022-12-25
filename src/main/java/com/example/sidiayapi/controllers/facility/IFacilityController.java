package com.example.sidiayapi.controllers.facility;

import com.example.sidiayapi.entities.Facility;
import com.example.sidiayapi.entities.Field;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

public interface IFacilityController {
    ResponseEntity<String> test();
    ResponseEntity<List<Facility>> get(Map<String, Object> params);
    ResponseEntity<List<Facility>> get(final int count);
}
