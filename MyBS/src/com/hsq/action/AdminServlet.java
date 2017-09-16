package com.hsq.action;



import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.itcast.servlet.BaseServlet;

import com.hsq.dto.Admin;
import com.hsq.service.AdminService;

public class AdminServlet extends BaseServlet {
AdminService adminservice=new AdminService();
public String Adminlogin(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
	String loginName=req.getParameter("loginName");
	String password=req.getParameter("password");
	Admin admin = adminservice.adminLogin(loginName, password);
	if (admin==null) {
		return "f:/admin/login.jsp";
		
	}
	
	HttpSession session = req.getSession();
	session.setAttribute("admin", admin);
			return "f:/admin/main.jsp";
	
}
}
