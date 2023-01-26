package com.example.employedmx.models;

import jakarta.persistence.*;

import java.io.Serializable;


@Entity
@Table(name = "genders")
public class Gender  implements Serializable {

    private  static  final long serialVersionUID=1L;

    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", length = 255, nullable = false)
    private String name;

    public Gender() {
    }

    public Gender(Long id, String name) {
        this.id = id;
        this.name = name;
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
}
