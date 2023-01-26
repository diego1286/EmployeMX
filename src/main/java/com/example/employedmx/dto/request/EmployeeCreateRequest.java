package com.example.employedmx.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;


import javax.validation.constraints.NotNull;
import java.time.LocalDate;


public class EmployeeCreateRequest {

    @NotNull(message = "gender must be not null")
    @JsonProperty("gender_id" )
    private Long genderId;

    @NotNull(message = "job must be not null")
    @JsonProperty("job_id")
    private Long jobId;

    @NotNull(message = "name must be not null")
    private String name;

    @NotNull(message = "last name must be not null")
    @JsonProperty("last_name")
    private String lastName;
    @NotNull(message = "birthdate must be not null")
    private LocalDate birthdate;

    public EmployeeCreateRequest(Long genderId, Long jobId, String name, String lastName, LocalDate birthdate) {
        this.genderId = genderId;
        this.jobId = jobId;
        this.name = name;
        this.lastName = lastName;
        this.birthdate = birthdate;
    }

    public Long getGenderId() {
        return genderId;
    }

    public void setGenderId(Long genderId) {
        this.genderId = genderId;
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
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
}
