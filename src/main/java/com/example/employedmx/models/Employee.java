package com.example.employedmx.models;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name="employees", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"name", "last_name"})}) //anotacion para q no se repita en bd

public class Employee  implements Serializable {

    private  static  final long serialVersionUID=1L;
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long  id;

    @Column(name ="name", length = 255, nullable = false)
    private String name;
    @JsonProperty("last_name")
    @Column(name = "last_name",length = 255, nullable = false)
    private String lastName;

    @Column(name = "birthdate")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthdate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="gender_id")
    private  Gender gender ;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="job_id")
    private  Job job ;

    public Employee() {
    }

    public Employee(Long id, String name, String lastName, LocalDate birthdate, Gender gender, Job job) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.gender = gender;
        this.job = job;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }
}
