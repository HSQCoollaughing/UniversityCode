package com.hsq.service;

import java.util.List;

import com.hsq.dao.ICategory;
import com.hsq.dao.impl.CategoryImpl;
import com.hsq.dto.Category;

public class CategoryService {
	ICategory ic=new CategoryImpl();
	public List<Category> findAllCategory(){
		try {
			List<Category> list = ic.findAllCategory();
			//System.out.println(list);
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		
	}

}
