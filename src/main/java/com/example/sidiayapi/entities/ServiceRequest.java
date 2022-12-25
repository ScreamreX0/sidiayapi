package com.example.sidiayapi.entities;

import jakarta.annotation.Priority;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Entity(name = "service_requests")
@Table(name = "service_requests")
@Getter
@Setter
@NoArgsConstructor
public class ServiceRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long service_request_id;
    @OneToOne
    private Field field;
    @Column
    private Long priority_id;
    @OneToOne
    private ServiceRequestType serviceRequestType;
    @OneToOne
    private ServiceRequestState serviceRequestState;
    @Column
    private Long service_id;
    @OneToOne
    private ServiceRequestKind serviceRequestKind;
    @Column
    private Long service_request_executor_id;
    @Column
    private Date service_request_date;
    @Column
    private Date service_request_date_complete;
    @Column
    private Date service_request_date_plan;
    @Column
    private Date service_request_date_transfer;
    @Column
    private String service_request_name;
    @Column
    private String service_request_text;
    @Column
    private String service_request_equipment;
    @Column
    private String service_request_completed_work;
    @Column
    private String service_request_revision_text;
    @Column
    private Boolean service_request_is_shutdown;
    @Column
    private Integer service_request_shutdown_time;
    @Column
    private String create_user;
    @Column
    private Date create_date;
    @Column
    private Long service_request_user_id;
    @Column
    private Long service_request_parent_id;
}
