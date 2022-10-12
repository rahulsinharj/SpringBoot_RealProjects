package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.entity.Student;
import com.service.StudentService;

@SpringBootApplication
public class SbootDemoAppApplication implements CommandLineRunner {

	@Autowired
	private StudentService studentService;
	
	@Override
	public void run(String... args) throws Exception {
		
/*		Student s1 = new Student();
		s1.setName("Rahul");
		s1.setCity("Patna");
		s1.setAge(24);
		s1.setBloodgroup("O+");
		s1.setSalary(90000);
		

		Student s2 = new Student();
		s2.setName("Vikas");
		s2.setCity("Delhi");
		s2.setAge(23);
		s2.setBloodgroup("A+");
		s2.setSalary(66000);
		

		Student s3 = new Student();
		s3.setName("Shubham");
		s3.setCity("Ranchi");
		s3.setAge(24);
		s3.setBloodgroup("B+");
		s3.setSalary(70000);
				
		this.studentService.addStudent(s1);
		this.studentService.addStudent(s2);
		this.studentService.addStudent(s3);
		
*/		
	}

	public static void main(String[] args) {
		SpringApplication.run(SbootDemoAppApplication.class, args);
	}

}
