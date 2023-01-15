package com.example.sidiayapi.controllers.user;

import com.example.sidiayapi.entities.User;
import com.example.sidiayapi.exceptions.ApiExceptionHandler;
import com.example.sidiayapi.exceptions.ApiExceptions;
import com.example.sidiayapi.services.UserService;
import com.example.sidiayapi.utils.Logger;
import com.example.sidiayapi.utils.NetworkStates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController implements IUserController {
    @Autowired
    UserService userService;

    private final String logTitle = UserController.class.toString();

    @Override
    @GetMapping
    public ResponseEntity<String> test() {
        try {
            return ResponseEntity.ok(null);
        } catch (Exception exception) {
            Logger.log(logTitle, exception.getStackTrace());
            return new ResponseEntity<>("", NetworkStates.BadRequest.getCode());
        }
    }

    /**
     * @HTTPStatus 200 -> Sign in success
     * @HTTPStatus 406 -> Wrong format
     * @HTTPStatus 401 -> Wrong email or password
     */
    @Override
    @PostMapping("/sign-in")
    public ResponseEntity<User> signIn(Map<String, Object> signInParams) {
        userService.signIn((String) signInParams.get("login"), (String) signInParams.get("password"));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
