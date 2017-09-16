package com.tz.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tz.bean.User;
import com.tz.dao.UserDao;
import com.tz.util.TmStringUtils;
import com.tz.util.TzConstanst;

public class LoginServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取的浏览器的输出流
		PrintWriter out = response.getWriter();
		//获取传递过来的省份id
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if(TmStringUtils.isEmpty(username)){
			out.print("account_null");
			return;
		}
		if(TmStringUtils.isEmpty(password)){
			out.print("pwd_null");
			return;
		}
		String slatPwd = TmStringUtils.md5Base64("keke_"+password);
		User user = new UserDao().getUser(username,slatPwd);
		if(user!=null){
			user.setPassword(null);
			request.getSession().setAttribute(TzConstanst.SESSION_USER_ID, user);
			out.print("success");
		}else{
			out.print("error");//帐号或者密码错误
		}
		out.flush();
		out.close();
	}
	
	
	/*
	 * 开发流程:
	 * 1:新建一个对象dao,定义curd操作
	 * 2:进行测试
	 * 3:进行servlet/jsp的对接
	 * 4:返回
	 * 5：解析
	 * 
	 * */
}
