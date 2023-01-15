package com.example.sidiayapi.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Entity(name = "tickets")
@Table(name = "tickets")
@Getter
@Setter
@NoArgsConstructor
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ticket_id;
    @OneToOne
    private Field field;
    @Column
    private Long priority_id;
    @OneToOne
    private TicketType ticketType;
    @OneToOne
    private TicketState ticketState;
    @Column
    private Long service_id;
    @OneToOne
    private TicketKind ticketKind;
    @Column
    private Long ticket_executor_id;
    @Column
    private Date ticket_date;
    @Column
    private Date ticket_date_complete;
    @Column
    private Date ticket_date_plan;
    @Column
    private Date ticket_date_transfer;
    @Column
    private String ticket_name;
    @Column
    private String ticket_text;
    @Column
    private String ticket_equipment;
    @Column
    private String ticket_completed_work;
    @Column
    private String ticket_revision_text;
    @Column
    private Boolean sticket_is_shutdown;
    @Column
    private Integer ticket_shutdown_time;
    @Column
    private String create_user;
    @Column
    private Date create_date;
    @Column
    private Long ticket_user_id;
    @Column
    private Long ticket_parent_id;
}
