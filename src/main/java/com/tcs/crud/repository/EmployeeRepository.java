package com.tcs.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.crud.entity.EmployeeEntity;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {

}
