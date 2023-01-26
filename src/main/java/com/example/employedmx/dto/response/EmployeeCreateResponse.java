package com.example.employedmx.dto.response;

public class EmployeeCreateResponse {

    private Long id;

    private Boolean success;

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
