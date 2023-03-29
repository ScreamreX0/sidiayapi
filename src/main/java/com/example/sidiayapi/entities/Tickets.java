package com.example.sidiayapi.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.Set;

@Entity(name = "Tickets")
@Table(name = "Tickets")
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value= {"handler","hibernateLazyInitializer","FieldHandler"})
public class Tickets {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
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
    private Users authorId;
    @ManyToOne
    @JoinColumn(name = "executor_id")
    private Users executorId;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "tickets_brigades",
            joinColumns = @JoinColumn(name = "ticket_id"),
            inverseJoinColumns = @JoinColumn(name = "brigade_id")
    )
    private Set<Users> brigades;
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
    @Column
    private Integer status;
    @Column(name = "completed_word")
    private String completedWork;
    @Column
    private String description;
    @Column(name = "improvement_reason")
    private String improvementReason;
    @Column(name = "creation_date")
    private Date creationDate;
    @Column(name = "plane_date")
    private Date planeDate;
    @Column(name = "closing_date")
    private Date closingDate;
}
