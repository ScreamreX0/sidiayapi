package com.example.sidiayapi.entities;

import jakarta.persistence.*;

import java.sql.Date;

@Entity(name = "facility")
@Table(name = "facility")
public class Facility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long facility_id;
    @Column
    private long facility_parent_id;
    @OneToOne
    private FacilityType facilityType;
    @Column
    private long shop_id;
    @Column
    private long briq_id;
    @Column
    private long shop_ids;
    @Column
    private long district_id;
    @Column
    private long dept_id;
    @Column
    private String facility_name;
    @Column
    private String facility_sname;
    @Column
    private String facility_meter_name;
    @Column
    private String facility_sys_name;
    @Column
    private Date facility_date_begin;
    @Column
    private Date facility_date_end;
    @Column
    private String facility_coard_x;
    @Column
    private String facility_coard_y;
    @Column
    private String facility_altitude;
    @Column
    private String facility_taq_mask;
    @Column
    private String inventory_number;
    @Column
    private String facility_desc;
    @Column
    private String facility_gps_lat;
    @Column
    private String facility_gps_lan;
}
