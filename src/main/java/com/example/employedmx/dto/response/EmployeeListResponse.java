package com.example.employedmx.dto.response;

import com.example.employedmx.models.Employee;

import java.util.List;

public class EmployeeListResponse {

   private List<Employee> employees;

   private Boolean success;

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }
}
