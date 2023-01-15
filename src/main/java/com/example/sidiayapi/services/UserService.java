package com.example.sidiayapi.services;

import com.example.sidiayapi.exceptions.ApiExceptions;
import com.example.sidiayapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public void signIn(String login, String password) {
        throw new ApiExceptions.WrongEmailOrPasswordException();
    }
}
