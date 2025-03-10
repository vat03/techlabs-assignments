package com.aurionpro.crud.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.crud.dto.PageResponse;
import com.aurionpro.crud.entity.Student;
import com.aurionpro.crud.service.StudentService;

@RestController
@RequestMapping("/studentapp")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping("/students")
	public ResponseEntity<PageResponse<Student>> getAllStudents(@RequestParam int pageNumber, @RequestParam int pageSize) {
		return ResponseEntity.ok(studentService.getAllStudents(pageNumber, pageSize));
	}

	@PostMapping("/students")
	public ResponseEntity<Student> addStudent(@RequestBody Student student) {
		return ResponseEntity.ok(studentService.addStudent(student));
	}

	@PutMapping("/students")
	public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
		return ResponseEntity.ok(studentService.addStudent(student));
	}

	@DeleteMapping("/students")
	public void deleteStudent(@RequestBody Student student) {
		studentService.deleteStudent(student);
	}

	@GetMapping("/students/{studentId}")
	public ResponseEntity<Student> getAStudent(@PathVariable int studentId) {
		return ResponseEntity.ok(studentService.getAStudent(studentId));
	}

	@GetMapping("/studentsbyname")
	public ResponseEntity<List<Student>> getStudentByName(@RequestParam String name) {
		return ResponseEntity.ok(studentService.getStudentByName(name));
	}
}