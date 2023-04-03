package com.example.sidiayapi.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Priorities")
@Table(name = "Priorities")
@Getter
@Setter
@NoArgsConstructor
public class Priorities {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer value;
}
