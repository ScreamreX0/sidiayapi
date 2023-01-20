package com.example.sidiayapi.controllers.facilitytype;

import com.example.sidiayapi.entities.FacilityTypes;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface IFacilityTypeController {
    ResponseEntity<String> test();
    ResponseEntity<List<FacilityTypes>> get(Map<String, Object> params);
    ResponseEntity<List<FacilityTypes>> get(final int count);
}
