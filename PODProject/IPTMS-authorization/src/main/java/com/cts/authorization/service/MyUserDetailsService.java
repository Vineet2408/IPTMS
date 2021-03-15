package com.cts.authorization.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cts.authorization.model.UserData;
import com.cts.authorization.repository.AdminRepository;

@Service
public class MyUserDetailsService implements UserDetailsService{

	@Autowired
	AdminRepository repo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		UserData user=repo.findById(username).orElse(null);
		return new User(user.getUname(),"pwd123",new ArrayList<>());
	}

	
}
