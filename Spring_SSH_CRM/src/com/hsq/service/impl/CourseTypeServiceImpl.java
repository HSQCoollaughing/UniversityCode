package com.hsq.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.hsq.bean.CrmCourseType;
import com.hsq.dao.CourseTypeDao;
import com.hsq.page.PageBean;
import com.hsq.service.CourseTypeService;

public class CourseTypeServiceImpl implements CourseTypeService {
private CourseTypeDao courseTypeDao;
public void setCourseTypeDao(CourseTypeDao courseTypeDao) {
	this.courseTypeDao = courseTypeDao;
}
	@Override
	public List<CrmCourseType> findAll() {
		return courseTypeDao.findAll();
	}
	@Override
	public List<CrmCourseType> findAll(CrmCourseType courseType) {
		StringBuilder stringBuilder = new StringBuilder();
		List<Object> params=new ArrayList<Object>();
		
		if (StringUtils.isNotBlank(courseType.getCourseName())) {
			stringBuilder.append(" and courseName like ?");
			params.add("%"+courseType.getCourseName()+"%");
		}
		if (StringUtils.isNotBlank(courseType.getRemark())) {
			stringBuilder.append(" and remark like ?");
			params.add("%"+courseType.getRemark()+"%");
		}
		if (StringUtils.isNotBlank(courseType.getTotalStart())) {
			stringBuilder.append(" and total >= ? ");
			params.add(Integer.parseInt(courseType.getTotalStart()));
		}
		if (StringUtils.isNotBlank(courseType.getTotalEnd())) {
			stringBuilder.append(" and total <= ? ");
			params.add(Integer.parseInt(courseType.getTotalEnd()));
		}
		
		if (StringUtils.isNotBlank(courseType.getCourseCostStart())) {
			stringBuilder.append(" and courseCost >= ?");
			params.add(Double.parseDouble(courseType.getCourseCostStart()));
		}
		
		if (StringUtils.isNotBlank(courseType.getCourseCostEnd())) {
			stringBuilder.append(" and courseCost <= ?");
			params.add(Double.parseDouble(courseType.getCourseCostEnd()));
		}
		String condition=stringBuilder.toString();
		Object[] array = params.toArray();
		return courseTypeDao.findAll(condition,array);
		
	}
	@Override
	public CrmCourseType findById(String courseTypeId) {
		return courseTypeDao.findById(courseTypeId);
	}
	@Override
	public void addOrEdit(CrmCourseType courseType) {
		courseTypeDao.saveOrUpdate(courseType);
	}
	@Override
	public PageBean<CrmCourseType> findAll(CrmCourseType courseType, int pageNum,
			int pageSize) {
		
		//1 条件查询
				//1.1 拼凑查询条件
				StringBuilder builder = new StringBuilder();
				//1.2 拼凑实际参数 , 可以重复，顺序 --> List
				List<Object> paramsList = new ArrayList<Object>();
				
				//2 过滤条件
				// 2.1 课程类别
				if(StringUtils.isNotBlank(courseType.getCourseName())){
					builder.append(" and courseName like ?");
					paramsList.add("%"+courseType.getCourseName()+"%");
				}
				// 2.2 课程简介
				if(StringUtils.isNotBlank(courseType.getRemark())){
					builder.append(" and remark like ?");
					paramsList.add("%"+courseType.getRemark()+"%");
				}
				// 2.3 总学时：
				if(StringUtils.isNotBlank(courseType.getTotalStart())){
					builder.append(" and total >= ?");
					paramsList.add(Integer.parseInt(courseType.getTotalStart()));
				}
				if(StringUtils.isNotBlank(courseType.getTotalEnd())){
					builder.append(" and total <= ?");
					paramsList.add(Integer.parseInt(courseType.getTotalEnd()));
				}
				// 2.4课程费用
				if(StringUtils.isNotBlank(courseType.getCourseCostStart())){
					builder.append(" and courseCost >= ?");
					paramsList.add(Double.parseDouble(courseType.getCourseCostStart()));
				}
				if(StringUtils.isNotBlank(courseType.getCourseCostEnd())){
					builder.append(" and courseCost <= ?");
					paramsList.add(Double.parseDouble(courseType.getCourseCostEnd()));
				}
				
				
				
				//3 使用
				// 条件 , 格式：" and ..? and ..."
				String condition = builder.toString();
				// 实际参数
				Object[] params = paramsList.toArray();
				
				////////////////////////////////////////////////////////////
				//2分页
				//2.1 总记录数
				int totalRecord = this.courseTypeDao.getTotalRecode(condition,params);
				
				
				//2.2 创建对象
				PageBean<CrmCourseType> pageBean = new PageBean<CrmCourseType>(pageNum, pageSize, totalRecord);
				//2.3 分页数据
				List<CrmCourseType> data = this.courseTypeDao.findAll(condition, params,pageBean.getStartIndex(),pageSize);
				pageBean.setData(data);
				return pageBean;
	}

}
