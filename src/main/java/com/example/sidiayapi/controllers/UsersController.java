//package com.example.sidiayapi.controllers;
//
//import com.example.sidiayapi.entities.Users;
//import com.example.sidiayapi.models.SignInParams;
//import com.example.sidiayapi.services.UsersService;
//import com.example.sidiayapi.utils.Logger;
//import com.example.sidiayapi.utils.NetworkStates;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import java.util.List;
//
//@Controller
//@RequestMapping("/users")
//public class UsersController {
//    @Autowired
//    UsersService usersService;
//
//    private final String logTitle = UsersController.class.toString();
//
//    @GetMapping
//    public ResponseEntity<String> test() {
//        try {
//            return ResponseEntity.ok(null);
//        } catch (Exception exception) {
//            Logger.log(logTitle, exception.getStackTrace());
//            return new ResponseEntity<>("", NetworkStates.BadRequest.getCode());
//        }
//    }
//
//    @PostMapping("/sign-in")
//    public ResponseEntity<Users> signIn(@ModelAttribute SignInParams signInParams, BindingResult bindingResult) {
//        return new ResponseEntity<>(usersService.signIn(signInParams), HttpStatus.OK);
//    }
//
//    @GetMapping("/get")
//    public ResponseEntity<List<Users>> get() {
//        return new ResponseEntity<>(usersService.get(), HttpStatus.OK);
//    }
//}
