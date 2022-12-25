package com.example.sidiayapi.controllers.servicerequeststate;

import com.example.sidiayapi.entities.ServiceRequestState;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface IServiceRequestStateController {
    ResponseEntity<String> test();
    ResponseEntity<List<ServiceRequestState>> get(Map<String, Object> params);
    ResponseEntity<List<ServiceRequestState>> get(final int count);
}
