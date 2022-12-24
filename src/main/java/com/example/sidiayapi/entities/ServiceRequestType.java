package com.example.sidiayapi.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Entity(name = "service_request_type")
@Table(name = "service_request_type")
@Getter
@Setter
@NoArgsConstructor
public class ServiceRequestType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long service_request_type_id;
    @Column
    private String service_request_type_mask_id;
    @Column
    private String service_request_type_sysname;
    @Column
    private String service_request_type_sname;
    @Column
    private String service_request_type_name;
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
