package com.example.sidiayapi.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "service_request_facilities")
@Table(name = "service_request_facilities")
@Getter
@Setter
@NoArgsConstructor
public class ServiceRequestFacility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long service_request_facility_id;
    @OneToOne
    private ServiceRequest service_request_id;
    @OneToOne
    private FacilityType facility_type_id;
    @OneToOne
    private Facility facility_id;
}
