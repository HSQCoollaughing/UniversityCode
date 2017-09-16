package com.hsq.dao;

import com.hsq.dto.Admin;
import com.hsq.dto.Book;

public interface IAdmin {
	public Admin adminLogin(String loginName,String password)throws Exception;
	public  void AddBook(Book book)throws Exception;

}
