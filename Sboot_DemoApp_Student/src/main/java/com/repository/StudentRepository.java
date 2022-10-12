package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	List<Student> findByNameAndCity(String name, String city);

	List<Student> findByCity(String city);

//	List<Student> findByName(String name);				// This method can provide List<Student> result - only when parameter search keyword will be exact match of 'name' (CASE InSensitive search) 
	List<Student> findByNameContaining(String name);	// But this method can provide List<Student> result - even if the 'name' contains any letter match of the parameter search keyword (CASE InSensitive search)  
	 
}
