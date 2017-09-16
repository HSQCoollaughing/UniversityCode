package com.hsq.service;

import com.hsq.dao.IUser;
import com.hsq.dao.impl.UserImpl;
import com.hsq.dto.User;

public class UserService {
	IUser iu=new UserImpl();
	public User Userlogin(String loginName, String password){
		try {
			User user = iu.Userlogin(loginName, password);
			return user;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
public void Userregist(User user){
	try {
		iu.regist(user);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
public boolean ajaxloginName(String loginName){
	try {
		boolean ajaxloginName = iu.ajaxloginName(loginName);
		return ajaxloginName;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return false;
	
	
	
}
}
