package com.aurionpro.crud.service;

import java.util.ArrayList;
import java.util.List;
//import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.aurionpro.crud.dto.PageResponse;
import com.aurionpro.crud.dto.StudentDto;
import com.aurionpro.crud.entity.Student;
import com.aurionpro.crud.exception.StudentApiException;
import com.aurionpro.crud.repository.StudentRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepo;

	private static final Logger log = LoggerFactory.getLogger(StudentServiceImpl.class);

	@Override
	public PageResponse<StudentDto> getAllStudents(int pageNumber, int pageSize, String name) {
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		Page<Student> students = null;

		if (name == null) {
			students = studentRepo.findAll(pageable);
		}
		if (name != null) {
			students = studentRepo.findByName(pageable, name);
		}

		List<Student> dbStudent = students.getContent();
		
		List<StudentDto> studentDto = new ArrayList<>();
		
		for (Student student : dbStudent) {
			studentDto.add(studentToStudentDtoMapper(student));
		}
		
		PageResponse<StudentDto> pageresponse = new PageResponse<>();

		pageresponse.setContent(studentDto);
		pageresponse.setTotalPages(students.getTotalPages());
		pageresponse.setPageSize(students.getSize());
		pageresponse.setTotalElements(students.getTotalElements());
		pageresponse.setLast(students.isLast());

		return pageresponse;
	}

	private StudentDto studentToStudentDtoMapper(Student student) {
		StudentDto dto = new StudentDto();
		
		dto.setStudentId(student.getStudentId());
		dto.setName(student.getName());
		dto.setRollNumber(student.getRollNumber());
		dto.setAge(student.getAge());
		
		return dto;
	}

	@Override
	public Student addStudent(Student student) {
		Student dbRecord = studentRepo.save(student);

		log.info("Student added with id:" + student.getStudentId());

		return dbRecord;
	}

	@Override
	public void deleteStudent(Student student) {
		studentRepo.delete(student);
	}

	@Override
	public Student getAStudent(int studentId) {
		Optional<Student> dbRecord = studentRepo.findById(studentId);

		if (dbRecord.isEmpty())
			throw new StudentApiException("Student does not exist");

		return dbRecord.get();
	}

//	@Override
//	public List<Student> getStudentByName(String name) {
//		List<Student> dbRecord = studentRepo.findByName(name);
//
//		if (dbRecord.isEmpty())
//			throw new RuntimeException("Student does not exist");
//
//		return dbRecord;
//	}
}
