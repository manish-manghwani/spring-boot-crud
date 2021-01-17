package com.example.springbootcrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.springbootcrud.model.Student;
import com.example.springbootcrud.service.StudentService;

@RestController
public class StudentController {
	//Display list of students
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/students")
	public List<Student> viewHomePage() {
		return studentService.getAllStudents();
	}
	
	@PostMapping("/student")
	public Student add(@RequestBody Student newStudent) {
		return studentService.add(newStudent);
	}
	
	@PutMapping("/student")
	public Student update(@RequestBody Student updateStudent) {
		return studentService.update(updateStudent);
	}
	
	@DeleteMapping("/student/{id}")
	public String delete(@PathVariable Long id) {
		return studentService.delete(id);
	}
	
}

