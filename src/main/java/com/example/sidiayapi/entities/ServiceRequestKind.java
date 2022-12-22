package com.example.sidiayapi.entities;

import jakarta.persistence.*;

import java.sql.Date;

@Entity(name = "service_request_kind")
@Table(name = "service_request_kind")
public class ServiceRequestKind {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long service_request_kind_id;
    @Column
    private String service_request_kind_sysname;
    @Column
    private String service_request_kind_name;
    @Column
    private String service_request_kind_sname;
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
}
