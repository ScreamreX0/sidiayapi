package com.example.sidiayapi.controllers.user;

import com.example.sidiayapi.entities.User;
import com.example.sidiayapi.exceptions.ApiExceptionHandler;
import com.example.sidiayapi.exceptions.ApiExceptions;
import com.example.sidiayapi.models.SignInParams;
import com.example.sidiayapi.services.UserService;
import com.example.sidiayapi.utils.Logger;
import com.example.sidiayapi.utils.NetworkStates;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;

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
     * @HTTPStatus 405 -> Wrong format
     * @HTTPStatus 406 -> Wrong email or password
     */
    @Override
    @PostMapping("/sign-in")
    public ResponseEntity<User> signIn(
            @ModelAttribute @Valid SignInParams signInParams,
            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            throw new ApiExceptions.WrongParamsFormatException(ApiExceptions.parseBindingException(bindingResult));
        }

        userService.signIn(signInParams);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
