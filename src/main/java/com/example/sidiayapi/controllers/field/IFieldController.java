package com.example.sidiayapi.controllers.field;

import com.example.sidiayapi.entities.Field;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface IFieldController {
    ResponseEntity<String> test();
    ResponseEntity<List<Field>> get(Map<String, Object> params);
    ResponseEntity<List<Field>> get(final int count);
}
