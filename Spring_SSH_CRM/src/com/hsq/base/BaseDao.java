package com.hsq.base;

import java.util.List;

import com.hsq.bean.CrmCourseType;

public interface BaseDao<T> {
	public void save(T t);
	public void delete(T t);
	public void update(T t);
	public void saveOrUpdate(T t);
	
	
	
	public T findById(java.io.Serializable id);
	public List<T> findAll();
	
	public List<T> findAll(String condition, Object[] params);
	
	
	public int getTotalRecode(String condition,Object[] array);
	public List<T> findAll(String condition, Object[] array, int startIndex,
			int pageSize);
	
}
