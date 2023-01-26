package com.example.sidiayapi.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity(name = "tickets")
@Table(name = "tickets")
@Getter
@Setter
@NoArgsConstructor
public class Tickets {
    public Tickets(Long priority, TicketKinds kind, String plane_date, String expiration_date, String creation_date, String completed_work, String description, String name, String status, String service) {
        this.author = null;
        this.executor = null;

        this.priority = priority;
        this.kind = kind;
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
    @NotNull
    private Long priority;
    @Column
    @NotNull
    private String plane_date;
    @Column
    @NotNull
    private String expiration_date;
    @Column
    @NotNull
    private String creation_date;
    @Column
    @NotNull
    private String completed_work;
    @Column
    @NotNull
    private String description;
    @Column
    @NotNull
    private String name;
    @Column
    @NotNull
    private String status;
    @Column
    @NotNull
    private String service;
}
