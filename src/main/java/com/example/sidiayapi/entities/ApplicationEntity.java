package com.example.sidiayapi.entities;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;

@Entity(name = "applications")
@Table(name = "applications")
public class ApplicationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToMany
    private List<ObjectEntity> objects;

    @Column(name = "service")
    private String service;

    @Column(name = "executor")
    private int executor;

    @Column(name = "type")
    private String type;

    @Column(name = "priority")
    private String priority;

    @Column(name = "status")
    private String status;

    @Column(name = "planned_date")
    private Date planned_date;

    @Column(name = "expiration_date")
    private Date expiration_date;

    @Column(name = "description")
    private String description;

    @Column(name = "completed_works")
    private String completed_works;

    @Column(name = "author")
    private int author;

    @Column(name = "creation_date")
    private Date creation_date;

    public ApplicationEntity() {
    }

    public ApplicationEntity(
            List<ObjectEntity> objects,
            String service,
            int executor,
            String type,
            String priority,
            String status,
            Date planned_date,
            Date expiration_date,
            String description,
            String completed_works,
            int author,
            Date creation_date) {
        this.objects = objects;
        this.service = service;
        this.executor = executor;
        this.type = type;
        this.priority = priority;
        this.status = status;
        this.planned_date = planned_date;
        this.expiration_date = expiration_date;
        this.description = description;
        this.completed_works = completed_works;
        this.author = author;
        this.creation_date = creation_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<ObjectEntity> getObjects() {
        return objects;
    }

    public void setObjects(List<ObjectEntity> objects) {
        this.objects = objects;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public int getExecutor() {
        return executor;
    }

    public void setExecutor(int executor) {
        this.executor = executor;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getPlanned_date() {
        return planned_date;
    }

    public void setPlanned_date(Date planned_date) {
        this.planned_date = planned_date;
    }

    public Date getExpiration_date() {
        return expiration_date;
    }

    public void setExpiration_date(Date expiration_date) {
        this.expiration_date = expiration_date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCompleted_works() {
        return completed_works;
    }

    public void setCompleted_works(String completed_works) {
        this.completed_works = completed_works;
    }

    public int getAuthor() {
        return author;
    }

    public void setAuthor(int author) {
        this.author = author;
    }

    public Date getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }
}
