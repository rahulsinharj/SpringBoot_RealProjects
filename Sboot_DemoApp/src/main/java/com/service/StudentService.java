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

	public Student showSingleStudent(int studentId) 
	{
		return this.studentRepository.findById(studentId)
				.orElseThrow(() -> new RuntimeException("Student you are looking for not found on server !"));
	}

	public List<Student> showAllStudents() 
	{
		return this.studentRepository.findAll();
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
