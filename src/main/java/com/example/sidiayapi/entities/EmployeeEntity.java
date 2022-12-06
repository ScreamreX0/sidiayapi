package com.example.sidiayapi.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "employees")
@Table(name = "employees")
public class EmployeeEntity {
    public EmployeeEntity() {
    }

    public EmployeeEntity(int id, String first_name, String name, String last_name) {
        this.id = id;
        this.first_name = first_name;
        this.name = name;
        this.last_name = last_name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "name")
    private String name;

    @Column(name = "last_name")
    private String last_name;
}