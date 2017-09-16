package com.tz.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tz.bean.User;
import com.tz.util.TzConstanst;

public class LoginServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	
	//我是分支以后的项目
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		IDaoFactory<User> userDao = ObjectFactory.getInstance(UserMybatisDao.class);
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username+"==="+password);
		//根据id执行删除
		User  user = new User();//根据账号和密码去查询是否存在当前用户，如果存在登陆成功
		if(user!=null){
			request.getSession().setAttribute(TzConstanst.SESSION_USER_ID, 2);
		}
		//输出
		out.print(user!=null?"success":"fail");
		out.flush();
		out.close();
	}
}
