package com.aurionpro.crud.service;

import java.util.List;

import com.aurionpro.crud.dto.CourseResponseDto;
import com.aurionpro.crud.dto.InstructorRequestDto;
import com.aurionpro.crud.dto.InstructorResponseDto;

public interface InstructorService {
	InstructorResponseDto addInstructor(InstructorRequestDto requestDto);
	
	InstructorResponseDto assignCourses(int instructorId, List<Integer> courseIds);
	
	List<CourseResponseDto> listOfCoursesTaught(int instructorId);
}
