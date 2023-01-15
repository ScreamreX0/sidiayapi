package com.example.sidiayapi.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "tickets_facilities")
@Table(name = "tickets_facilities")
@Getter
@Setter
@NoArgsConstructor
public class TicketFacility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ticket_facility_id;
    @OneToOne
    private Ticket ticket_id;
    @OneToOne
    private FacilityType facility_type_id;
    @OneToOne
    private Facility facility_id;
}
