package com.aurionpro.crud.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor
@Data
public class CourseRequestDto {
	private String name;

	private int duration;

	private double fees;
}
