package com.example.sssp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sssp.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	Employee getByLastName(String lastName);
}
