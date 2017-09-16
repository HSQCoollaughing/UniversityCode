package com.hsq.service;

import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;

import com.hsq.dao.IBook;
import com.hsq.dao.impl.BookImpl;
import com.hsq.dto.Book;

public class BookService {
	IBook ib=new BookImpl();
	public List<Book> findByCategory(String  cid){
		try {
			List<Book> list = ib.findByCategory(cid);
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		
	}
	public Book findByid(String bid)  {
		
		try {
			 Book book = ib.findByid(bid);
			return book;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	public List<Book> findAllBook(){
		try {
			List<Book> books = ib.findAllBook();
			return books;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		
		
	}
	public void deleteBook(String bid){
		try {
			ib.deleteBook(bid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public void editBook(Book book){
		
		try {
			ib.editBook(book);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public List<Book> findBylike(String express){
		try {
			List<Book> list = ib.findBylike(express);
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		
		
		
	}
}
