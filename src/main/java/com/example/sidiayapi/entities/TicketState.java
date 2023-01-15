package com.example.sidiayapi.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Entity(name = "ticket_states")
@Table(name = "ticket_states")
@Getter
@Setter
@NoArgsConstructor
public class TicketState {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ticket_state_id;
    @Column
    private String ticket_state_mask_id;
    @Column
    private String ticket_state_mask;
    @Column
    private Integer image_index;
    @Column
    private String ticket_state_sysname;
    @Column
    private String ticket_state_name;
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
    @Column
    private Long ticket_state_parent_id;
}
