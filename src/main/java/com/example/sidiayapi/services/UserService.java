package com.example.sidiayapi.services;

import com.example.sidiayapi.entities.UserEntity;
import com.example.sidiayapi.interfaces.IUserService;
import com.example.sidiayapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    public UserService() {
    }
    @Autowired
    UserRepository userRepository;

    @Override
    public ResponseEntity<UserEntity> emailIn(String email, String password) {
        UserEntity userEntity = userRepository.findUserByEmail(email);

        if (userEntity == null || !password.equals(userEntity.getPassword())) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        userRepository.save(userEntity);
        return new ResponseEntity<>(userEntity, HttpStatus.OK);
    }
}
