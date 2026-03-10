package com.Cashing.redis_demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Cashing.redis_demo.Entity.Student;
import com.Cashing.redis_demo.Service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService service;

	@PostMapping("/add")
	@CacheEvict(value = "students", allEntries = true)
	public Student addStudent(@RequestBody Student student) {
		return service.addStudent(student);
	}

	@GetMapping("/get")
	@Cacheable(value = "students", key = "'all'")
	@CacheEvict(value = "students", allEntries = true)
	public List<Student> getStudent() throws InterruptedException {
		Thread.sleep(5000);
		System.out.println("Calling from DATABASE...!");
		return service.getStudent();
	}

	@GetMapping("/getid/{id}")
	@Cacheable(value = "students", key = "#id")
	public Student getById(@PathVariable("id") int id) throws InterruptedException {
		Thread.sleep(5000);
		System.out.println("Calling from DATABASE...!");
		return service.getStudentById(id);
	}

	@DeleteMapping("/delete-by-id/{id}")
	@CacheEvict(value = "students", key = "#id")
	public String deleteById(@PathVariable("id") int id) {
		service.deleteById(id);
		return "Deleted";
	}

	@PutMapping("/update-std")
	@CachePut(value = "updateStudent",key="#STD.id")
	@CacheEvict(value = "students", allEntries = true)
	public Student updateSTD(@RequestBody Student STD) {
		return service.udpdatestudent(STD);
	}
}
