package com.aurionpro.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.aurionpro.crud.dto.PageResponse;
import com.aurionpro.crud.entity.Student;
import com.aurionpro.crud.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepo;

	@Override
	public PageResponse<Student> getAllStudents(int pageNumber, int pageSize) {
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		Page<Student> students = studentRepo.findAll(pageable);
		
		PageResponse<Student> pageresponse = new PageResponse<>();
		
		pageresponse.setContent(students.getContent());
		pageresponse.setTotalPages(students.getTotalPages());
		pageresponse.setPageSize(students.getSize());
		pageresponse.setTotalElements(students.getTotalElements());
		pageresponse.setLast(students.isLast());
		
		return pageresponse;
	}

	@Override
	public Student addStudent(Student student) {
		return studentRepo.save(student);
	}

	@Override
	public void deleteStudent(Student student) {
		studentRepo.delete(student);
	}

	@Override
	public Student getAStudent(int studentId) {
		Optional<Student> dbRecord = studentRepo.findById(studentId);

		if (dbRecord.isEmpty())
			throw new RuntimeException("Student does not exist");

		return dbRecord.get();
	}

	@Override
	public List<Student> getStudentByName(String name) {
		List<Student> dbRecord = studentRepo.findByName(name);

		if (dbRecord.isEmpty())
			throw new RuntimeException("Student does not exist");

		return dbRecord;
	}
}
