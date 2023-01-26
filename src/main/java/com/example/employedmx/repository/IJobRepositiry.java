package com.example.employedmx.repository;

import com.example.employedmx.models.Job;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJobRepositiry extends CrudRepository<Job, Long> {
}
