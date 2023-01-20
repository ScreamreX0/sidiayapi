package com.example.sidiayapi.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "tickets_facilities")
@Table(name = "tickets_facilities")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TicketsFacilities {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ticket_facility_id;
    @OneToOne
    private Tickets ticket_id;
    @OneToOne
    private FacilityTypes facility_type_id;
    @OneToOne
    private Facilities facility_id;
}
