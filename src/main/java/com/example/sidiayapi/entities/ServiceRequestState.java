package com.example.sidiayapi.entities;

import jakarta.persistence.*;

import java.sql.Date;

@Entity(name = "service_request_state")
@Table(name = "service_request_state")
public class ServiceRequestState {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long service_request_state_id;
    @Column
    private String service_request_state_mask_id;
    @Column
    private String service_request_state_mask;
    @Column
    private int image_index;
    @Column
    private String service_request_state_sysname;
    @Column
    private String service_request_state_name;
    @Column
    private Date row_date_begin;
    @Column
    private Date row_date_end;
    @Column
    private Date row_create_date;
    @Column
    private String row_create_user;
    @Column
    private Date row_modify_date;
    @Column
    private String row_modify_user;
    @Column
    private boolean row_is_ready;
    @Column
    private long service_request_state_parent_id;
}
