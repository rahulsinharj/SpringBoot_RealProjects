package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Student;
import com.service.StudentService;

@RestController
@RequestMapping("student")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	// Create Student ::									localhost:8080/student
	@PostMapping("")				
	public Student addStudent(@RequestBody Student student) {
		return this.studentService.addStudent(student);
	}

	
	// Get All Students ::									localhost:8080/student
	@GetMapping("")				// agar yaha path me (path = "/") slash laga denge to (localhost:8080/student) ke jagah (localhost:8080/student/ ) aisa search karna padega everytime, then it will only work with including slash /  
	public List<Student> showAllStudents() {
		return this.studentService.showAllStudents();
	}
	
	
	// Get Single Student by ID ::							localhost:8080/student/6
	@GetMapping("/{studentId}")
	public Student showSingleStudentById(@PathVariable("studentId") int studentId) {
		return this.studentService.showSingleStudentById(studentId);
	}
	
	
	// Get Students by student's name & city ::				localhost:8080/student?name=rahul&city=delhi
	@GetMapping(path = "", params = {"name", "city"})		
	public List<Student> showStudentByNameAndCity(@RequestParam("name") String name, @RequestParam("city") String city)
	{
		return this.studentService.showStudentByNameAndCity(name, city);
	}
	
	
	// Get Students by student's city ::					localhost:8080/student?city=delhi
	@GetMapping(path = "", params = {"city"})
	public List<Student> showStudentByCity(@RequestParam("city") String city)
	{
		return this.studentService.showStudentByCity(city);
	}
	
	
	// Get Students by student's name (any keyword match) ::
	@GetMapping(path = "", params = {"name"})			// agar yaha path me (path = "/") slash laga denge to (localhost:8080/student?name=rahul) ke jagah (localhost:8080/student/?name=rahul ) aisa search karna padega everytime, then it will only work with including slash /  
	public List<Student> showStudentByNameContaining(@RequestParam("name") String name)
	{
		return this.studentService.showStudentByNameContaining(name);
	}

	
	// Update single Student
	@PutMapping("")
	public Student updateStudent(@RequestBody Student student) {
		return this.studentService.updateStudent(student);
	}
	
	
	// Delete single Student
	@DeleteMapping("/{studentId}")
	public ResponseEntity<?> deleteStudent(@PathVariable("studentId") int studentId) {
		this.studentService.deleteStudent(studentId);
		return ResponseEntity.ok("Student Deleted !");
	}

	
	
}
