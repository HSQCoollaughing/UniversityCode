package com.hsq.dao;

import java.util.List;

import com.hsq.dto.Book;
import com.hsq.dto.Category;

public interface IBook {
	public Book findByid(String bid) throws Exception;
	public List<Book> findByCategory(String cid) throws Exception;
	public List<Book> findAllBook()throws Exception;
public void editBook(Book book) throws Exception;
public void deleteBook(String bid) throws Exception;
public List<Book> findBylike(String express) throws Exception;
}
