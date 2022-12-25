package com.example.sidiayapi.controllers.servicerequesttype;

import com.example.sidiayapi.entities.ServiceRequestType;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface IServiceRequestTypeController {
    ResponseEntity<String> test();
    ResponseEntity<List<ServiceRequestType>> get(Map<String, Object> params);
    ResponseEntity<List<ServiceRequestType>> get(final int count);
}
