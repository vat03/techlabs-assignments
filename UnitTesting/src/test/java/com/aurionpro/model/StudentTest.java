package com.aurionpro.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class StudentTest {

	Student student;
	StudentMarksService studentService;
	
	@BeforeEach
	void init()
	{
		studentService = Mockito.mock(StudentMarksService.class);
		student = new Student(studentService);
	}

	@Test
	void testGetAverageMarks() {
		Mockito.when(studentService.TotalMarks()).thenReturn(450);
		Mockito.when(studentService.TotalNumberOfSubjects()).thenReturn(5);

		assertEquals(90.00, student.getAverageMarks());
	}

}
