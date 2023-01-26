package com.example.employedmx.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class EmployeeHourWorkedRequest {

    @NotNull(message = "id must be not null")
    @JsonProperty("employee_id")
    private Long employeeId;

    @NotNull(message = "worked hours must be not null")
    @JsonProperty("worked_hours")
    private Integer workedHours;

    @NotNull(message = "worked date  must be not null")
    @JsonProperty("worked_date")
    private LocalDate workedDate;

    public EmployeeHourWorkedRequest() {
    }

    public EmployeeHourWorkedRequest(Long employeeId, Integer workedHours, LocalDate workedDate) {
        this.employeeId = employeeId;
        this.workedHours = workedHours;
        this.workedDate = workedDate;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
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
}
