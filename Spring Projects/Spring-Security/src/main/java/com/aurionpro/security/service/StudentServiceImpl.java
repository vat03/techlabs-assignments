package com.aurionpro.security.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurionpro.security.entity.Student;
import com.aurionpro.security.repo.StudentRepo;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentRepo studentRepo;
	
	@Override
	public Boolean addStudent(Student student) {
		studentRepo.save(student);
		return true;
	}

	@Override
	public List<Student> getAllStudents() {
		return studentRepo.findAll();
	}
}
