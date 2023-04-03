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
    List<Employees> employees;
    List<Equipment> equipment;
    List<Facilities> facilities;
    List<Kinds> kinds;
    List<Priorities> priorities;
    List<Services> services;
    List<Transport> transport;
}
