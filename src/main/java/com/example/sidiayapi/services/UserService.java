package com.example.sidiayapi.services;

import com.example.sidiayapi.entities.EmployeeEntity;
import com.example.sidiayapi.entities.UserEntity;
import com.example.sidiayapi.repositories.EmployeeRepository;
import com.example.sidiayapi.repositories.UserRepository;
import com.example.sidiayapi.services.abstracts.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserService implements IUserService {
    public UserService() {
    }

    @Autowired
    UserRepository userRepository;

    @Override
    public ResponseEntity<UserEntity> emailIn(String email, String password) {
        try {
            UserEntity userEntity = userRepository.findUserByEmail(email);

            if (userEntity == null || !password.equals(userEntity.getPassword())) {
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }

            return new ResponseEntity<>(userEntity, HttpStatus.OK);
        } catch (Exception e) {
            Arrays.stream(e.getStackTrace()).forEach(System.out::println);
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}