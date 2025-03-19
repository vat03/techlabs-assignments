package com.aurionpro.security.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aurionpro.security.entity.Role;

public interface RoleRepo extends JpaRepository<Role, Integer> {
	Optional<Role> findByRolename(String rolename);
}
