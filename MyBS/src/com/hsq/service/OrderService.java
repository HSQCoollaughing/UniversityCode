package com.hsq.service;

import java.sql.SQLException;
import java.util.List;

import cn.itcast.jdbc.JdbcUtils;

import com.hsq.dao.IOrder;
import com.hsq.dao.impl.OrderImpl;
import com.hsq.dto.Order;
import com.hsq.dto.Page;
import com.sun.org.apache.regexp.internal.recompile;

public class OrderService {
	IOrder io=new OrderImpl();
	public Page findByUid(String uid,  String pagenum){
			try {
				Page page = io.findByUid(uid,  pagenum);
				System.out.println("vvvpage"+page);
				return page;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
				return null;
		
	}
	
	
	public Order load(String oid){
		
		
		try {
			JdbcUtils.beginTransaction();//开启事务，多张表操作
			
		Order	order = io.load(oid);
		JdbcUtils.commitTransaction();
		return order;
		} catch (Exception e) {
			try {
				JdbcUtils.rollbackTransaction();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			throw new RuntimeException(e);
		}
		
		
		
	}
	public void createOrder(Order order){
		try {
			io.createOrder(order);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	public Page findAll(String pagenum){
		
		
		try {
			 Page page = io.findALL(pagenum);
			 System.out.println("findAll"+page);
			return page;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			// throw 	new RuntimeException(e);不用return null
		}
		return null;
		
	}

}
