package com.example.springbootcrud.service;

import java.util.*;

import com.example.springbootcrud.model.Course;
import com.example.springbootcrud.model.Student;

public interface StudentService {
	List<Student> getAllStudents();
	
	Student add(Student student);
	
	Student update(Student student);
	
	String delete(Long id);
	
	List<Course> getAllCourses();
}
