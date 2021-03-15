package com.cts.portal.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.cts.portal.model.AuthResponse;
import com.cts.portal.model.JwtToken;
import com.cts.portal.model.UserData;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
@Service
public class IPTMSAuthoriztionService 
{
	private static final Logger LOGGER = LoggerFactory.getLogger(IPTMSAuthoriztionService.class);

	private final String BASEURL = "http://localhost:8084";
	OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
	
	Retrofit retrofit = new Retrofit.Builder()
	  .baseUrl(BASEURL)
	  .addConverterFactory(GsonConverterFactory.create())
	  .client(httpClient.build())
	  .build();
	IPTMSAuthorizationInterface authService = retrofit.create(IPTMSAuthorizationInterface.class);
	
	public String loginUser(UserData user)
	{
		UserData resUser = null;
		Call<UserData> callsync= authService.login(user);
		try{
			
			Response<UserData> response=callsync.execute();
			resUser = response.body();		    
			LOGGER.info("START");
			LOGGER.debug("in loginuser : resuser : "+resUser.toString());
			LOGGER.info("END");
			
		}
		catch(Exception e)
		{
			return "";
		}
		
		return resUser.getAuthToken();
	}

	public Boolean isSessionValid(String token) {
		System.out.println("in validation the recieved token is : "+token);
		JwtToken jwtToken=new JwtToken(token);
		try {
			Call<AuthResponse> callsync = authService.getValidity(jwtToken);
			Response<AuthResponse> response = callsync.execute();
			AuthResponse authResponse=response.body();
			LOGGER.info("START");
			LOGGER.debug(String.valueOf(authResponse.isValid()));
			LOGGER.info("END");
		} catch (Exception e) {
			LOGGER.info("START");
			LOGGER.debug(String.valueOf(false));
			LOGGER.info("END");
			return false;
		}
		return true;
	}

}
