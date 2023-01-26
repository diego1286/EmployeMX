package com.example.employedmx.models;


import jakarta.persistence.*;

import java.io.Serializable;


@Entity
@Table(name = "jobs")
public class Job  implements Serializable {

    private  static  final long serialVersionUID=1L;

    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", length = 255, nullable = false)
    private String name;

    @Column(name = "salary")
    private Float salary;


    public Job() {
    }

    public Job(Long id, String name, Float salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
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

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }
}
