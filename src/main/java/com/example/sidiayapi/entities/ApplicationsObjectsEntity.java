package com.example.sidiayapi.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "applications_objects")
@Table(name = "applications_objects")
public class ApplicationsObjectsEntity {
    public ApplicationsObjectsEntity() {
    }

    public ApplicationsObjectsEntity(int application_id, int object_id) {
        this.application_id = application_id;
        this.object_id = object_id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "application_id")
    int application_id;

    @Column(name = "object_id")
    int object_id;
}
