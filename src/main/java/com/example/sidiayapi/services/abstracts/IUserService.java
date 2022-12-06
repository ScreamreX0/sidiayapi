package com.example.sidiayapi.services.abstracts;

import com.example.sidiayapi.entities.UserEntity;
import org.springframework.http.ResponseEntity;

public interface IUserService {
    ResponseEntity<UserEntity> emailIn(String email, String password);
}
