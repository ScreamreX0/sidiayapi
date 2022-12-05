package com.example.sidiayapi.entities;

import jakarta.persistence.*;

@Entity(name = "applications_objects")
@Table(name = "applications_objects")
public class ApplicationObjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "application_id")
    private int application_id;

    @Column(name = "object_id")
    private int object_id;

    public ApplicationObjectEntity() {
    }

    public ApplicationObjectEntity(int id, int application_id, int object_id) {
        this.id = id;
        this.application_id = application_id;
        this.object_id = object_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getApplication_id() {
        return application_id;
    }

    public void setApplication_id(int application_id) {
        this.application_id = application_id;
    }

    public int getObject_id() {
        return object_id;
    }

    public void setObject_id(int object_id) {
        this.object_id = object_id;
    }
}
