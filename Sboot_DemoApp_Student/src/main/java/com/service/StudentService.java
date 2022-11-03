package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Student;
import com.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	public Student addStudent(Student student) 
	{
		return this.studentRepository.save(student);
	}

	public List<Student> showAllStudents() 
	{
		return this.studentRepository.findAll();
	}
	
	public Student showSingleStudentById(int studentId) 
	{
		return this.studentRepository.findById(studentId)
				.orElseThrow(() -> new RuntimeException("Student you are looking for not found on server !"));
	}
	
	public List<Student> showStudentByNameAndCity(String name, String city) 
	{
		List<Student> stu = this.studentRepository.findByNameAndCity(name, city);
		stu.forEach(System.out::println);
		return stu;
	}
	
	public List<Student> showStudentByCity(String city) 
	{
		List<Student> stu = this.studentRepository.findByCity(city);
		stu.forEach(System.out::println);
		return stu;
	}
	
	// Search by : Keyword Containing
	public List<Student> showStudentByNameContaining(String nameKeyword) 
	{
		List<Student> stu = this.studentRepository.findByNameContaining(nameKeyword);
		stu.forEach(System.out::println);
		return stu;
	}	
	

	public Student updateStudent(Student student) 
	{
		this.studentRepository.save(student);
		return this.studentRepository.findById(student.getId()).get();
	}

	public void deleteStudent(int studentId) 
	{
		this.studentRepository.deleteById(studentId);
	}

	

	

}
