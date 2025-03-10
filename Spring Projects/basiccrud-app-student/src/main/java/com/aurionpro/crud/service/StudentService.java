package com.aurionpro.crud.service;

import java.util.List;

import com.aurionpro.crud.dto.PageResponse;
import com.aurionpro.crud.entity.Student;

public interface StudentService {
	PageResponse<Student> getAllStudents(int pageNumber, int pageSize);
	
	Student addStudent(Student student);
	
	void deleteStudent(Student student);
	
	Student getAStudent(int studentId);
	
	List<Student> getStudentByName(String name);
}
