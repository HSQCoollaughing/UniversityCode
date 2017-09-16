package com.hsq.mapper;

import java.util.List;

import com.hsq.bean.Customer;
import com.hsq.bean.QueryVo;

public interface CustomerDao {

	int customerCountByQueryVo(QueryVo vo);

	List<Customer> selectCustomerListByQueryVo(QueryVo vo);
	
	public Customer selectById(Integer id);
	
	public void updateCustomer(Customer customer);

	
	public void deleteByID(Integer id);
}
