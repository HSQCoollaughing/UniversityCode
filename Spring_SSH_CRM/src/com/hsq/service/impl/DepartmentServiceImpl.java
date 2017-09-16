package com.hsq.service.impl;

import java.util.List;

import com.hsq.bean.CrmDepartment;
import com.hsq.dao.DepartmentDao;
import com.hsq.service.DepartmentService;

public class DepartmentServiceImpl implements DepartmentService {
	private DepartmentDao departmentDao;
	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}
	@Override
	public List<CrmDepartment> findAll() {
		return departmentDao.findAll();
	}

}
