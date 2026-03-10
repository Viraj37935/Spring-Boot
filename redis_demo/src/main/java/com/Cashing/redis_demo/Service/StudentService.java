package com.Cashing.redis_demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Cashing.redis_demo.Entity.Student;
import com.Cashing.redis_demo.Repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository repo;
	
	public Student addStudent(Student student) {
		return repo.save(student);
	}
	
	public List<Student> getStudent(){
		return repo.findAll();
	}
	
	public Student getStudentById(int id) {
		return repo.findById(id).get();
	}
	
	public String deleteById(int id) {
		 repo.deleteById(id);
		 return "Student Deleted";
	}
	
	public Student udpdatestudent(Student student) {
		return repo.save(student);
	}
}
