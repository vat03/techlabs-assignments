package com.aurionpro.crud.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurionpro.crud.dto.CourseResponseDto;
import com.aurionpro.crud.dto.InstructorRequestDto;
import com.aurionpro.crud.dto.InstructorResponseDto;
import com.aurionpro.crud.entity.Course;
import com.aurionpro.crud.entity.Instructor;
import com.aurionpro.crud.repository.CourseRepository;
import com.aurionpro.crud.repository.InstructorRepository;

@Service
public class InstructorServiceImpl implements InstructorService {

	@Autowired
	private InstructorRepository instructorRepo;

	@Autowired
	private CourseRepository courseRepo;

	private ModelMapper mapper;

	public InstructorServiceImpl() {

		this.mapper = new ModelMapper();
	}

	@Override
	public InstructorResponseDto addInstructor(InstructorRequestDto requestDto) {
		Instructor dbInstructor = instructorRepo.save(requestDtotoInstructorMapper(requestDto));
		return instructorToResponseDtoMapper(dbInstructor);
	}

	private Instructor requestDtotoInstructorMapper(InstructorRequestDto requestDto) {
		Instructor instructor = new Instructor();
		instructor.setName(requestDto.getName());
		instructor.setQualification(requestDto.getQualification());
		instructor.setExperience(requestDto.getExperience());
		return instructor;
	}

	private InstructorResponseDto instructorToResponseDtoMapper(Instructor instructor) {
		InstructorResponseDto responseDto = new InstructorResponseDto();
		responseDto.setInstructorId(instructor.getInstructorId());
		responseDto.setName(instructor.getName());
		responseDto.setQualification(instructor.getQualification());
		responseDto.setExperience(instructor.getExperience());
		return responseDto;
	}

	@Override
	public InstructorResponseDto assignCourses(int instructorId, List<Integer> courseIds) {
		Optional<Instructor> dbInstructor = instructorRepo.findById(instructorId);
		if (dbInstructor.isEmpty())
			throw new RuntimeException("Instructor with Id - " + instructorId + " does not exist.");

		Instructor instructor = dbInstructor.get();

		List<Course> courses = new ArrayList<>();

		for (Integer courseId : courseIds) {
			Course course = courseRepo.findById(courseId)
					.orElseThrow(() -> new RuntimeException("Course with id - " + courseId + " does not exist."));
			course.setInstructor(instructor);
			Course dbCourse = courseRepo.save(course);
			courses.add(dbCourse);
		}

		instructor.setCourses(courses);
		return mapper.map(instructorRepo.save(instructor), InstructorResponseDto.class);
	}

	@Override
	public List<CourseResponseDto> listOfCoursesTaught(int instructorId) {
		Optional<Instructor> dbInstructor = instructorRepo.findById(instructorId);
		if (dbInstructor.isEmpty())
			throw new RuntimeException("Instructor with Id - " + instructorId + " does not exist.");

		Instructor instructor = dbInstructor.get();
		
		List<CourseResponseDto> courseDto = new ArrayList<>();
		
		for(Course course: instructor.getCourses())
		{
			courseDto.add(mapper.map(course, CourseResponseDto.class));
		}
		
		return courseDto;
	}
}