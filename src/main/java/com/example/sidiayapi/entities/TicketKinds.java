package com.example.sidiayapi.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Entity(name = "ticket_kinds")
@Table(name = "ticket_kinds")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TicketKinds {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
}
