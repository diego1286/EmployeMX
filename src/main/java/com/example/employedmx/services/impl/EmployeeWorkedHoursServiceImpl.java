package com.example.employedmx.services.impl;

import com.example.employedmx.dto.request.EmployeeCreateRequest;
import com.example.employedmx.dto.request.EmployeeHourWorkedRequest;
import com.example.employedmx.dto.response.EmployeeHourWorkedResponse;
import com.example.employedmx.models.Employee;
import com.example.employedmx.models.EmployeeWorkedHour;
import com.example.employedmx.models.Job;
import com.example.employedmx.repository.IEmployeeRepository;
import com.example.employedmx.repository.IEmployeeWorkedHourRepository;
import com.example.employedmx.repository.IJobRepositiry;
import com.example.employedmx.services.iface.IEmployeeWorkedHourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

@Service
public class EmployeeWorkedHoursServiceImpl implements IEmployeeWorkedHourService {

    @Autowired
    private IEmployeeRepository employeeRepository;

    @Autowired
    private IJobRepositiry jobRepositiry;

    @Autowired
    private IEmployeeWorkedHourRepository employeeWorkedHourRepository;


    @Override
    public EmployeeHourWorkedResponse hourWorked( EmployeeHourWorkedRequest employeeHourWorkedRequest) {
        EmployeeWorkedHour employeeWorkedHour= new EmployeeWorkedHour();
        EmployeeHourWorkedResponse response= new EmployeeHourWorkedResponse();
       Optional  < Employee> employeeOpt=  employeeRepository.findById(employeeHourWorkedRequest.getEmployeeId());
        response.setSuccess(false);
        response.setId(null);
        LocalDate todday= LocalDate.now();
        if( !employeeOpt.isPresent() || employeeHourWorkedRequest.getWorkedHours()>20 ||
                todday.isBefore(employeeHourWorkedRequest.getWorkedDate())){
            return response;
        }
        EmployeeWorkedHour employeeWorkedHours= employeeWorkedHourRepository.findByEmployeeIdAndWorkedDate
                (employeeHourWorkedRequest.getEmployeeId(), employeeHourWorkedRequest.getWorkedDate());
        if(employeeWorkedHours!=null){
            return response;
        }

        employeeWorkedHour.setWorkedHours(employeeHourWorkedRequest.getWorkedHours());
        employeeWorkedHour.setWorkedDate(employeeHourWorkedRequest.getWorkedDate());
        employeeWorkedHour.setEmployee(employeeOpt.get());
        employeeWorkedHour= employeeWorkedHourRepository.save(employeeWorkedHour);
        if(employeeWorkedHour==null){
            return response;
        }
        response.setId(employeeWorkedHour.getId());
        response.setSuccess(Boolean.TRUE);
        return response;
    }
}
