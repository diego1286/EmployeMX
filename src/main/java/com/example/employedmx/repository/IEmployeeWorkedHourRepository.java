package com.example.employedmx.repository;

import com.example.employedmx.models.Employee;

import com.example.employedmx.models.EmployeeWorkedHour;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface IEmployeeWorkedHourRepository extends CrudRepository<EmployeeWorkedHour, Long> {

    EmployeeWorkedHour  findByEmployeeIdAndWorkedDate(Long  employeeId, LocalDate workedDate );


}
