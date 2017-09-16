package com.hsq.dao;

import java.util.List;

import com.hsq.base.BaseDao;
import com.hsq.bean.CrmDepartment;
import com.hsq.bean.CrmStaff;

public interface StaffDao extends BaseDao<CrmStaff> {
	public CrmStaff find(CrmStaff crmStaff); 
//	public List<CrmStaff> findAll();
//	public CrmStaff findById(String id);
}
