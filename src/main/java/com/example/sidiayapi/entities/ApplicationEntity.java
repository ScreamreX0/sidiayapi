package com.example.sidiayapi.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@Entity(name = "applications")
@Table(name = "applications")
public class ApplicationEntity {
    public ApplicationEntity() {
    }

    public ApplicationEntity(String service, EmployeeEntity executor, String type, String priority, String status, Date planned_date, Date expiration_date, String description, String completed_works, EmployeeEntity author, Date creation_date) {
        this.service = service;
        this.executor = executor;
        this.type = type;
        this.priority = priority;
        this.status = status;
        this.planned_date = planned_date;
        this.expiration_date = expiration_date;
        this.description = description;
        this.completed_works = completed_works;
        this.author = author;
        this.creation_date = creation_date;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "service")
    private String service;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "executor", referencedColumnName = "id")
    private EmployeeEntity executor;

    @Column(name = "type")
    private String type;

    @Column(name = "priority")
    private String priority;

    @Column(name = "status")
    private String status;

    @Column(name = "planned_date")
    private Date planned_date;

    @Column(name = "expiration_date")
    private Date expiration_date;

    @Column(name = "description")
    private String description;

    @Column(name = "completed_works")
    private String completed_works;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "author", referencedColumnName = "id")
    private EmployeeEntity author;

    @Column(name = "creation_date")
    private Date creation_date;
}
