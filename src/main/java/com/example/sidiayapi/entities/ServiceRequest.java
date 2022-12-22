package com.example.sidiayapi.entities;

import jakarta.annotation.Priority;
import jakarta.persistence.*;

import java.sql.Date;

@Entity(name = "service_request")
@Table(name = "service_request")
public class ServiceRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long service_request_id;
    @OneToOne
    private Field field;
    @Column
    private long priority_id;
    @OneToOne
    private ServiceRequestType serviceRequestType;
    @OneToOne
    private ServiceRequestState serviceRequestState;
    @Column
    private long service_id;
    @OneToOne
    private ServiceRequestKind serviceRequestKind;
    @Column
    private long service_request_executor_id;
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
    private boolean service_request_is_shutdown;
    @Column
    private int service_request_shutdown_time;
    @Column
    private String create_user;
    @Column
    private Date create_date;
    @Column
    private long service_request_user_id;
    @Column
    private long service_request_parent_id;
}
