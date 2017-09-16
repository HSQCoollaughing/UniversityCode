package com.hsq.dao;

import java.util.List;

import com.hsq.bean.User;

public interface IUser {
	int AddUser(User user);
	
	int updateUser(User user);
	
	/*
	 * 
	 * �û���¼
	 */

	User login(String loginName, String password);

	/*
	 * 
	 * ����id�����û�
	 */

	User findByID(int id);

	/**
	 * ���������û�
	 */
	List<User> findAllUser();

	/*
	 * ����������ѯ�û�
	 */

	List<User> findByCondition(String userName,String isUpload,String gender,String eduction);

	/**
	 * ����idɾ���û�
	 * 
	 */

	int deleteByID(Integer id);

}
