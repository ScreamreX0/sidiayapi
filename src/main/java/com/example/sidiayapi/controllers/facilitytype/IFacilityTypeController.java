package com.example.sidiayapi.controllers.facilitytype;

import com.example.sidiayapi.entities.FacilityType;
import com.example.sidiayapi.entities.Field;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface IFacilityTypeController {
    ResponseEntity<String> test();
    ResponseEntity<List<FacilityType>> get(Map<String, Object> params);
    ResponseEntity<List<FacilityType>> get(final int count);
}
