package com.aurionpro.crud.service;

import com.aurionpro.crud.dto.CourseRequestDto;
import com.aurionpro.crud.dto.CourseResponseDto;

public interface CourseService {
	CourseResponseDto addCourse(CourseRequestDto requestDto);
}
