package com.hsq.service;

import java.util.List;

import com.hsq.bean.CrmStaff;

public interface StaffService {
	
	
	public CrmStaff login(CrmStaff crmStaff);
	public List<CrmStaff> findAllStaff();
	public CrmStaff findById(String staffid);
	public void updateStaff(CrmStaff staff);
}
