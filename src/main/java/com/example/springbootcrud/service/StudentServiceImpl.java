package com.example.springbootcrud.service;

import com.example.springbootcrud.model.Course;
import com.example.springbootcrud.model.Student;
import com.example.springbootcrud.repository.CourseRepository;
import com.example.springbootcrud.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Override
	public List<Course> getAllCourses() {
		return courseRepository.findAll(); 
	}
	
	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}
	
	@Override
	public Student add(Student newStudent) {
		Jedis jedis = new Jedis("localhost");
		jedis.rpush("all-students", newStudent.toString());
		return studentRepository.save(newStudent);
	}
	
	@Override
	public String delete(Long id) {
		try {
			studentRepository.deleteById(id);
		}catch(Exception err) {
			return "Failed to delete Student with id" + id;
		}
		return "Deleted Student with id " + id;
	}
	
	@Override
	public Student update(Student student) {
		if(!studentRepository.existsById(student.getId())) {
			return null;
		}
		
		return studentRepository.save(student);
	}
	
}
