package com.hsq.web.action;

import org.apache.commons.lang3.StringUtils;

import com.hsq.bean.CrmCourseType;
import com.hsq.page.PageBean;
import com.hsq.service.CourseTypeService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CourseTypeAction extends ActionSupport implements ModelDriven<CrmCourseType> {
private CourseTypeService courseTypeService;

//分页数据
private int pageNum = 1;
public void setPageNum(int pageNum) {
	this.pageNum = pageNum;
}
private int pageSize = 2;  //固定值
public void setPageSize(int pageSize) {
	this.pageSize = pageSize;
}
public void setCourseTypeService(CourseTypeService courseTypeService) {
	this.courseTypeService = courseTypeService;
}
	private CrmCourseType courseType=new CrmCourseType();

	@Override
	public CrmCourseType getModel() {
		return courseType;
	}
	public String findAll(){
	//	List<CrmCourseType> allCourseTypes = courseTypeService.findAll();
		
		//List<CrmCourseType> allCourseTypes = courseTypeService.findAll(courseType);
		
		//ActionContext.getContext().put("allCourseTypes", allCourseTypes);
		/*1简单查询
		List<CrmCourseType> allCourseType = this.courseTypeService.findAll();
		// * 查询结果存在值栈 , jsp 通过“#key”获得
		ActionContext.getContext().put("allCourseType", allCourseType);
		*/
		
		/*2 条件查询
		List<CrmCourseType> allCourseType = this.courseTypeService.findAll(courseType);
		ActionContext.getContext().put("allCourseType", allCourseType);
		 */
		
		//3 分页 + 条件
		PageBean<CrmCourseType> pageBean = this.courseTypeService.findAll(courseType, pageNum, pageSize);
		ActionContext.getContext().put("pageBean", pageBean);
		
		return "findAll";
		
		
	}
  public String addOrEditUI(){
	  if (StringUtils.isNotBlank(this.courseType.getCourseTypeId())) {
		
		  CrmCourseType findCourseType = this.courseTypeService.findById(courseType.getCourseTypeId());
		  ActionContext.getContext().getValueStack().push(findCourseType);
	}
	  return "addOrEditUI";
	
  }
  
  public String addOrEdit(){
	  this.courseTypeService.addOrEdit(courseType);
	  return "addOrEdit";
  }
}
