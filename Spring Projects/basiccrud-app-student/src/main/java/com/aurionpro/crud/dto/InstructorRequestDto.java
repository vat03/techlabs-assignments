package com.aurionpro.crud.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor
@Data
public class InstructorRequestDto {
	private String name;
	private String qualification;
	private int experience;
}
