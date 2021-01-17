package com.example.springbootcrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springbootcrud.model.Course;
import com.example.springbootcrud.repository.CourseRepository;


@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseRepository courseRepository;
	
	
	@Override
	public List<Course> getAllCourses() {
		return courseRepository.findAll();
	}
	
	@Override
	public Course add(Course newCourse) {
		return courseRepository.save(newCourse);
	}
	
	@Override
	public String delete(Long id) {
		try {
			courseRepository.deleteById(id);			
		}catch(Exception err) {
			System.out.print(err.toString());
			return "Failed to delete Course with id " + id;
		}
	
		return "Deleted Course with id " + id;
	}
	
	@Override
	public Course update(Course course) {
		if(!courseRepository.existsById(course.getId())) {
			return null;
		}
		courseRepository.save(course);
		return course;
	}
}
