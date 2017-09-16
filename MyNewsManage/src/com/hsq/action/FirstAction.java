package com.hsq.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hsq.dto.Admin;
import com.hsq.dto.News;
import com.hsq.services.AdminServices;
import com.hsq.services.NewsServices;

/**
 * Servlet implementation class FirstAction
 */
@WebServlet("/FirstAction")
public class FirstAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		dolist(request, response);
			
			String method="showNews";
			method=request.getParameter("method");
			if("showNews".equals(method)){
				
				doshowNews(request, response);
			}
			
		
	}

	private void dolist(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		NewsServices nsv=new NewsServices();
		ArrayList<News> list = new ArrayList<News>();
		list = nsv.allNewsinfo();
		request.setAttribute("Newslist", list);
		// list= as.allAdmininfo();
		
	}

	private void doshowNews(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(request.getParameter("id"));
		NewsServices nsv=new NewsServices();
		News news=null;
	news=	nsv.getNewsByid(id);
		request.setAttribute("news", news);
		try {
			request.getRequestDispatcher("/page/showNews.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
