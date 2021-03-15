package com.cts.authorization.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cts.authorization.model.UserCredential;

@Service
public class LoginService 
{
	HashMap<String ,String> userMap=new HashMap<String ,String>();
	
	public LoginService()
	{
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("user.xml");
		List<UserCredential> list=(List<UserCredential>) context.getBean("userList");
		
		for(UserCredential uc:list)
		{
			String name=uc.getName();
			String pass=uc.getPassword();
			this.userMap.put(name,pass);
		}
	}
	
	public boolean matchUser(UserCredential userLogin)
	{
		int f=0;
		String name=userLogin.getName();
		String pass=userLogin.getPassword();
		if(userMap.containsKey(name))
		{
			if(pass.equals(userMap.get(name)))
			{
				f=1;
			}
		}
		if(f==0)
		{
			return false;
		}
		else
			return true;
			
	}

}
