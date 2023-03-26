package com.example.sidiayapi.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity(name = "Transport")
@Table(name = "Transport")
@Getter
@Setter
@NoArgsConstructor
public class Transport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @ManyToMany(mappedBy = "transport")
    private Set<Tickets> tickets;
    @Column
    private String name;
}
