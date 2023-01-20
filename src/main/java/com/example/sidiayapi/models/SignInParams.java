package com.example.sidiayapi.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SignInParams {
    @Email(message = "Email wrong format")
    @NotBlank(message = "Email should not be empty")
    private String email;
    @NotNull(message = "Password should not be null")
    @NotBlank(message = "Password should not be empty")
    private String password;
}
