package com.hsq.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.hsq.base.impl.BaseDaoImpl;
import com.hsq.bean.CrmCourseType;
import com.hsq.dao.CourseTypeDao;
import com.hsq.page.PageHibernateCallback;

public class CourseTypeDaoImpl extends BaseDaoImpl<CrmCourseType> implements CourseTypeDao {

//	@Override
//	public List<CrmCourseType> findAll() {
//		return this.getHibernateTemplate().find("from CrmCourseType");
//	}

//	@Override
//	public List<CrmCourseType> findAll(String condition, Object[] params) {
//		
//		String hql="from CrmCourseType where 1=1"+condition;
//		return this.getHibernateTemplate().find(hql,params);
//	}

//	@Override
//	public CrmCourseType findById(String courseTypeId) {
//		return this.getHibernateTemplate().get(CrmCourseType.class, courseTypeId);
//	}
//
//	@Override
//	public void saveOrUpdate(CrmCourseType courseType) {
//		this.getHibernateTemplate().saveOrUpdate(courseType);
//	}

//	@Override
//	public int getTotalRecode(String condition,Object[] array) {
//		
//		String hql=" select count(c) from CrmCourseType c where 1=1 "+condition;
//		List<Long> find = this.getHibernateTemplate().find(hql,array);
//		return find.get(0).intValue();
//	}
//
//	@Override
//	public List<CrmCourseType> findAll(String condition, Object[] array,
//			int startIndex, int pageSize) {
//		String hql="from CrmCourseType where 1=1"+condition;
//		//自定义实现类；
//		List<CrmCourseType> list = this.getHibernateTemplate().execute(new PageHibernateCallback<CrmCourseType>().setHql(hql).setPageSize(pageSize).setParams(array).setStartIndex(startIndex));
//		return list;
//	}

}
