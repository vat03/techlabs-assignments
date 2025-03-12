package com.aurionpro.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurionpro.crud.dto.InstructorRequestDto;
import com.aurionpro.crud.dto.InstructorResponseDto;
import com.aurionpro.crud.entity.Instructor;
import com.aurionpro.crud.repository.InstructorRepository;

@Service
public class InstructorServiceImpl implements InstructorService {

	@Autowired
	private InstructorRepository instructorRepo;

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
}
