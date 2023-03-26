package com.example.sidiayapi.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity(name = "Users")
@Table(name = "Users")
@Getter
@Setter
@NoArgsConstructor
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @ManyToMany(mappedBy = "brigades")
    private Set<Tickets> tickets;
    @OneToOne
    @JoinColumn(name = "employee_id")
    private Employees employee;
    @Column
    private String password;
    @Column
    private String phone;
    @Column
    private String photo;
}
