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
    @Size(min = 4, max = 30, message = "Email size should be between 4 and 30")
    private String email;
    @NotNull(message = "Password should not be null")
    @NotBlank(message = "Password should not be empty")
    @Size(min = 6, max = 30, message = "Password size should be between 6 and 30")
    private String password;
}
