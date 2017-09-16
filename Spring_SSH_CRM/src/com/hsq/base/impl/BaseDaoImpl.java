package com.hsq.base.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.hsq.base.BaseDao;
import com.hsq.bean.CrmCourseType;
import com.hsq.page.PageHibernateCallback;

public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {
	private Class<?> beanClass;
public BaseDaoImpl() {
	//获得运行时的类型
	ParameterizedType paramaType=  (ParameterizedType) this.getClass().getGenericSuperclass();
	beanClass=	(Class<?>) paramaType.getActualTypeArguments()[0];
	
	
	
}
	@Override
	public void save(T t) {
		this.getHibernateTemplate().save(t);
	}

	@Override
	public void delete(T t) {
		this.getHibernateTemplate().update(t);
	}

	@Override
	public void update(T t) {
		this.getHibernateTemplate().update(t);
	}

	@Override
	public void saveOrUpdate(T t) {
		this.getHibernateTemplate().saveOrUpdate(t);
	}

	@Override
	public T findById(Serializable id) {
		System.out.println("【【【【【【"+id);
		return (T) this.getHibernateTemplate().get(beanClass,id);
	}

	@Override
	public List<T> findAll() {
		//hql语句完整写法全限定类名
		//是类的全限定类名
		System.out.println("】】】】】】】】】"+beanClass.getName());
		return this.getHibernateTemplate().find("from " + beanClass.getName());
	}
	@Override
	public List<T> findAll(String condition, Object[] params) {
		
		String hql=" from " + beanClass.getName() + " where 1=1"+ condition;
		return this.getHibernateTemplate().find(hql,params);
	}
	@Override
	public int getTotalRecode(String condition,Object[] array) {
		
		String hql=" select count(c) from " + beanClass.getName() + " c where 1=1 " + condition;
		List<Long> find = this.getHibernateTemplate().find(hql,array);
		return find.get(0).intValue();
	}

	@Override
	public List<T> findAll(String condition, Object[] array,
			int startIndex, int pageSize) {
		String hql=" from " + beanClass.getName() + " where 1=1"+ condition;
		//自定义实现类；
		List<T> list = (List<T>) this.getHibernateTemplate().execute(new PageHibernateCallback<T>().setHql(hql).setPageSize(pageSize).setParams(array).setStartIndex(startIndex));
		return list;
	}


}
