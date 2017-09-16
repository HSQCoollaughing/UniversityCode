package com.hsq.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import com.hsq.dto.User;
import com.hsq.services.UserServices;

public class UserServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
	//	PrintWriter out = response.getWriter();
		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
	//	PrintWriter out = response.getWriter();
		String method="login";
		method=request.getParameter("method");
		if ("login".equals(method)) {
			dologin(request,response);
			
		}else if ("kick".equals(method)) {
			dokick(request,response);
		}else if ("getMessage".equals(method)) {
			getMessage(request,response);
		}else if ("sendMessage".equals(method)) {
			dosendMessage(request,response);
		}else if ("exit".equals(method)) {
			doexit(request,response);
		}else if ("check".equals(method)) {
			docheck(request,response);
		}
	}

	

	private void docheck(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		// 从session中获得用户的信息
				User existUser = (User) request.getSession().getAttribute("existUser");
				// 判断session中的用户是否过期
				if(existUser == null){
					// 登录的信息已经过期了!
					try {
						response.getWriter().println("1");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else{
					// 登录的信息没有过期
					try {
						response.getWriter().println("2");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
	}

	private void doexit(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		session.invalidate();
		try {
			response.sendRedirect(request.getContextPath()+"/index.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String  dosendMessage(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		String from = request.getParameter("from"); // 发言人
		String face = request.getParameter("face"); // 表情
		String to = request.getParameter("to"); // 接收者
		String color = request.getParameter("color"); // 字体颜色
		String content = request.getParameter("content"); // 发言内容
	String sendTime=	new Date().toLocaleString();
	ServletContext servletContext = getServletContext();
	String  sourceMessage = (String) servletContext.getAttribute("message");
	sourceMessage += "<font color='blue'><strong>" + from
			+ "</strong></font><font color='#CC0000'>" + face
			+ "</font>对<font color='green'>[" + to + "]</font>说："
			+ "<font color='" + color + "'>" + content + "</font>（"
			+ sendTime + "）<br>";
	servletContext.setAttribute("message", sourceMessage);
	return getMessage(request, response);

	}

	public String getMessage(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		  String  message = (String) getServletContext().getAttribute("message");
		  try {
			  if (message!=null) {
				  response.getWriter().println(message);
			}
			 
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return message;
	}

	private void dokick(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		Map<User, HttpSession> userMap = (Map<User, HttpSession>) getServletContext().getAttribute("userMap");
		
		User user = new User();
		user.setId(id);
		HttpSession httpSession = userMap.get(user);
		httpSession.invalidate();
		try {
			response.sendRedirect(request.getContextPath()+"/main.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void dologin(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		try{
		UserServices userServices = new UserServices();
		User user = new User();
		
			BeanUtils.populate(user, request.getParameterMap());
			User muser = userServices.login(user);
			System.out.println(muser);
			if(muser==null){
				
				request.setAttribute("msg", "用户名或密码错误");
				
					request.getRequestDispatcher("index.jsp").forward(request, response);
				
			}else {
				System.out.println("...........");
				request.getSession().invalidate();//用户登录成功，将之前的Seesion销毁解决bug;
				System.out.println(".....,,,..");
				Map<User, HttpSession> userMap = (Map<User, HttpSession>) getServletContext().getAttribute("userMap");
				System.out.println(userMap.size());
				if(userMap.containsKey(user)){
					
					HttpSession httpSession = userMap.get(user);
					httpSession.invalidate();
				}
				
				// 使用监听器:HttpSessionBandingListener作用在JavaBean上的监听器.
				System.out.println("//////rety");
				request.getSession().setAttribute("existUser", muser);
				System.out.println("gedrgedsyrdyhrety");
				
				String sourceMessage="";
				ServletContext application = getServletContext();
				if(application.getAttribute("message")!=null){
					
				sourceMessage=	 application.getAttribute("message").toString();
					
				}
				sourceMessage += "系统公告：<font color='gray'>"
						+ user.getLoginName() + "走进了聊天室！</font><br>";
				System.out.println(sourceMessage);
				application.setAttribute("message", sourceMessage);
				
				response.sendRedirect(request.getContextPath()+"/main.jsp");
			}
			
			
		
		
	
	}catch (Exception e) {
		// TODO: handle exception
	}
	}
}

