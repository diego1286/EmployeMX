package com.example.employedmx.controller;

import com.example.employedmx.dto.request.EmployeeCreateRequest;
import com.example.employedmx.dto.response.EmployeeCreateResponse;
import com.example.employedmx.dto.response.EmployeeListResponse;
import com.example.employedmx.services.iface.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;


    @PostMapping
    public ResponseEntity<EmployeeCreateResponse> create(@RequestBody @Valid @Validated  EmployeeCreateRequest employeeCreateRequest){
        if(employeeCreateRequest==null){
            return ResponseEntity.badRequest().body(new EmployeeCreateResponse());
        }
        return new ResponseEntity<> (employeeService.create(employeeCreateRequest), HttpStatus.CREATED);
    }

    @GetMapping("/{job_id}")
    public ResponseEntity<EmployeeListResponse> ListEmploye(@PathVariable(value = "job_id") Long jobId ){
        if(jobId==null){
            return ResponseEntity.badRequest().body(new EmployeeListResponse());
        }
        return  ResponseEntity.ok().body (employeeService.listEmployee(jobId));
    }


}
