package com.example.sidiayapi.controllers.servicerequest;

import com.example.sidiayapi.entities.ServiceRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface IServiceRequestController {
    ResponseEntity<String> test();
    ResponseEntity<List<ServiceRequest>> get(Map<String, Object> params);
    ResponseEntity<List<ServiceRequest>> get(final int count);
}
