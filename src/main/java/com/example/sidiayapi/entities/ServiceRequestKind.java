package com.example.sidiayapi.entities;

import jakarta.persistence.*;

import java.sql.Date;

@Entity(name = "service_request_kind")
@Table(name = "service_request_kind")
public class ServiceRequestKind {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long service_request_kind_id;
    @Column
    String service_request_kind_sysname;
    @Column
    String service_request_kind_name;
    @Column
    String service_request_kind_sname;
    @Column
    Date row_date_begin;
    @Column
    Date row_date_end;
    @Column
    Date row_create_date;
    @Column
    String row_create_user;
    @Column
    Date row_modify_date;
    @Column
    String row_modify_user;
    @Column
    boolean row_is_ready;
}
