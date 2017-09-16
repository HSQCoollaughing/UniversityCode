package com.hsq.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hsq.bean.Customer;
import com.hsq.bean.QueryVo;
import com.hsq.mapper.CustomerDao;
import com.hsq.util.Page;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerDao customerDao;

	public Page<Customer> selectPageByQueryVo(QueryVo vo) {
	Page<Customer> page = new Page<Customer>();
	page.setSize(10);
	//vo.setSize(5);
	if (null!=vo) {
		if (null != vo.getPage()) {
			page.setPage(vo.getPage());
			vo.setStartRow((vo.getPage() -1)*vo.getSize());
		}
		if(null != vo.getCustName() && !"".equals(vo.getCustName().trim())){
			vo.setCustName(vo.getCustName().trim());
		}
		if(null != vo.getCustSource() && !"".equals(vo.getCustSource().trim())){
			vo.setCustSource(vo.getCustSource().trim());
		}
		if(null != vo.getCustIndustry() && !"".equals(vo.getCustIndustry().trim())){
			vo.setCustIndustry(vo.getCustIndustry().trim());
		}
		if(null != vo.getCustLevel() && !"".equals(vo.getCustLevel().trim())){
			vo.setCustLevel(vo.getCustLevel().trim());
		}
		//总条数
		page.setTotal(customerDao.customerCountByQueryVo(vo));
		page.setRows(customerDao.selectCustomerListByQueryVo(vo));
	}
		return page;
	}

	public Customer selectById(Integer id) {
		return customerDao.selectById(id);
	}

	public void updateCustomer(Customer customer) {
customerDao.updateCustomer(customer);		
	}

	public void deleteByID(Integer id) {
customerDao.deleteByID(id);		
	}

}
