package com.hsq.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import cn.itcast.commons.CommonUtils;
import cn.itcast.jdbc.TxQueryRunner;

import com.hsq.dao.ICartItem;
import com.hsq.dto.Book;
import com.hsq.dto.CartItem;
import com.hsq.dto.User;

public class CartItemImpl implements ICartItem {
QueryRunner qr=new TxQueryRunner();
	public void AddCartItem(CartItem cartItem) throws Exception {
		// TODO Auto-generated method stub
String sql="insert into t_cartitem(cartitemId,quantity,uid,bid) value(?,?,?,?)  ";
qr.update(sql,cartItem.getCartItemId(), cartItem.getQuantity(),cartItem.getUser().getUid(),cartItem.getBook().getBid());
	}
	/**
	 * 
	 * 多表查询，生成购物车
	 * 
	 */

	public List<CartItem> QueryCartItemByUid(String uid) throws Exception {
		// TODO Auto-generated method stub
		//消除笛卡尔积（重复）
		String sql="select * from t_book b ,  t_cartitem c  where b.bid=c.bid  and  uid=?";
		 List<Map<String, Object>> list = qr.query(sql, new MapListHandler(),uid);
		System.out.println(list);
		List<CartItem> tomuchCartItems = tomuchCartItems(list);
		System.out.println(list);
		return tomuchCartItems;
	}
	/**
	 * 
	 * 把一个map映射成一个CartItem对象
	 * 
	 */
        private CartItem toCartItem(Map<String, Object> map){
        	CartItem cartitem = CommonUtils.toBean(map, CartItem.class);
        User user =CommonUtils.toBean(map, User.class);
        	Book book = CommonUtils.toBean(map, Book.class);
        	System.out.println("book"+book);
        	cartitem.setUser(user);
        	cartitem.setBook(book);
        	
        	
			return cartitem;
	
	
	
}
       /**
        * 
        * 把多个map映射成多个CartItem对象
        * 
        */
private List<CartItem> tomuchCartItems(List<Map<String,Object>> listmap){
	List<CartItem> listCartItem=new ArrayList<CartItem>();
	for (Map<String, Object> map : listmap) {
		CartItem cartItem = toCartItem(map);
		listCartItem.add(cartItem);
	}
	return listCartItem;
	
	
	
}

/**
 * 合并条目时所需的方法
 * 
 */

	public CartItem findByCartItemid(String bid ,String uid) throws Exception {
		// TODO Auto-generated method stub
		String sql="select * from t_cartitem where bid=? and uid=?";
		Map<String, Object> map = qr.query(sql, new MapHandler(),bid,uid);
		/*
		 * 映射时注意和Dto里面的字段一样
		 * 
		 */
		CartItem cartItem = toCartItem(map);
		return cartItem;
	}
public void updatequantity(int quantity,String cartItemid) throws Exception {
	// TODO Auto-generated method stub
	String sql="update t_cartitem set quantity=? where cartitemId=?";
	qr.update(sql,quantity,cartItemid);
}
public void DeleteCartItem(String cartItemId) throws Exception {
	// TODO Auto-generated method stub
	String sql="delete from t_cartitem where cartItemId=?";
	qr.update(sql,cartItemId);
	
	
}
/**
 * 
 * 生成where子句
 * 
 * @param len
 * @return
 */
private String toWheresql(int len){
	StringBuilder sb = new StringBuilder("cartItemId in(");
	for (int i = 0; i < len; i++) {
		sb.append("?");
		if (i<len-1) {
			sb.append(",");
		}
		
	}
	sb.append(")");
	return sb.toString();
	
	
	
}


/**
 * 
 * 加载多个cartitem一起生成订单；为生成订单做准备
 */
public List<CartItem> loadMuchCartItemInfo(String cartItemIds) throws Exception {
	Object[] split = cartItemIds.split(",");
	System.out.println(split.toString());
	String sql="select * from t_book b , t_cartitem c where b.bid=c.bid and "+toWheresql(split.length);
	List<Map<String, Object>> listMap = qr.query(sql, new MapListHandler(),split);
	List<CartItem> listCartItem = tomuchCartItems(listMap);
	System.out.println(sql);
	return listCartItem;
}
public CartItem findbyCartitemId(String cartItemid) throws Exception {
	// TODO Auto-generated method stub
	String sql = "select * from t_cartItem c, t_book b where c.bid=b.bid and c.cartItemId=?";
	Map<String,Object> map = qr.query(sql, new MapHandler(), cartItemid);
	CartItem cartItem = toCartItem(map);
	return cartItem;
}
public void batchDelete(String cartItemids) throws Exception {
	// TODO Auto-generated method stub
	Object[] param = cartItemids.split(",");
	String sql="delete from t_cartitem where "+toWheresql(param.length);
	qr.update(sql,param);
}

}