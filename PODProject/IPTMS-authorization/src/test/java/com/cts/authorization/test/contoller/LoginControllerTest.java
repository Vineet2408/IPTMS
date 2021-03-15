package com.cts.authorization.test.contoller;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Optional;

import com.cts.authorization.controller.LoginController;
import com.cts.authorization.model.AuthResponse;
import com.cts.authorization.model.JwtToken;
import com.cts.authorization.model.UserData;
import com.cts.authorization.repository.AdminRepository;
import com.cts.authorization.service.MyUserDetailsService;
import com.cts.authorization.util.JwtUtil;

@SpringBootTest
public class LoginControllerTest
{
	

		@InjectMocks
		LoginController authController;

		AuthResponse authResponse;

		UserDetails userdetails;

		@Mock
		JwtUtil jwtutil;

		@Mock
		MyUserDetailsService custdetailservice;

		@Mock
		AdminRepository userservice;
		
		
		@Test
		public void loginTest() throws Exception {

			UserData user = new UserData("101", "admin", "pwd123", "");
			UserDetails loadUserByUsername = custdetailservice.loadUserByUsername("admin");
			UserDetails value = new User(user.getUname(), user.getUpassword(), new ArrayList<>());
			
			when(custdetailservice.loadUserByUsername("admin")).thenReturn(value);
			when(jwtutil.generateJwt(loadUserByUsername)).thenReturn("token");
			
			ResponseEntity<?> login = authController.loginUser(user);
			assertEquals( 200 , login.getStatusCodeValue() );
		}

		@Test
		public void loginTestFailed() {

			UserData user = new UserData("admin", "admin", null, null);
			UserDetails loadUserByUsername = custdetailservice.loadUserByUsername("admin");
			UserDetails value = new User(user.getUname(), "admin11", new ArrayList<>());
			
			when(custdetailservice.loadUserByUsername("admin")).thenReturn(value);
			when(jwtutil.generateJwt(loadUserByUsername)).thenReturn("token");
			
			ResponseEntity<?> login = null;
			try {
				login = authController.loginUser(user);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			assertEquals( login.getStatusCodeValue() , 403);
		}

		@Test
		public void validateTestValidtoken() {
			when(jwtutil.validateToken("token")).thenReturn(true);
			when(jwtutil.extractUsername("token")).thenReturn("admin");
			
			UserData user1 = new UserData("101", "admin", "pwd123", "");
			Optional<UserData> data = Optional.of(user1);
			when(userservice.findById("admin")).thenReturn(data);
			
			ResponseEntity<?> validity = authController.getValidity(new JwtToken("token"));
			assertEquals( true ,  validity.getBody().toString().contains("true") );

		}

		@Test
		public void validateTestInValidtoken() {
			when(jwtutil.validateToken("token")).thenReturn(false);
			ResponseEntity<?> validity = authController.getValidity(new JwtToken("bearer token"));
			assertEquals( true ,  validity.getBody().toString().contains("false") );
		}

	}
