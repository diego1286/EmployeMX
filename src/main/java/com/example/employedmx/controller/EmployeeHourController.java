package com.example.employedmx.controller;


import com.example.employedmx.dto.request.EmployeeCreateRequest;
import com.example.employedmx.dto.request.EmployeeHourWorkedRequest;
import com.example.employedmx.dto.response.EmployeeHourWorkedResponse;
import com.example.employedmx.services.iface.IEmployeeWorkedHourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/employee_hours")
public class EmployeeHourController {

    @Autowired
    private IEmployeeWorkedHourService workedHourService;

    @PostMapping
    public ResponseEntity<EmployeeHourWorkedResponse>hourWorked(@RequestBody @Valid
                                                                    @Validated EmployeeHourWorkedRequest employeeHourWorkedRequest){
        if(employeeHourWorkedRequest==null){
            return ResponseEntity.badRequest().body(new EmployeeHourWorkedResponse());
        }
        return new ResponseEntity<> (workedHourService.hourWorked(employeeHourWorkedRequest), HttpStatus.CREATED);
    }


}
