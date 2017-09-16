package com.hsq.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.hsq.dto.Admin;
import com.hsq.dto.News;
import com.hsq.services.AdminServices;
import com.hsq.services.NewsServices;

/**
 * Servlet implementation class NewsServlet
 */
@WebServlet("/admin/NewsServlet")
public class NewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PrintWriter out=null;
	Gson	gson; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html; charset=UTF-8");
		out=response.getWriter();
		String method = "listNews";
		method = request.getParameter("method");
		if ("listNews".equals(method)) {
			dolist(request, response);
		
		}
		else if ("delNews".equals(method)) {
			dod(request, response);
		} else if ("editNews".equals(method)) {
			doedit(request, response);
		} else if ("AddNews".equals(method)) {

			doAddNews(request, response);
		} else if ("modifNews".equals(method)) {
			domodif(request, response);
		}else if("showNews".equals(method)){
			
			doshowNews(request, response);
		}else if("findNews".equals(method)){
			
			dofindNews(request, response);
		}
		
	}

	private void dofindNews(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));

		NewsServices nsv=new NewsServices();
		News news = null;
		news = nsv.getNewsByid(id);
		request.setAttribute("newscontent", news);

		try {
			request.getRequestDispatcher("/admin/findNewscontent.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void doshowNews(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(request.getParameter("id"));
		NewsServices nsv=new NewsServices();
		News news=null;
	news=	nsv.getNewsByid(id);
		request.setAttribute("news", news);
		request.getRequestDispatcher("/page/showNews.jsp").forward(request, response);
	}

	private void dolist(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		NewsServices nsv=new NewsServices();
		ArrayList<News> list = new ArrayList<News>();
		list = nsv.allNewsinfo();
		request.setAttribute("Newslist", list);
		// list= as.allAdmininfo();
		try {
			request.getRequestDispatcher("/admin/listNews.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//			gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create(); 
//	String str=	gson.toJson(list, new TypeToken<List<News>>(){}.getType());
//	out.print(str);
		
	}

	private void dod(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int id = 0;
		if (request.getParameter("id") != null) {
			id = Integer.parseInt(request.getParameter("id"));

		}
		boolean falg;
		NewsServices nsv=new NewsServices();

		falg = nsv.deletebyID(id);
		if (falg) {

			dolist(request, response);

			// TODO Auto-generated catch block

		} else {

			try {
				response.getWriter().print("失败");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void doedit(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));

		NewsServices nsv=new NewsServices();
		News news = null;
		news = nsv.getNewsByid(id);
		request.setAttribute("newscontent", news);

		try {
			request.getRequestDispatcher("modifNews.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void doAddNews(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		News news = new News();
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String author = request.getParameter("author");
	//	String pdate=request.getParameter("date");
		
		NewsServices nsv=new NewsServices();
		news.setAuthor(author);
		news.setContent(content);
		news.setTitle(title);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date1 = new java.util.Date();
	String str=   sdf.format(date1);
		try {
			java.util.Date date = sdf.parse(str);  
	        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
	        //date.getTime()所返回的是一个long型的毫秒数    
	        //getTime()函数用于使用当地时间返回当前Date对象中的时间值。该时间值表示从1970年1月1日午夜开始，到当前Date对象时，所经过的毫秒数，以格林威治时间为准。
			//news.setDate(sqlDate);
			news.setSendTime(sqlDate);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		
		boolean flag = nsv.AddNews(news);
		if (flag ) {

			dolist(request, response);
//			String json=gson.toJson(flag);
//			out.print(json);
		} else {

		//	try {
			//	response.getWriter().print("锟斤拷锟斤拷锟斤拷");
		//	} catch (IOException e) {
				// TODO Auto-generated catch block
			//	e.printStackTrace();
		//	}
		}
		
	}

	private void domodif(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		NewsServices nsv=new NewsServices();
		News news = new News();
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String author = request.getParameter("author");
		//String pdate = request.getParameter("date");
		int count = Integer.parseInt(request.getParameter("count"));
	news.setAuthor(author);
	news.setContent(content);
	news.setCount(count);
	news.setId(id);
	news.setTitle(title);
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	java.util.Date date1 = new java.util.Date();
String str=   sdf.format(date1);

		java.util.Date date;
		try {
			date = sdf.parse(str);
			 java.sql.Date sqlDate = new java.sql.Date(date.getTime());
			 news.setSendTime(sqlDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
        //java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        //date.getTime()所返回的是一个long型的毫秒数    
        //getTime()函数用于使用当地时间返回当前Date对象中的时间值。该时间值表示从1970年1月1日午夜开始，到当前Date对象时，所经过的毫秒数，以格林威治时间为准。
		//news.setDate(sqlDate);
		boolean flag = nsv.modifNews(news);
		if (flag) {
			dolist(request, response);

		} else {

		}
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
