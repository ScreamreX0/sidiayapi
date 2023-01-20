package com.example.sidiayapi.controllers.field;

import com.example.sidiayapi.entities.Fields;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface IFieldController {
    ResponseEntity<String> test();
    ResponseEntity<List<Fields>> get(Map<String, Object> params);
    ResponseEntity<List<Fields>> get(final int count);
}
