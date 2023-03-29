package com.example.sidiayapi.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Credentials {
    @Builder.Default
    private String email = "";
    @Builder.Default
    private String password = "";
}
