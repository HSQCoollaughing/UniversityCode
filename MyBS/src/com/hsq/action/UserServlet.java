package com.hsq.action;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;

import com.hsq.dto.User;
import com.hsq.service.UserService;

public class UserServlet extends BaseServlet {

	UserService userservice = new UserService();

	public String Userlogin(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String loginName = request.getParameter("loginname");
		String password = request.getParameter("loginpass");

		User user = userservice.Userlogin(loginName, password);
		System.out.println(user);
		if (user == null) {
			return "r:/jsps/user/login.jsp";
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			String loginname = user.getLoginName();
			loginname = URLEncoder.encode(loginname, "utf-8");
			Cookie cookie = new Cookie("loginName", loginname);
			cookie.setMaxAge(60 * 60 * 24 * 10);// ����10��
			response.addCookie(cookie);
			return "f:/index.jsp";
		}

	}

	public String quit(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		req.getSession().invalidate();
		return "r:/jsps/user/login.jsp";

	}

	public String UserRegist(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		User user = new User();
		String loginName = req.getParameter("loginName");
		String password = req.getParameter("password");

		
		user.setLoginName(loginName);
		user.setPassword(password);
		user.setUid(CommonUtils.uuid());

		userservice.Userregist(user);
		req.setAttribute("msg", "注册成功");
		return "f:/jsps/msg.jsp";

	}

	public String ajaxLoginName(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("ajax执行了");
		String loginName = req.getParameter("loginName");

		boolean ajaxloginName = userservice.ajaxloginName(loginName);
		resp.getWriter().print(ajaxloginName);// 发给客户端
		return null;
		// TODO Auto-generated method stub

	}

}
