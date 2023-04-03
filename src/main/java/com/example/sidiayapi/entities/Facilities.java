package com.example.sidiayapi.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity(name = "Facilities")
@Table(name = "Facilities")
@Getter
@Setter
@NoArgsConstructor
public class Facilities {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}