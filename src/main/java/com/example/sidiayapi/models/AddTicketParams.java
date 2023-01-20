package com.example.sidiayapi.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddTicketParams {
    private String status;
    private String number;
    private Long field;
    private String priority;
    private String location;
    private String creationDate;
}
