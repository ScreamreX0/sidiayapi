package com.example.sidiayapi.entities;

import jakarta.persistence.*;

import java.sql.Date;

@Entity(name = "user")
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long user_id;
    @Column
    int user_type_id;
    @Column
    boolean user_is_principal;
    @Column
    String user_name;
    @Column
    String user_title;
    @Column
    String user_firstname;
    @Column
    String user_lastname;
    @Column
    String user_middlename;
    @Column
    String user_email;
    @Column
    String user_phone;
    @Column
    String user_photo;
    @Column
    String user_desc;
    @Column
    boolean user_actual;
    @Column
    boolean user_log;
    @Column
    Date last_login;
    @Column
    long last_build;
    @Column
    long context_company_id;
    @Column
    long current_company_id;
    @Column
    long current_shop_id;
    @Column
    String user_fullname;
    @Column
    String user_shortname;
    @Column
    String user_struct_name;
    @Column
    Date create_date;
    @Column
    String user_sign_template;
    @Column
    boolean password_is_temp;
    @Column
    String user_mobile_phone;
}
