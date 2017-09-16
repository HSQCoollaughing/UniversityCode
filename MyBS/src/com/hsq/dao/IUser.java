package com.hsq.dao;

import com.hsq.dto.User;

public interface IUser {
public User Userlogin(String loginName, String password) throws Exception;
public void regist(User user)throws Exception;
public boolean ajaxloginName(String loginName)throws Exception;
}
