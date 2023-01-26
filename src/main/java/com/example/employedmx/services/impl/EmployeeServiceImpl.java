package com.example.employedmx.services.impl;

import com.example.employedmx.dto.request.EmployeeCreateRequest;
import com.example.employedmx.dto.response.EmployeeCreateResponse;
import com.example.employedmx.dto.response.EmployeeListResponse;
import com.example.employedmx.models.Employee;
import com.example.employedmx.models.Gender;
import com.example.employedmx.models.Job;
import com.example.employedmx.repository.IEmployeeRepository;
import com.example.employedmx.repository.IGenderRepository;
import com.example.employedmx.repository.IJobRepositiry;
import com.example.employedmx.services.iface.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements IEmployeeService {



    @Autowired
    private IEmployeeRepository employeeRepository;

    @Autowired
    private IGenderRepository genderRepository;

    @Autowired
    private IJobRepositiry jobRepositiry;

    @Override
    public EmployeeCreateResponse create(EmployeeCreateRequest employee) {
        Employee  employeeNew= new Employee();
        EmployeeCreateResponse response= new EmployeeCreateResponse();
        Employee employeeBD=employeeRepository.findByNameAndLastName(employee.getName(), employee.getLastName());
        response.setSuccess(false);
        response.setId(null);
        if(employeeBD!=null && employeeBD.getId()!=null || ChronoUnit.YEARS.between(employee.getBirthdate(), LocalDate.now())<18){
            return  response;
        }
        Optional <Gender> genderOpt= genderRepository.findById(employee.getGenderId());
        if(!genderOpt.isPresent()){
           return  response;
        }
        Optional <Job> jobOpt= jobRepositiry.findById(employee.getJobId());
        if(!jobOpt.isPresent()){
            return  response;
        }
        employeeNew.setName(employee.getName());
        employeeNew.setLastName(employee.getLastName());
        employeeNew.setBirthdate(employee.getBirthdate());
        employeeNew.setGender(genderOpt.get());
        employeeNew.setJob(jobOpt.get());
        employeeNew= employeeRepository.save(employeeNew);
        if(employeeNew==null){
            return response;
        }
        response.setId(employeeNew.getId());
        response.setSuccess(Boolean.TRUE);
        return response;
    }

    @Override
    public EmployeeListResponse listEmployee(Long jobId) {
        EmployeeListResponse employeeListResponse = new EmployeeListResponse();
        List<Employee> employeeList= new ArrayList<>();
        employeeListResponse.setEmployees(employeeList);
        employeeListResponse.setSuccess(false);
        Optional <Job> jobOpt=jobRepositiry.findById(jobId);
        if(!jobOpt.isPresent()){
            return employeeListResponse;
        }
        employeeList=employeeRepository.findByJobId(jobId);
        if(employeeList==null){
            return  employeeListResponse;
        }
        employeeListResponse.setEmployees(employeeList);
        employeeListResponse.setSuccess(Boolean.TRUE);

        return employeeListResponse;
    }
}
