package com.hsq.service;

import com.hsq.bean.Customer;
import com.hsq.bean.QueryVo;
import com.hsq.util.Page;

public interface CustomerService {
	//业务逻辑层，不是基本的增删改查
	public Page<Customer> selectPageByQueryVo(QueryVo vo);	
	public Customer selectById(Integer id);
	public void updateCustomer(Customer customer);
	public void deleteByID(Integer id);

}
