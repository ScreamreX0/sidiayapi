package com.example.sidiayapi.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;


@Entity(name = "field")
@Table(name = "field")
@Getter
@Setter
@NoArgsConstructor
public class Field {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long field_id;
    @Column
    private long field_type_id;
    @Column
    private long field_company_id;
    @Column
    private long preferential_type_id;
    @Column
    private long place_type_id;
    @Column
    private String field_code;
    @Column
    private int field_index;
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
    private long armits_id;
    @Column
    private String field_left;
    @Column
    private String field_tap;
    @Column
    private String field_right;
    @Column
    private String field_bottom;
    @Column
    private long reference_well_ids;
    @Column
    private boolean field_actual;
    @Column
    private long structure_id;
}
