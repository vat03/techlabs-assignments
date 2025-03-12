package com.aurionpro.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurionpro.crud.dto.CourseRequestDto;
import com.aurionpro.crud.dto.CourseResponseDto;
import com.aurionpro.crud.entity.Course;
import com.aurionpro.crud.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseRepository courseRepo;

	@Override
	public CourseResponseDto addCourse(CourseRequestDto requestDto) {
		Course dbCourse = courseRepo.save(requestDtotoCourseMapper(requestDto));
		return courseToResponseDtoMapper(dbCourse);
	}

	private Course requestDtotoCourseMapper(CourseRequestDto requestDto) {
		Course course = new Course();
		course.setName(requestDto.getName());
		course.setDuration(requestDto.getDuration());
		course.setFees(requestDto.getFees());
		return course;
	}

	private CourseResponseDto courseToResponseDtoMapper(Course course) {
		CourseResponseDto responseDto = new CourseResponseDto();
		responseDto.setCourseId(course.getCourseId());
		responseDto.setName(course.getName());
		responseDto.setDuration(course.getDuration());
		responseDto.setFees(course.getFees());
		return responseDto;
	}
}