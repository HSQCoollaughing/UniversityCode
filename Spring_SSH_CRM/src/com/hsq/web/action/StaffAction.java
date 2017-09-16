package com.hsq.web.action;

import java.util.List;

import com.hsq.base.BaseAction;
import com.hsq.bean.CrmDepartment;
import com.hsq.bean.CrmStaff;
import com.hsq.service.DepartmentService;
import com.hsq.service.StaffService;
import com.hsq.utils.MyStringUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class StaffAction extends BaseAction<CrmStaff> {

//	private CrmStaff staff =new CrmStaff();
//
//	@Override
//	public CrmStaff getModel() {
//		return staff ;
//	}
//	//Spring staffService按照名称自动注入
//	private StaffService staffService;
//	public void setStaffService(StaffService staffService) {
//		this.staffService = staffService;
//	}
	
//	private DepartmentService departmentService;
//	public void setDepartmentService(DepartmentService departmentService) {
//		this.departmentService = departmentService;
//	}
//	
	public String login(){
		String formloginPwd = this.getModel().getLoginPwd();
		String md5Value = MyStringUtils.getMD5Value(formloginPwd);
		this.getModel().setLoginPwd(md5Value);
		CrmStaff crmStaff = getStaffService().login(this.getModel());
		if (crmStaff!=null) {
			System.out.println("进入Action");
			ActionContext.getContext().getSession().put("loginStaff", getModel());
			return "success";
		}
		//不成功
		this.addFieldError("", "用户名与密码不匹配");
		return "login";
		
	}
public String home(){
	
	return "home";
}

public String findAll(){
	 List<CrmStaff> listCrmStaff=getStaffService().findAllStaff();
	 ActionContext.getContext().put("allStaff", listCrmStaff);
	return "findAll";
}


public String editUi(){
	CrmStaff crmStaff = getStaffService().findById(getModel().getStaffId());
	ActionContext.getContext().getValueStack().push(crmStaff);
	
	//找寻所有部门
	List<CrmDepartment> findAllcrCrmDepartments = getDepartmentService().findAll();
	ActionContext.getContext().getValueStack().set("allDepartment", findAllcrCrmDepartments);
	return "editUI";
}
public String edit(){
	getStaffService().updateStaff(getModel());
	return "edit";
}
}
