package com.hsq.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hsq.bean.BaseDict;
import com.hsq.bean.Customer;
import com.hsq.bean.QueryVo;
import com.hsq.service.BaseDictService;
import com.hsq.service.CustomerService;
import com.hsq.util.Page;

@Controller
public class CustomerController {
	@Value("${customer.from.type}")
	private String industryType;
	
	@Autowired
	private BaseDictService baseDictService;
	
	@Autowired
	private CustomerService customerService;
	@RequestMapping(value="/customer/list")
	public String list(QueryVo vo , Model model){
		List<BaseDict> fromTypeList = baseDictService.selectBaseDictByCode(industryType);
		List<BaseDict> industryTypeList = baseDictService.selectBaseDictByCode("001");
		List<BaseDict> levelTypeList = baseDictService.selectBaseDictByCode("006");
		model.addAttribute("fromType",fromTypeList);
		model.addAttribute("industryType",industryTypeList);
		model.addAttribute("levelType",levelTypeList);
		
		
		Page<Customer> pageBean = customerService.selectPageByQueryVo(vo);
		model.addAttribute("custName", vo.getCustName());
		model.addAttribute("custSource", vo.getCustSource());
		model.addAttribute("custIndustry", vo.getCustIndustry());
		model.addAttribute("custLevel", vo.getCustLevel());
		model.addAttribute("pageBean", pageBean);
		return "customer";
	}
	@RequestMapping(value="/customer/edit.action")
	
	public @ResponseBody
	
	
	Customer edit(Integer id){
		
		Customer selectById = customerService.selectById(id);
		return selectById;
		
	}
	
@RequestMapping(value="/customer/update.action")
public @ResponseBody


String update(Customer customer){
	customerService.updateCustomer(customer);
	
	return "OK";
	
	
}

@RequestMapping(value="/customer/delete.action")

public @ResponseBody
String delete(Integer id){
	
	customerService.deleteByID(id);
	return "ok";
	
}

}
