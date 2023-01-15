package com.example.sidiayapi.exceptions;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ApiError {
    private String errorMessage;
    private String request;
    private String requestType;
    private String customMessage;
}
