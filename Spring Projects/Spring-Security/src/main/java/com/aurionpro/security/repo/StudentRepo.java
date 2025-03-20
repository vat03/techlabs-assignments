package com.aurionpro.security.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aurionpro.security.entity.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {

}
