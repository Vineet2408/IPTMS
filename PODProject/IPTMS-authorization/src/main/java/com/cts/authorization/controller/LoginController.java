package com.cts.authorization.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.authorization.model.AuthResponse;
import com.cts.authorization.model.JwtToken;
import com.cts.authorization.model.UserData;
import com.cts.authorization.service.MyUserDetailsService;
import com.cts.authorization.util.JwtUtil;

import io.swagger.annotations.ApiOperation;

@RestController()
@RequestMapping("/auth")
public class LoginController 
{
	@Autowired
	private JwtUtil jwtutil;
	@Autowired
	MyUserDetailsService service;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
	
	@PostMapping("/loginuser")
	@ApiOperation(value = "Match username and password , and generate jwt token",
	notes="Provide corect username and password to look up data for admin login from database")
	public ResponseEntity<?> loginUser(@RequestBody UserData userlogincredentials)throws Exception
	{
		LOGGER.info("START");
		
		final UserDetails userdetails = service.loadUserByUsername(userlogincredentials.getUname());
		LOGGER.info("userdata : "+userlogincredentials.toString());
		LOGGER.info("userdetails object "+userdetails.getUsername());
		LOGGER.info("END");
		String uid = "";
		String generateToken = "";
		System.out.println();
		if( (userdetails.getPassword().equals(userlogincredentials.getUpassword())) &&(userdetails.getUsername().equals(userlogincredentials.getUname()))){
			uid = userlogincredentials.getUname();
			generateToken = jwtutil.generateJwt(userdetails);
			return new ResponseEntity<>(new UserData(uid, uid, null, generateToken), HttpStatus.OK);
		} else {
			
			return new ResponseEntity<>("Not Accesible", HttpStatus.FORBIDDEN);
		}
	}
	
	@PostMapping(value = "/validate")
	@ApiOperation(value = "Validate the given token in request body ",
	notes="Provide valid jwt token for successful login")
	public ResponseEntity<?> getValidity(@RequestBody JwtToken jwtToken) {
		// Returns response after Validating received token
		String token=jwtToken.getToken();
		AuthResponse res = new AuthResponse();
		if (token == null) {
			res.setValid(false);
			LOGGER.info("START");
			LOGGER.info("in auth validation if token is null : "+token);
			LOGGER.info("END");
			
			return new ResponseEntity<>(res, HttpStatus.FORBIDDEN);
		} else {
			String token1 = token.substring(0);
			if (jwtutil.validateToken(token1)) {
				res.setUid(jwtutil.extractUsername(token1));
				res.setValid(true);
				res.setName("admin");
				LOGGER.info("START");
				LOGGER.info("in auth validation if token is correct : "+token);
				LOGGER.info("END");
			} else {
				res.setValid(false);
				LOGGER.info("At Validity : ");
				LOGGER.error("Token Has Expired");
				return new ResponseEntity<>(res, HttpStatus.FORBIDDEN);

			}
		}
		return new ResponseEntity<>(res, HttpStatus.OK);

	}
	

}
