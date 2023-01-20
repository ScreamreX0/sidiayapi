package com.example.sidiayapi.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Entity(name = "facilities")
@Table(name = "facilities")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Facilities {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long facility_id;
    @Column
    private Long facility_parent_id;
    @OneToOne
    private FacilityTypes facilityType;
    @Column
    private Long shop_id;
    @Column
    private Long briq_id;
    @Column
    private Long shop_ids;
    @Column
    private Long district_id;
    @Column
    private Long dept_id;
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
