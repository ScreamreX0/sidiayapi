package com.example.sidiayapi.services;

import com.example.sidiayapi.entities.Tickets;
import com.example.sidiayapi.entities.Users;
import com.example.sidiayapi.exceptions.NotFoundException;
import com.example.sidiayapi.exceptions.WrongCredentialsException;
import com.example.sidiayapi.models.Credentials;
import com.example.sidiayapi.repositories.UsersRepository;
import com.example.sidiayapi.utils.Logger;
import com.example.sidiayapi.utils.Validator;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Users findUserById(Long id) {
        String errorMessage = "Sender not found";
        if (id == null) throw new NotFoundException(errorMessage);
        Logger.log("Searching for user in db..");
        Optional<Users> userOptional = usersRepository.findById(id);
        if (userOptional.isEmpty()) {
            Logger.log(errorMessage);
            throw new NotFoundException(errorMessage);
        }
        Logger.log("User found.");
        return userOptional.get();
    }
}

