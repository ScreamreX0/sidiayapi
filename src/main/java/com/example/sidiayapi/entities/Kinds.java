package com.example.sidiayapi.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Kinds")
@Table(name = "Kinds")
@Getter
@Setter
@NoArgsConstructor
public class Kinds {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
