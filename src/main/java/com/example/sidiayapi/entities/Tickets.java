package com.example.sidiayapi.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
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

    private Integer status;

    @ManyToOne
    @JoinColumn(name = "author")
    @JsonProperty("author")
    private Users author;

    @Column(name = "creation_date")
    @JsonProperty("creation_date")
    private LocalDate creationDate;

    @Column(name = "ticket_name")
    @JsonProperty("ticket_name")
    private String ticketName;

    @Column(name = "description_of_work")
    @JsonProperty("description_of_work")
    private String descriptionOfWork;

    private Integer kind;

    private Integer service;

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
    @JsonProperty("equipment")
    private Set<Equipment> equipment;

    @ManyToMany
    @JoinTable(
            name = "tickets_materials",
            joinColumns = @JoinColumn(name = "ticket_id"),
            inverseJoinColumns = @JoinColumn(name = "material_id")
    )
    @JsonProperty("materials")
    private Set<Materials> materials;

    @ManyToMany
    @JoinTable(
            name = "tickets_transport",
            joinColumns = @JoinColumn(name = "ticket_id"),
            inverseJoinColumns = @JoinColumn(name = "transport_id")
    )
    @JsonProperty("transport")
    private Set<Transport> transport;

    private Integer priority;

    @Column(name = "assessed_value")
    @JsonProperty("assessed_value")
    private Float assessedValue;

    @Column(name = "assessed_value_description")
    @JsonProperty("assessed_value_description")
    private String assessedValueDescription;

    @Column(name = "reason_for_cancellation")
    @JsonProperty("reason_for_cancellation")
    private String reasonForCancellation;

    @ManyToMany
    @JoinTable(
            name = "tickets_executors",
            joinColumns = @JoinColumn(name = "ticket_id"),
            inverseJoinColumns = @JoinColumn(name = "executor_id")
    )
    @JsonProperty("executors")
    private Set<Users> executors;

    @Column(name = "plane_date")
    @JsonProperty("plane_date")
    private LocalDate planeDate;

    @Column(name = "reason_for_suspension")
    @JsonProperty("reason_for_suspension")
    private String reasonForSuspension;

    @Column(name = "completed_work")
    @JsonProperty("completed_work")
    private String completedWork;

    @ManyToMany
    @JoinTable(
            name = "tickets_quality_controllers",
            joinColumns = @JoinColumn(name = "ticket_id"),
            inverseJoinColumns = @JoinColumn(name = "quality_controller_id")
    )
    @JsonProperty("quality_controllers")
    private Set<Users> qualityControllers;

    @Column(name = "improvement_comment")
    @JsonProperty("improvement_comment")
    private String improvementComment;

    @Column(name = "closing_date")
    @JsonProperty("closing_date")
    private LocalDate closingDate;
}
