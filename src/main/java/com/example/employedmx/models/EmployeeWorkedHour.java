package com.example.employedmx.models;


import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "employee_worked_hours", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"employee_id", "worked_date"})})
public class EmployeeWorkedHour  implements Serializable {
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "worked_hours")
    private Integer workedHours;


    @Column(name = "worked_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate workedDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="employee_id")
    private  Employee employee ;

    public EmployeeWorkedHour() {
    }

    public EmployeeWorkedHour(Long id, Integer workedHours, LocalDate workedDate) {
        this.id = id;
        this.workedHours = workedHours;
        this.workedDate = workedDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getWorkedHours() {
        return workedHours;
    }

    public void setWorkedHours(Integer workedHours) {
        this.workedHours = workedHours;
    }

    public LocalDate getWorkedDate() {
        return workedDate;
    }

    public void setWorkedDate(LocalDate workedDate) {
        this.workedDate = workedDate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
