package com.example.sidiayapi.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties(value= {"handler","hibernateLazyInitializer","FieldHandler"})
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "employee_id")
    private Employees employee;
    private String password;
    private String phone;
    private String photo;
}
