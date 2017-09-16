package com.tz.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.json.JSONException;
import org.apache.struts2.json.JSONUtil;

import com.tz.dao.CityDao;

public class CityServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取传递过来的省份id
		String pid = request.getParameter("pid");
		//根据省份id查询城市
		List<HashMap<String, Object>> maps = new CityDao().findCitys(new Long(pid));
		//获取的浏览器的输出流
		PrintWriter out = response.getWriter();
		//将数据返回给浏览器
		try {
			out.print(JSONUtil.serialize(maps));//json
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		//ajax是一种无状态的异步请求---通过XMLHttpRequest发送的请求它是不会刷新浏览器---数据传输的通过out进行输出
		//有状态请求，数据将数据在作用域中的rquest,session,application#setAttribute(key,value)----都是通过el表达式或者标签去解析的
		//放在作用域中的数据是给el表达式或者标签去解析替换的
		//关闭和刷新
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
