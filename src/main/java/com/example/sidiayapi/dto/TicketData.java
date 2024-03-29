package com.example.sidiayapi.dto;

import com.example.sidiayapi.entities.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TicketData {
    List<Users> users;
    List<Facilities> facilities;
    List<Transport> transport;
}
