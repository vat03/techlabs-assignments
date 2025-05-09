package com.aurionpro.crud.service;

//import java.util.List;

import com.aurionpro.crud.dto.PageResponse;
import com.aurionpro.crud.dto.StudentDto;
import com.aurionpro.crud.entity.Student;

public interface StudentService {
	
	PageResponse<StudentDto> getAllStudents(int pageNumber, int pageSize, String name);
	
	Student addStudent(Student student);
	
	void deleteStudent(Student student);
	
	Student getAStudent(int studentId);
	
	//List<Student> getStudentByName(String name);
}
