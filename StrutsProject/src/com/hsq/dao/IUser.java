package com.hsq.dao;

import java.util.List;

import com.hsq.bean.User;

public interface IUser {
	int AddUser(User user);
	
	int updateUser(User user);
	
	/*
	 * 
	 * 用户登录
	 */

	User login(String loginName, String password);

	/*
	 * 
	 * 根据id查找用户
	 */

	User findByID(int id);

	/**
	 * 查找所有用户
	 */
	List<User> findAllUser();

	/*
	 * 根据条件查询用户
	 */

	List<User> findByCondition(String userName,String isUpload,String gender,String eduction);

	/**
	 * 根据id删除用户
	 * 
	 */

	int deleteByID(Integer id);

}
