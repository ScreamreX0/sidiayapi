package com.example.sidiayapi.services;

import com.example.sidiayapi.entities.Users;
import com.example.sidiayapi.exceptions.ApiExceptions;
import com.example.sidiayapi.models.SignInParams;
import com.example.sidiayapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public Users signIn(SignInParams params) {
        if (params.getEmail().isBlank() || params.getPassword().isBlank()) {
            throw new ApiExceptions.WrongParamsFormatException();
        }

        Users user = userRepository.findByEmailAndPassword(params.getEmail(), params.getPassword());

        if (user == null) {
            throw new ApiExceptions.WrongEmailOrPasswordException();
        }

        return user;
    }
}
