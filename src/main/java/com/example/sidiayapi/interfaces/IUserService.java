package com.example.sidiayapi.interfaces;

import com.example.sidiayapi.entities.UserEntity;
import org.springframework.http.ResponseEntity;

public interface IUserService {
    ResponseEntity<UserEntity> emailIn(String email, String password);
}
