package com.example.employedmx.services.iface;

import com.example.employedmx.dto.request.EmployeeCreateRequest;
import com.example.employedmx.dto.request.EmployeeHourWorkedRequest;
import com.example.employedmx.dto.response.EmployeeHourWorkedResponse;

import javax.validation.Valid;

public interface IEmployeeWorkedHourService  {
    EmployeeHourWorkedResponse hourWorked( EmployeeHourWorkedRequest employeeHourWorkedRequest);
}
