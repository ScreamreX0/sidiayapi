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
public class Tickets {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ticket_id;
    @OneToOne
    private Fields field;
    @Column
    private Long priority_id;
    @OneToOne
    private TicketTypes ticketType;
    @OneToOne
    private TicketStates ticketState;
    @OneToOne
    private TicketKinds ticketKind;
    @Column
    private Long service_id;
    @Column
    private Long ticket_executor_id;
    @Column
    private Date ticket_creation_date;
    @Column
    private String ticket_name;
    @Column
    private Boolean ticket_is_shutdown;
    @Column
    private Integer ticket_shutdown_time;
}
