package com.hsq.service;

import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import com.hsq.dao.ICartItem;
import com.hsq.dao.impl.CartItemImpl;
import com.hsq.dto.CartItem;

public class CartItemService {
	ICartItem it=new CartItemImpl();
	public List<CartItem> findByUid(String uid){
		try {
			List<CartItem> list = it.QueryCartItemByUid(uid);
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
public void AddCartItem(CartItem cartItem){
	try {
		System.out.println(cartItem);
		it.AddCartItem(cartItem);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
}
/**
 * 合并条目时所需的方法
 * 
 */
public CartItem findByCartItemid(String bid ,String uid)  {
	// TODO Auto-generated method stub
	try {
		CartItem cartItem = it.findByCartItemid(bid, uid);
		return cartItem;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
}
public CartItem updatequantity(int quantity,String cartItemid)  {
	// TODO Auto-generated method stub
	try {
		it.updatequantity(quantity, cartItemid);
		CartItem cartItem = it.findbyCartitemId(cartItemid);
		return cartItem;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
}
public void deleteCartItemId(String cartItemId){
	
	try {
		it.DeleteCartItem(cartItemId);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
}
public List<CartItem> loadMuchCartItemInfo(String cartItemIds)  {
	try {
		List<CartItem> loadMuchCartItemInfo = it.loadMuchCartItemInfo(cartItemIds);
		return loadMuchCartItemInfo;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
}
public void batchDelete(String cartItemids){
	try {
		it.batchDelete(cartItemids);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
	
}
}
