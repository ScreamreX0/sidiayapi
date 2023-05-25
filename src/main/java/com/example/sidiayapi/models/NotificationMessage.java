package com.example.sidiayapi.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

@AllArgsConstructor
@Data
public class NotificationMessage {
    String recipientToken;
    String title;
    String body;
    Map<String, String> data;
}
