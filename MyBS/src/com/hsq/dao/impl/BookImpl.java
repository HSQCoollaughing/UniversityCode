package com.hsq.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import cn.itcast.commons.CommonUtils;
import cn.itcast.jdbc.TxQueryRunner;

import com.hsq.dao.IBook;
import com.hsq.dto.Book;
import com.hsq.dto.Category;

public class BookImpl implements IBook {

	private QueryRunner qr = new TxQueryRunner();
	
	
	

	public List<Book> findByCategory(String cid) throws SQLException {
		// TODO Auto-generated method stub
		String sql="select * from t_book where cid=?";
		List<Book> list = qr.query(sql, new BeanListHandler<Book>(Book.class),cid);
		return list;
	}




	public Book findByid(String bid) throws Exception {
		String sql="select * from t_book where bid=?";
		Book book = qr.query(sql, new BeanHandler<Book>(Book.class),bid);
		return book;
	}




	public List<Book> findAllBook() throws Exception {
		String sql="select * from t_book b ,t_category c  where b.cid=c.cid ";
		List<Map<String, Object>> maps = qr.query(sql, new MapListHandler());
		List<Book> books = toBooks(maps);
		return books;
	}

	private Book toBook(Map<String ,Object> map){
		
		Book book = CommonUtils.toBean(map, Book.class);
		Category category = CommonUtils.toBean(map, Category.class);
		book.setCategory(category);
		return book;
		
	}
	private List<Book>  toBooks(List<Map<String ,Object>> maps){
		List<Book> listBook=new ArrayList<Book>();
		for (Map<String, Object> map : maps) {
			Book book = toBook(map);
			listBook.add(book);
		}
		return listBook;
		
	}




	public void editBook(Book book) throws Exception {
		String sql = "update t_book set bname=?,author=?,price=?,currPrice=?," +
				"discount=?,press=?,publishtime=?,edition=?,pageNum=?,wordNum=?," +
				"printtime=?,booksize=?,paper=?,cid=? where bid=?";
		Object[] params = {book.getBname(),book.getAuthor(),
				book.getPrice(),book.getCurrPrice(),book.getDiscount(),
				book.getPress(),book.getPublishtime(),book.getEdition(),
				book.getPageNum(),book.getWordNum(),book.getPrinttime(),
				book.getBooksize(),book.getPaper(), 
				book.getCategory().getCid(),book.getBid()};
		qr.update(sql, params);
		
	}




	public void deleteBook(String bid) throws Exception {
		// TODO Auto-generated method stub
		String sql="delete from t_book where bid=?  ";
		qr.update(sql,bid);
	}




	public List<Book> findBylike(String express) throws Exception {
		// TODO Auto-generated method stub
		
		String sql="select * from t_book where bname like '%"+express+"%'";
		System.out.println(sql);
		List<Book> list = qr.query(sql, new BeanListHandler<Book>(Book.class));
		return list;
	}

}
