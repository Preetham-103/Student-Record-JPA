package com.cts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import com.cts.entity.Employee;
import com.cts.repository.EmployeeRepository;

@SpringBootApplication
public class Springbootjpademo1Application implements CommandLineRunner {

	@Autowired
	EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(Springbootjpademo1Application.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		Employee employee = new Employee(1, "Preetham", "TL", 30, 36000.56);
//		employeeRepository.save(employee);
		
		Employee employee1 = new Employee(2,"ankit","hr",30,89000.6);
		Employee employee2 = new Employee(3,"rahul","dev",23,78000.45);
		
		List<Employee> employees = new ArrayList<>();
		employees.add(employee1);
		employees.add(employee2);
		employees.add(employee);
		
		employeeRepository.saveAll(employees);
		
		System.out.println("-----find all employee------");
		
		// Retrive all the records from the table. Just like select*from table_name;
		List<Employee> employeesList = employeeRepository.findAll();
		employeesList.forEach(System.out::println);
		
		
		// This will delete all the records from the table.
//		employeeRepository.deleteAll();
//		System.out.println("Successfully Deleted");
		
		
		System.out.println();
		
		
		// Find Employee By Id
		System.out.println("---Find Employee by id---");
		Optional<Employee> opEmployee =  employeeRepository.findById(3);
		
		if(opEmployee.isEmpty())
		{
			System.out.println("No employee found for the id");
		}
		else
		{
			System.out.println(opEmployee.get());
		}
		
		System.out.println();
		System.out.println("--------------------------------");
		
		// Delete By Employee Id.
		System.out.println("Delete Employee by Id");
		employeeRepository.deleteById(5);
		
		System.out.println("------------------------");
		
		Employee employee2 = employeeRepository.findByName("Preetham");
		System.out.println(employee2);
		
		System.out.println("---count by dept---");
		int deptCount = employeeRepository.countByDept("Hr");
		
		System.out.println("---Find by dept---");
		List<Employee> employeeDept = employeeRepository.findBYDept("hr");
		employeeDept.forEach(System.out::println);
		
		
	}

}
