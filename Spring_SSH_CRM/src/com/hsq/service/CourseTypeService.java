package com.hsq.service;

import java.util.List;

import com.hsq.bean.CrmCourseType;
import com.hsq.page.PageBean;

public interface CourseTypeService {
	public List<CrmCourseType> findAll();
	public CrmCourseType findById(String courseTypeId);
	public void addOrEdit(CrmCourseType courseType);
	public List<CrmCourseType> findAll(CrmCourseType courseType);
	public PageBean<CrmCourseType> findAll(CrmCourseType courseType,int pageNum,int pageSize);
	
}
