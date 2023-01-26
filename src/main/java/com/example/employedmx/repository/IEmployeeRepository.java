package com.example.employedmx.repository;

import com.example.employedmx.models.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IEmployeeRepository extends CrudRepository<Employee, Long> {

    Employee findByNameAndLastName(String name, String lastName); // metodo para encontrar nombre y apellido

    List<Employee> findByJobId(Long jobId);




}
