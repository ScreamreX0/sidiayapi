package com.example.sidiayapi.controllers.servicerequestfacility;

import com.example.sidiayapi.entities.Field;
import com.example.sidiayapi.entities.ServiceRequestFacility;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface IServiceRequestFacilityController {
    ResponseEntity<String> test();
    ResponseEntity<List<ServiceRequestFacility>> get(Map<String, Object> params);
    ResponseEntity<List<ServiceRequestFacility>> get(final int count);
}
