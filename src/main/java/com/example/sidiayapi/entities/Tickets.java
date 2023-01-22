package com.example.sidiayapi.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.Set;

@Entity(name = "tickets")
@Table(name = "tickets")
@Getter
@Setter
@NoArgsConstructor
public class Tickets {
    public Tickets(Set<Facilities> facilities, TicketKinds kind, Users author, Users executor, Long priority, Date plane_date, Date expiration_date, Date creation_date, String completed_work, String description, String name, String status, String service) {
        this.facilities = facilities;
        this.kind = kind;
        this.author = author;
        this.executor = executor;
        this.priority = priority;
        this.plane_date = plane_date;
        this.expiration_date = expiration_date;
        this.creation_date = creation_date;
        this.completed_work = completed_work;
        this.description = description;
        this.name = name;
        this.status = status;
        this.service = service;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToMany
    private Set<Facilities> facilities;
    @OneToOne
    private TicketKinds kind;
    @ManyToOne
    private Users author;
    @OneToOne
    private Users executor;

    @Column
    private Long priority;
    @Column
    private Date plane_date;
    @Column
    private Date expiration_date;
    @Column
    private Date creation_date;
    @Column
    private String completed_work;
    @Column
    private String description;
    @Column
    private String name;
    @Column
    private String status;
    @Column
    private String service;
}
