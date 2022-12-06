package com.example.sidiayapi.entities;

import jakarta.persistence.*;

@Entity(name = "employees")
@Table(name = "employees")
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "name")
    private String name;

    @Column(name = "last_name")
    private String last_name;



    public EmployeeEntity() {
    }

    public EmployeeEntity(int id, String first_name, String name, String last_name) {
        this.id = id;
        this.first_name = first_name;
        this.name = name;
        this.last_name = last_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
}