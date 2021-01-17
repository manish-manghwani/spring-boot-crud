package com.example.springbootcrud.service;

import java.util.*;

import com.example.springbootcrud.model.Course;

public interface CourseService {
	List<Course> getAllCourses();
	
	Course add(Course course);
	
	String delete(Long id);
	
	Course update(Course course);

}
