package com.hsq.base;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import com.hsq.service.CourseTypeService;
import com.hsq.service.DepartmentService;
import com.hsq.service.PostService;
import com.hsq.service.StaffService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class BaseAction<T> extends ActionSupport implements ModelDriven<T> {
//通过反射	new
	private T  t;
	@Override
	public T getModel() {
		return t;
	}
	
	public BaseAction() {
	
	try {
		ParameterizedType parameterizedType=	(ParameterizedType) this.getClass().getGenericSuperclass();
		Class<T> clazz = (Class<T>) parameterizedType.getActualTypeArguments()[0];
		t=clazz.newInstance();
	} catch (Exception e ) {
		throw new RuntimeException(e);
	} 
	
	
	
	
	}
	
	private StaffService staffService;
	private PostService postService;
	private DepartmentService departmentService;
	private CourseTypeService courseTypeService;
	

	public StaffService getStaffService() {
		return staffService;
	}

	public void setStaffService(StaffService staffService) {
		this.staffService = staffService;
	}

	public PostService getPostService() {
		return postService;
	}

	public void setPostService(PostService postService) {
		this.postService = postService;
	}

	public DepartmentService getDepartmentService() {
		return departmentService;
	}

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	public CourseTypeService getCourseTypeService() {
		return courseTypeService;
	}

	public void setCourseTypeService(CourseTypeService courseTypeService) {
		this.courseTypeService = courseTypeService;
	}
	
	private int pageNum = 1;
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	private int pageSize = 2;  //固定值
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	
	//简化值栈操作
	public void push(Object o){
		
		ActionContext.getContext().getValueStack().push(o);
	}
	
	public void set(String key, Object value){
		
		ActionContext.getContext().getValueStack().set(key, value);
		
	}
	
	public void put(String key, Object value){
		
		ActionContext.getContext().put(key, value);
	}
	public void putSession(String key, Object value){
		ActionContext.getContext().getSession().put(key, value);
		
	}
	public void putApplication(String key, Object value){
		ActionContext.getContext().getApplication().put(key, value);
		
	}
}
