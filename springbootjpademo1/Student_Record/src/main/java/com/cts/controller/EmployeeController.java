package com.cts.controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import com.cts.entity.Students;
import com.cts.repository.StudentsRepository;

@RestController
@RequestMapping("/studentrecord")
public class EmployeeController {

	@Autowired
	private StudentsRepository studentsRepository;

	@PostMapping("/addStudent")
	public Students addStudents(@RequestBody Students students) {
		return studentsRepository.save(students);
	}

	@GetMapping("/viewallStudents")
	public List<Students> getAllStudents() {
		return studentsRepository.findAll();
	}

	@GetMapping("/viewStudentById/{id}")
	public Students getStudentById(@PathVariable int id) {
		Optional<Students> opstudents = studentsRepository.findById(id);

		if (opstudents.isEmpty()) {
			throw new IllegalArgumentException("No student found !!!");
		}
		return opstudents.get();
	}

	@PutMapping("/updateStudent/{id}")
	public Students updateStudent(@PathVariable int id, @RequestBody Students students) {

		Optional<Students> opstudents = studentsRepository.findById(id);
		if (opstudents.isEmpty()) {
			throw new IllegalArgumentException("No student found !!!");
		}

		Students updatedStudents = opstudents.get();

		updatedStudents.setStudentId(students.getStudentId());
		updatedStudents.setTitle(students.getTitle());
		updatedStudents.setLastName(students.getLastName());
		updatedStudents.setFirstName(students.getFirstName());
		updatedStudents.setGender(students.getGender());

		return studentsRepository.save(updatedStudents);
	}

	@DeleteMapping("/deleteStudent/{id}")
	public String deleteStudentById(@PathVariable int id) {
		Optional<Students> opstudents = studentsRepository.findById(id);

		if (opstudents.isEmpty()) {
			return "Student not found";
		}
		studentsRepository.deleteById(id);
		return "Student deleted successfully";
	}
}
