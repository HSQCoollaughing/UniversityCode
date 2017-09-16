package com.hsq.dao;

import java.util.List;

import com.hsq.dto.Book;
import com.hsq.dto.CartItem;

public interface ICartItem {
	public void AddCartItem(CartItem cartItem)throws Exception;
	public List<CartItem> QueryCartItemByUid(String Uid)throws Exception;
public CartItem findByCartItemid(String bid, String uid) throws Exception;//合并购物车
public void updatequantity(int quantity,String cartItemid) throws Exception;
public void DeleteCartItem(String cartItemId)throws Exception;
public List<CartItem> loadMuchCartItemInfo(String cartItemId)throws Exception;
public CartItem findbyCartitemId(String cartItemid)	 throws Exception;
public void batchDelete(String cartItemids) throws Exception;
}
