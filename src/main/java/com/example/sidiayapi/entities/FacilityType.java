package com.example.sidiayapi.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Table(name = "facility_type")
@Entity(name = "facility_type")
@Getter
@Setter
@NoArgsConstructor
public class FacilityType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long facility_type_id;
    @Column
    private String facility_type_code;
    @Column
    private long facility_type_mask_id;
    @Column
    private long flanqe_kind_id;
    @Column
    private String facility_type_tag_mask;
    @Column
    private String facility_type_name;
    @Column
    private String facility_type_sname;
    @Column
    private boolean facility_has_feeder;
    @Column
    private boolean facility_has_tank;
    @Column
    private boolean facility_has_diagram;
    @Column
    private boolean facility_has_equip_move;
    @Column
    private boolean facility_has_cha_water;
    @Column
    private boolean facility_has_facility;
    @Column
    private long facility_type_icon_index;
    @Column
    private boolean facility_has_meter_move;
    @Column
    private String facility_type_desc;
    @Column
    private boolean facility_has_prefix;
    @Column
    private String facility_type_prefix;
    @Column
    private long default_agent_type_id;
    @Column
    private String facility_tag_mask;
    @Column
    private long facility_type_diagram_index;
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
