package com.hsq.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.itcast.commons.CommonUtils;
import cn.itcast.jdbc.TxQueryRunner;

import com.hsq.dao.IOrder;
import com.hsq.dto.Book;
import com.hsq.dto.Order;
import com.hsq.dto.OrderItem;
import com.hsq.dto.Page;

public class OrderImpl implements IOrder {
	/**
	 * 多对1，双向关联 思路：首先由小到大(Order中有List<OrderItem>) 查询出OrderItem表(映射)
	 * 循环遍历List<Order> order order.setOrderItemList(tomanyOrderItemfromMaps);
	 * 
	 * @author hsq
	 * 
	 */

	QueryRunner qr = new TxQueryRunner();

	public Page findByUid(String uid,  String pagenum)
			throws Exception {
		// TODO Auto-generated method stub
		String sql = "select * from t_order where  uid=? order by ordertime desc  limit ?, ?";
		if (pagenum==null) {
			Page page = new Page(TotalRecorde(), 1);
			List<Order> list = qr.query(sql,
					new BeanListHandler<Order>(Order.class), uid, page.getStartindex(),
					5);
			System.out.println(sql);
			for (Order order : list) {
				loadOrderItem(order);
			}
			List<Order> pageData = list;
			page.setList(pageData);
			return  page;
		}else {
			Page page = new Page(TotalRecorde(), Integer.parseInt(pagenum));
			List<Order> list = qr.query(sql,
					new BeanListHandler<Order>(Order.class), uid, page.getStartindex(),
					5);
			for (Order order : list) {
				loadOrderItem(order);
			}
			List<Order> pageData = list;
			page.setList(pageData);
			return  page;
		}
		
		
		
		
		
		
	}

	public int TotalRecorde() {

		String sql = "select count(*) from t_order";
		try {
			Number number = (Number) qr.query(sql, new ScalarHandler());

			return number.intValue();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;

	}
	

	private void loadOrderItem(Order order) {

		try {
			String sql = "select *  from t_orderitem where oid=? ";
			List<Map<String, Object>> MapList = qr.query(sql,
					new MapListHandler(), order.getOid());
			List<OrderItem> tomanyOrderItemfromMaps = tomanyOrderItemfromMaps(MapList);
			order.setOrderItemList(tomanyOrderItemfromMaps);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private OrderItem toaloneOrderItemfromMap(Map<String, Object> map) {

		OrderItem orderItem = CommonUtils.toBean(map, OrderItem.class);
		Book book = CommonUtils.toBean(map, Book.class);
		Order order = CommonUtils.toBean(map, Order.class);
		orderItem.setBook(book);
		orderItem.setOrder(order);
		return orderItem;

	}

	private List<OrderItem> tomanyOrderItemfromMaps(
			List<Map<String, Object>> maps) {
		List<OrderItem> list = new ArrayList<OrderItem>();
		for (Map<String, Object> map : maps) {
			OrderItem toaloneOrderItemfromMap = toaloneOrderItemfromMap(map);
			list.add(toaloneOrderItemfromMap);
		}
		return list;

	}

	/**
	 * 加载订单
	 * 
	 */

	public Order load(String oid) throws Exception {
		// TODO Auto-generated method stub
		String sql = "select * from t_order where oid=?";
		Order order = qr.query(sql, new BeanHandler<Order>(Order.class), oid);
		loadOrderItem(order);
		return order;
	}

	public void createOrder(Order order) throws Exception {
		// TODO Auto-generated method stub
		// INSERT INTO 表名称 VALUES (值1, 值2,....)
		String sql = "insert into t_order values(?,?,?,?,?,?)";
		Object[] param = { order.getOid(), order.getOrdertime(),
				order.getTotal(), order.getStatus(), order.getAddress(),
				order.getOwner().getUid() };
		qr.update(sql, param);
		/*
		 * 2. 循环遍历订单的所有条目,让每个条目生成一个Object[] 多个条目就对应Object[][] 二维数组
		 * 执行批处理，完成插入订单条目
		 */
		sql = "insert into t_orderitem values(?,?,?,?,?,?,?,?)";
		int len = order.getOrderItemList().size();
		Object[][] objs = new Object[len][];
		for (int i = 0; i < len; i++) {
			OrderItem item = order.getOrderItemList().get(i);
			objs[i] = new Object[] { item.getOrderItemId(), item.getQuantity(),
					item.getSubtotal(), item.getBook().getBid(),
					item.getBook().getBname(), item.getBook().getCurrPrice(),
					item.getBook().getImage_b(), order.getOid() };
		}
		qr.batch(sql, objs);
	}

	public Page findALL(String pagenum) throws Exception {
		String sql = "select * from t_order   order by ordertime desc  limit ?, ?";
		if (pagenum==null) {
			Page page = new Page(TotalRecorde(), 1);
			List<Order> list = qr.query(sql,
					new BeanListHandler<Order>(Order.class),  page.getStartindex(),
					5);
			System.out.println(sql);
			for (Order order : list) {
				loadOrderItem(order);
			}
			List<Order> pageData = list;
			page.setList(pageData);
			return  page;
		}else {
			Page page = new Page(TotalRecorde(), Integer.parseInt(pagenum));
			List<Order> list = qr.query(sql,
					new BeanListHandler<Order>(Order.class),  page.getStartindex(),
					5);
			for (Order order : list) {
				loadOrderItem(order);
			}
			List<Order> pageData = list;
			page.setList(pageData);
			return  page;
		}
		
		
	}	
}
