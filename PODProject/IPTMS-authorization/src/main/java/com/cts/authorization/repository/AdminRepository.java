package com.cts.authorization.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.authorization.model.UserData;
public interface AdminRepository extends JpaRepository<UserData, String>{
	
}
