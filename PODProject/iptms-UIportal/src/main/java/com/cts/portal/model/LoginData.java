package com.cts.portal.model;

public class LoginData
{
	static UserData userData;
	
	public static UserData getUserData() {
		if(userData==null)
		{
			userData=new UserData();
		}
		return userData;
	}

	public static void setUserData(UserData userData) {
		LoginData.userData = userData;
	}
	

}
