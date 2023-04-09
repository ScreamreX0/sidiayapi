package com.example.sidiayapi.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Entity(name = "Tickets")
@Table(name = "Tickets")
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = {"handler", "hibernateLazyInitializer", "FieldHandler"})
public class Tickets {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "priority_id")
    private Priorities priority;
    @ManyToOne
    @JoinColumn(name = "service_id")
    private Services service;
    @ManyToOne
    @JoinColumn(name = "kind_id")
    private Kinds kind;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Users author_id;
    @ManyToOne
    @JoinColumn(name = "executor_id")
    private Users executor_id;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "tickets_brigades",
            joinColumns = @JoinColumn(name = "ticket_id"),
            inverseJoinColumns = @JoinColumn(name = "brigade_id")
    )
    private Set<Users> brigade;
    @ManyToMany
    @JoinTable(
            name = "tickets_transport",
            joinColumns = @JoinColumn(name = "ticket_id"),
            inverseJoinColumns = @JoinColumn(name = "transport_id")
    )
    private Set<Transport> transport;
    @ManyToMany
    @JoinTable(
            name = "tickets_facilities",
            joinColumns = @JoinColumn(name = "ticket_id"),
            inverseJoinColumns = @JoinColumn(name = "facilities_id")
    )
    private Set<Facilities> facilities;
    @ManyToMany
    @JoinTable(
            name = "tickets_equipment",
            joinColumns = @JoinColumn(name = "ticket_id"),
            inverseJoinColumns = @JoinColumn(name = "equipment_id")
    )
    private Set<Equipment> equipment;
    private Integer status;
    private String completed_work;
    private String name;
    private String description;
    private String improvement_reason;
    private LocalDate creation_date;
    private LocalDate plane_date;
    private LocalDate closing_date;
}
