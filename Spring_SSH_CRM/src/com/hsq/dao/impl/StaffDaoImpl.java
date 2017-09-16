package com.hsq.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.hsq.base.impl.BaseDaoImpl;
import com.hsq.bean.CrmStaff;
import com.hsq.dao.StaffDao;

public class StaffDaoImpl extends BaseDaoImpl<CrmStaff> implements StaffDao {

	@Override
	public CrmStaff find(CrmStaff crmStaff) {
		
		
		List<CrmStaff> listCrmStaffs = this.getHibernateTemplate().find("from CrmStaff where LoginName=? and loginPwd=?",crmStaff.getLoginName(),crmStaff.getLoginPwd());
		if (listCrmStaffs.size()==1) {
			return listCrmStaffs.get(0);
		}
		return null;
	}

//	@Override
//	public List<CrmStaff> findAll() {
//		return this.getHibernateTemplate().find("from CrmStaff");
//	}
//
//	@Override
//	public CrmStaff findById(String id) {
//		return this.getHibernateTemplate().get(CrmStaff.class, id);
//	}

}
