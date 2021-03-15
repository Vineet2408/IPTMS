package com.cts.authorization.test.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import com.cts.authorization.model.UserData;
import com.cts.authorization.repository.AdminRepository;
import com.cts.authorization.service.MyUserDetailsService;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class MyUserDetailServiceTest 
{
	UserDetails userdetails;
	
	@Autowired
	MyUserDetailsService userDetailservice;

	/*@Mock
	AdminRepository repo;
*/
	@Test
	public void loadUserByUsernameTest() {
		
		UserData user1=new UserData("101","admin","pwd123","");
	
		
		UserDetails loadUserByUsername2 = userDetailservice.loadUserByUsername("admin");
		assertEquals(user1.getUname(),loadUserByUsername2.getUsername());
	}

}
