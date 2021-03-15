package com.cts.authorization.test.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import com.cts.authorization.util.JwtUtil;

@SpringBootTest
public class JwtTest
{

	@InjectMocks
	JwtUtil jwtUtil;
	
	UserDetails userdetails;

	@Test
	public void generateTokenTest() {
		userdetails = new User("admin", "pwd123", new ArrayList<>());
		String generateToken = jwtUtil.generateJwt(userdetails);
		assertNotNull(generateToken);
	}
	
	@Test
	public void validateTokenTest() {
		userdetails = new User("admin", "pwd123", new ArrayList<>());
		String generateToken = jwtUtil.generateJwt(userdetails);
		Boolean validateToken = jwtUtil.validateToken(generateToken);
		assertEquals(true, validateToken);
	}
	
	@Test
	public void validateFalseToken()
	{
		userdetails = new User("admin", "pwd", new ArrayList<>());
		String generateToken = jwtUtil.generateJwt(userdetails);
		try {
		String genToken="dsdssomerandomevalue";
		Boolean validateToken = jwtUtil.validateToken(genToken);
		assertEquals(false, validateToken);
		}catch(Exception e)
		{
			
		}
		
	}
}
