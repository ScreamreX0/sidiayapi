package com.example.sidiayapi.services;

import com.example.sidiayapi.entities.Users;
import com.example.sidiayapi.exceptions.WrongCredentialsException;
import com.example.sidiayapi.models.Credentials;
import com.example.sidiayapi.repositories.UsersRepository;
import com.example.sidiayapi.utils.Logger;
import com.example.sidiayapi.utils.Validator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {
    UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public Users signIn(Credentials credentials) {
        if (Validator.anyNullOrBlank(credentials.getEmail(), credentials.getPassword())) {
            throw new WrongCredentialsException();
        }

        Logger.log("Credentials are correct. Trying to enter");

        Users user = usersRepository
                .findByCredentials(
                        credentials.getEmail(),
                        credentials.getPassword()
                );

        if (user == null) {
            throw new WrongCredentialsException();
        }

        return user;
    }

    public List<Users> get() {
        return usersRepository.findAll();
    }
}

