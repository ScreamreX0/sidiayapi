package com.example.sidiayapi.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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
    @NotNull
    private Long id;
    @Column
    @NotNull
    private String name;
}
