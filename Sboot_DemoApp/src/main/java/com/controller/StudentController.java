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
import org.springframework.web.bind.annotation.RestController;

import com.entity.Student;
import com.service.StudentService;

@RestController
@RequestMapping("student")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	// Create Book
	@PostMapping("")
	public Student addStudent(@RequestBody Student student) {
		return this.studentService.addStudent(student);
	}

	// Get Single Book
	@GetMapping("/{studentId}")
	public Student showSingleStudent(@PathVariable("studentId") int studentId) {
		return this.studentService.showSingleStudent(studentId);
	}
	
	// Get All Book 
	@GetMapping("")
	public List<Student> showAllStudents() {
		return this.studentService.showAllStudents();
	}

	@PutMapping("")
	public Student updateStudent(@RequestBody Student student) {
		return this.studentService.updateStudent(student);
	}
	
	@DeleteMapping("/{studentId}")
	public ResponseEntity<?> deleteStudent(@PathVariable("studentId") int studentId) {
		this.studentService.deleteStudent(studentId);
		return ResponseEntity.ok("Student Deleted !");
	}

	
	
}
