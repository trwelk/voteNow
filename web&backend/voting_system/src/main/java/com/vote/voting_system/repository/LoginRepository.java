package com.vote.voting_system.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vote.voting_system.Model.Login;
import com.vote.voting_system.Model.Role;

public interface LoginRepository extends JpaRepository<Login, Integer> {

	Optional<Login> findByUsernameAndPassword(String username,String password);
	
	Optional<Login> findById(int login_id);
	int countByStatus(int status_id);
	int countByRoleBeanId(int role_id);
}
