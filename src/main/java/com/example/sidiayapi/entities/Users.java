package com.example.sidiayapi.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Entity(name = "users")
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;
    @Column
    private Integer user_type_id;
    @Column
    private Boolean user_is_principal;
    @Column
    private String user_password;
    @Column
    private String user_name;
    @Column
    private String user_title;
    @Column
    private String user_firstname;
    @Column
    private String user_lastname;
    @Column
    private String user_middle_name;
    @Column
    private String user_email;
    @Column
    private String user_phone;
    @Column
    private String user_photo;
    @Column
    private String user_desc;
    @Column
    private Boolean user_actual;
    @Column
    private Boolean user_log;
    @Column
    private Date last_login;
    @Column
    private Long last_build;
    @Column
    private Long context_company_id;
    @Column
    private Long current_company_id;
    @Column
    private Long current_shop_id;
    @Column
    private String user_struct_name;
    @Column
    private Date create_date;
    @Column
    private String user_sign_template;
    @Column
    private Boolean password_is_temp;
    @Column
    private String user_mobile_phone;
}
