package com.example.sidiayapi.services;

import com.example.sidiayapi.entities.Users;
import com.example.sidiayapi.exceptions.ApiExceptions;
import com.example.sidiayapi.models.SignInParams;
import com.example.sidiayapi.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {
    @Autowired
    UsersRepository usersRepository;

    public Users signIn(SignInParams params) {
        if (params.getEmail().isBlank() || params.getPassword().isBlank()) {
            throw new ApiExceptions.WrongParamsFormatException();
        }

        Users user = usersRepository.findByEmailAndPassword(
                params.getEmail().replaceAll("\"", ""),
                params.getPassword().replaceAll("\"", ""));

        if (user == null) {
            throw new ApiExceptions.WrongEmailOrPasswordException();
        }

        return user;
    }

    public List<Users> get() {
        return usersRepository.findAll();
    }
}

