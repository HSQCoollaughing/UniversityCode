package com.hsq.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.itcast.jdbc.TxQueryRunner;

import com.hsq.dao.IAdmin;
import com.hsq.dto.Admin;
import com.hsq.dto.Book;

public class AdminImpl implements IAdmin {
QueryRunner qr=new TxQueryRunner();
	public Admin adminLogin(String loginName, String password) throws Exception {
		String sql="select * from t_admin where loginName=? and password=?";
		Admin admin = qr.query(sql, new BeanHandler<Admin>(Admin.class),loginName,password);
		return admin;
	}

	public void AddBook(Book book) throws Exception {
		String sql = "insert into t_book(bid,bname,author,price,currPrice," +
				"discount,press,publishtime,edition,pageNum,wordNum,printtime," +
				"booksize,paper,cid,image_w,image_b)" +
				" values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Object[] params = {book.getBid(),book.getBname(),book.getAuthor(),
				book.getPrice(),book.getCurrPrice(),book.getDiscount(),
				book.getPress(),book.getPublishtime(),book.getEdition(),
				book.getPageNum(),book.getWordNum(),book.getPrinttime(),
				book.getBooksize(),book.getPaper(), book.getCategory().getCid(),
				book.getImage_w(),book.getImage_b()};
		qr.update(sql, params);

	}

}
