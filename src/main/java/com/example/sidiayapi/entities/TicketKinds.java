package com.example.sidiayapi.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Entity(name = "ticket_kinds")
@Table(name = "ticket_kinds")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TicketKinds {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ticket_kind_id;
    @Column
    private String ticket_kind_sysname;
    @Column
    private String ticket_kind_name;
    @Column
    private String ticket_kind_sname;
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
