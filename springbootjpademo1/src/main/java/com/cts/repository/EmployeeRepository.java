package com.cts.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	Employee findByName(String name);  // To create custome query. Follow this code
	int countByDept(String dept);      // To create custome query. Follow this code
	List<Employee> findBYDept(String dept);    // To create custome query. Follow this code
}
