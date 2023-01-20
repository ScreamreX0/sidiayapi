package com.example.sidiayapi.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Table(name = "facility_types")
@Entity(name = "facility_types")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FacilityTypes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long facility_type_id;
    @Column
    private String facility_type_code;
    @Column
    private Long facility_type_mask_id;
    @Column
    private Long flanqe_kind_id;
    @Column
    private String facility_type_tag_mask;
    @Column
    private String facility_type_name;
    @Column
    private String facility_type_sname;
    @Column
    private Boolean facility_has_feeder;
    @Column
    private Boolean facility_has_tank;
    @Column
    private Boolean facility_has_diagram;
    @Column
    private Boolean facility_has_equip_move;
    @Column
    private Boolean facility_has_cha_water;
    @Column
    private Boolean facility_has_facility;
    @Column
    private Long facility_type_icon_index;
    @Column
    private Boolean facility_has_meter_move;
    @Column
    private String facility_type_desc;
    @Column
    private Boolean facility_has_prefix;
    @Column
    private String facility_type_prefix;
    @Column
    private Long default_agent_type_id;
    @Column
    private String facility_tag_mask;
    @Column
    private Long facility_type_diagram_index;
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
    private Boolean row_is_ready;
}
