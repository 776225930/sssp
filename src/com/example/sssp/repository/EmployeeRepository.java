package com.example.sssp.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.sssp.entities.Employee;

public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Integer>{
	Employee getByLastName(String lastName);
}
