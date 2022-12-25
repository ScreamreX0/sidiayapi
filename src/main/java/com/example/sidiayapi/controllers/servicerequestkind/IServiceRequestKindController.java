package com.example.sidiayapi.controllers.servicerequestkind;

import com.example.sidiayapi.entities.Field;
import com.example.sidiayapi.entities.ServiceRequestKind;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface IServiceRequestKindController {
    ResponseEntity<String> test();
    ResponseEntity<List<ServiceRequestKind>> get(Map<String, Object> params);
    ResponseEntity<List<ServiceRequestKind>> get(final int count);
}
