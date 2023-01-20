package com.example.sidiayapi.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;


@Entity(name = "fields")
@Table(name = "fields")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Fields {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long field_id;
    @Column
    private Long field_type_id;
    @Column
    private Long field_company_id;
    @Column
    private Long preferential_type_id;
    @Column
    private Long place_type_id;
    @Column
    private String field_code;
    @Column
    private Integer field_index;
    @Column
    private String field_name;
    @Column
    private String character;
    @Column
    private Date field_date;
    @Column
    private String[] field_synonyms;
    @Column
    private String field_desc;
    @Column
    private Long armits_id;
    @Column
    private String field_left;
    @Column
    private String field_tap;
    @Column
    private String field_right;
    @Column
    private String field_bottom;
    @Column
    private Long reference_well_ids;
    @Column
    private Boolean field_actual;
    @Column
    private Long structure_id;
}
