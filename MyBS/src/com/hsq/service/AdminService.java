package com.hsq.service;

import com.hsq.dao.IAdmin;
import com.hsq.dao.impl.AdminImpl;
import com.hsq.dto.Admin;
import com.hsq.dto.Book;

public class AdminService {
private IAdmin iadmin =new AdminImpl();
public Admin adminLogin(String loginName, String password){
	
	try {
		Admin admin = iadmin.adminLogin(loginName, password);
		return admin;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
	
	
}
public void add(Book book){
	try {
		iadmin.AddBook(book);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
}
}
