package com.aurionpro.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.crud.dto.CourseResponseDto;
import com.aurionpro.crud.dto.InstructorRequestDto;
import com.aurionpro.crud.dto.InstructorResponseDto;
import com.aurionpro.crud.service.InstructorService;

@RestController
@RequestMapping("/studentapp")
public class InstructorController {
	
	@Autowired
	private InstructorService instructorService;

	@PostMapping("/instructors")
	public ResponseEntity<InstructorResponseDto> addInstructor(@RequestBody InstructorRequestDto requestDto)
	{
		return ResponseEntity.ok(instructorService.addInstructor(requestDto));
	}
	
	@PutMapping("/assignCourses/{instructorId}")
	public ResponseEntity<InstructorResponseDto> assignCourses(@PathVariable int instructorId, @RequestBody List<Integer> courseId)
	{
		return ResponseEntity.ok(instructorService.assignCourses(instructorId, courseId));
	}
	
	@GetMapping("/coursestaught/{instructorId}")
	public ResponseEntity<List<CourseResponseDto>> coursetaught(@PathVariable int instructorId)
	{
		return ResponseEntity.ok(instructorService.listOfCoursesTaught(instructorId));
	}
}
