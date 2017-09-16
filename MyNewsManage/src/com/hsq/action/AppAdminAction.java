package com.hsq.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.hsq.dto.Admin;
import com.hsq.services.AdminServices;

/**
 * Servlet implementation class AppAdminAction
 */
@WebServlet("/AppAdminAction")
public class AppAdminAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
  PrintWriter out=null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AppAdminAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		 response.setContentType("text/html; charset=UTF-8");

			String method = "login";
			out=response.getWriter();
			method = request.getParameter("method");
			if ("login".equals(method)) {
				dologin(request, response);
			} else if ("list".equals(method)) {
				dolist(request, response);
			}

			else if ("del".equals(method)) {
				dod(request, response);
			} else if ("modif".equals(method)) {
				domodif(request, response);
			} else if ("AddAdmin".equals(method)) {

				doAddAdmin(request, response);
			} else if ("realmodif".equals(method)) {
				dorealmodif(request, response);
			}

	}
	private void dorealmodif(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		AdminServices as = new AdminServices();
		Admin admin = new Admin();
		String name = request.getParameter("c");
		String password = request.getParameter("d");
String imagePath=request.getParameter("imgPath");
		admin.setLoginName(name);
		admin.setPassword(password);
		admin.setId(id);
		admin.setImagePath(imagePath);
		boolean flag = as.modifAdmin(admin);
		if (flag) {
			dolist(request, response);

		} else {

		}
	}

	private void doAddAdmin(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		Admin admin = new Admin();
		String name = request.getParameter("a");
		String password = request.getParameter("b");
		String imagePath=request.getParameter("imgPath");
		AdminServices as = new AdminServices();
		admin.setLoginName(name);
		admin.setPassword(password);
		admin.setImagePath(imagePath);
		boolean flag = as.AddAdmin(admin);
		if (flag && name != null && password != null) {

			dolist(request, response);
			
		} else {

			try {
				response.getWriter().print("锟斤拷锟斤拷锟斤拷");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void domodif(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));

		AdminServices as = new AdminServices();
		Admin admin = null;
		admin = as.getAdminByid(id);
		request.setAttribute("admin", admin);

		try {
			request.getRequestDispatcher("modifAdmin.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void dod(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int id = 0;
		if (request.getParameter("id") != null) {
			id = Integer.parseInt(request.getParameter("id"));

		}
		boolean falg;
		AdminServices as = new AdminServices();

		falg = as.deletebyID(id);
		if (falg) {

			dolist(request, response);

			// TODO Auto-generated catch block

		} else {

			try {
				response.getWriter().print("锟斤拷锟斤拷锟斤拷");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void dolist(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		AdminServices as = new AdminServices();
		ArrayList<Admin> list = new ArrayList<Admin>();
		list = as.allAdmininfo();
		Gson gson=new Gson();
	String str=	gson.toJson(list);
	out.print(str);
	//	request.setAttribute("adminlist", list);
		// list= as.allAdmininfo();
//		try {
//			request.getRequestDispatcher("/admin/list.jsp").forward(request, response);
//		} catch (ServletException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}

	private void dologin(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		Admin admin = new Admin();
		AdminServices as = new AdminServices();

		String u = request.getParameter("u");
		String p = request.getParameter("p");

		admin = as.login(u, p);
		 //使用request对象的getSession()获取session，如果session不存在则创建一个
		    //    HttpSession session = request.getSession();
		        //将数据存储到session中
	     //   session.setAttribute("admin", admin);
		//dolist(request, response);

		// response.setContentType(" charset=UTF-8");
Gson gson=new Gson();
String str=gson.toJson(admin);
out.print(str);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		response.setContentType("text/html; charset=UTF-8");
	}

}
