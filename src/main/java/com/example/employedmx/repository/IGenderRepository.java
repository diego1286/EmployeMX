package com.example.employedmx.repository;

import com.example.employedmx.models.Gender;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface IGenderRepository extends CrudRepository<Gender, Long> {

}
