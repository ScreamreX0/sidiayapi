package com.example.sidiayapi.dto;

import com.example.sidiayapi.entities.*;
import com.example.sidiayapi.enums.KindsEnum;
import com.example.sidiayapi.repositories.SectorsRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TicketData {
    List<Users> users;
    List<Equipment> equipment;
    List<Facilities> facilities;
    List<Transport> transport;
    List<Materials> materials;
}
