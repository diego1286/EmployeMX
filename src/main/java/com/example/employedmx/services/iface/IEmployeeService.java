package com.example.employedmx.services.iface;


import com.example.employedmx.dto.request.EmployeeCreateRequest;
import com.example.employedmx.dto.response.EmployeeCreateResponse;
import com.example.employedmx.dto.response.EmployeeListResponse;
import com.example.employedmx.models.Employee;


public interface IEmployeeService  {
    EmployeeCreateResponse create (EmployeeCreateRequest employee);

      EmployeeListResponse listEmployee(Long jobId);


}
