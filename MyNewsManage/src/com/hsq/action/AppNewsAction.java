package com.hsq.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hsq.dto.News;
import com.hsq.services.NewsServices;

/**
 * Servlet implementation class AppNewsAction
 */
@WebServlet("/admin/AppNewsAction")
public class AppNewsAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PrintWriter out=null; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AppNewsAction() {
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
		out=response.getWriter();
		String method = "UpdateCountByid";
		method = request.getParameter("method");
		if ("UpdateCountByid".equals(method)) {
			doUpdateCountByid(request, response);
		
		}else if ("delNews".equals(method)) {
				dod(request, response);
		}else if ("modifNews".equals(method)) {
			domodif(request, response);
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
			//dolist(request, response);

		} 
		
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

			//dolist(request, response);

			// TODO Auto-generated catch block

		} 
		
	}

	private void doUpdateCountByid(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
	int	id=Integer.parseInt(request.getParameter("id"));
	int count=Integer.parseInt(request.getParameter("count"));
	NewsServices ns=new NewsServices();
	ns.UpdateCountByid(id,count);
	
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
