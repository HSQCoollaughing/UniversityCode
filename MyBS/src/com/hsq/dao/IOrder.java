package com.hsq.dao;

import com.hsq.dto.Order;
import com.hsq.dto.Page;

public interface IOrder {
public Page findByUid(String uid, String pagenum)throws Exception;
public   Order   load(String oid)throws Exception;
public void createOrder(Order order)throws Exception;	
	public Page findALL(String pagenum) throws Exception;
	
	

}
