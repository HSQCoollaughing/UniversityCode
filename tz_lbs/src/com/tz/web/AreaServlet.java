package com.tz.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.json.JSONException;
import org.apache.struts2.json.JSONUtil;

import com.tz.dao.AreaDao;

public class AreaServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取传递过来的省份id
		String cid = request.getParameter("cid");
		//获取applicationContext对象
		ServletContext application =request.getSession().getServletContext();//javaEE5 JAVAEE6 request.getServletContext
		//在application作用域中去查找有没有区域的数据，
		List<HashMap<String, Object>> maps = (List<HashMap<String, Object>>) application.getAttribute("areas_"+cid);
		if(maps==null){
			maps = new AreaDao().findAreas(new Long(cid));
			application.setAttribute("areas_"+cid, maps);
		}
		//获取的浏览器的输出流
		PrintWriter out = response.getWriter();
		//将数据返回给浏览器
		try {
			out.print(JSONUtil.serialize(maps));
		} catch (JSONException e) {
			e.printStackTrace();
		}
		//关闭和刷新
		out.flush();
		out.close();
	}
}
