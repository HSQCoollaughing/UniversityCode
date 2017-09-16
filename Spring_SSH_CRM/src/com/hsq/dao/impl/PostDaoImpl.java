package com.hsq.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.hsq.bean.CrmDepartment;
import com.hsq.bean.CrmPost;
import com.hsq.dao.PostDao;

public class PostDaoImpl extends HibernateDaoSupport implements PostDao {
//HQL语句是面向对象的
	@Override
	public List<CrmPost> findAll(CrmDepartment department) {
		return this.getHibernateTemplate().find("from CrmPost where department = ?", department);
	}

}
