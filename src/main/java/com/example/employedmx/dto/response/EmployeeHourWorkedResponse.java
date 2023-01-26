package com.example.employedmx.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.http.HttpStatusCode;

public class EmployeeHourWorkedResponse {

    private Long id;



    private Boolean success;

    public EmployeeHourWorkedResponse() {
    }

    public EmployeeHourWorkedResponse(Long id, Integer totalWorkedHours, Boolean success) {
        this.id = id;
        this.success = success;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }
}
