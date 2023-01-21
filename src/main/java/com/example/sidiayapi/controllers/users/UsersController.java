package com.example.sidiayapi.controllers.users;

import com.example.sidiayapi.entities.Users;
import com.example.sidiayapi.models.SignInParams;
import com.example.sidiayapi.services.UsersService;
import com.example.sidiayapi.utils.Logger;
import com.example.sidiayapi.utils.NetworkStates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UsersController implements IUsersController {
    @Autowired
    UsersService usersService;

    private final String logTitle = UsersController.class.toString();

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
     * @HTTPStatus 450 -> Wrong format
     * @HTTPStatus 451 -> Wrong email or password
     */
    @Override
    @PostMapping("/sign-in")
    public ResponseEntity<Users> signIn(@ModelAttribute SignInParams signInParams, BindingResult bindingResult) {
        return new ResponseEntity<>(usersService.signIn(signInParams), HttpStatus.OK);
    }
}
