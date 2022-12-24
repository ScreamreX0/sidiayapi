package com.example.sidiayapi.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Entity(name = "users")
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long user_id;
    @Column
    private int user_type_id;
    @Column
    private boolean user_is_principal;
    @Column
    private String user_name;
    @Column
    private String user_title;
    @Column
    private String user_firstname;
    @Column
    private String user_lastname;
    @Column
    private String user_middlename;
    @Column
    private String user_email;
    @Column
    private String user_phone;
    @Column
    private String user_photo;
    @Column
    private String user_desc;
    @Column
    private boolean user_actual;
    @Column
    private boolean user_log;
    @Column
    private Date last_login;
    @Column
    private long last_build;
    @Column
    private long context_company_id;
    @Column
    private long current_company_id;
    @Column
    private long current_shop_id;
    @Column
    private String user_fullname;
    @Column
    private String user_shortname;
    @Column
    private String user_struct_name;
    @Column
    private Date create_date;
    @Column
    private String user_sign_template;
    @Column
    private boolean password_is_temp;
    @Column
    private String user_mobile_phone;
}
