package com.tz.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.json.JSONException;
import org.apache.struts2.json.JSONUtil;

import com.tz.bean.Hotel;
import com.tz.dao.HotelDao;
import com.tz.util.TmStringUtils;

public class HotelServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String pid = request.getParameter("pid");
		String pageNo = request.getParameter("pageNo");
		String pageSize = request.getParameter("pageSize");
		String keyword = request.getParameter("keyword");
		Integer pno = TmStringUtils.isEmpty(pageNo)?0:Integer.parseInt(pageNo);
		Integer psize = TmStringUtils.isEmpty(pageSize)?10:Integer.parseInt(pageSize);
		//查询酒店信息
		List<Hotel> hotels = new HotelDao().findHotels(TmStringUtils.isNotEmpty(pid)?new Integer(pid):null,keyword,pno, psize);
		//获取的浏览器的输出流
		PrintWriter out = response.getWriter();
		if(hotels!=null && hotels.size()>0){
			try {
				out.print(JSONUtil.serialize(hotels));
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}else{
			out.print("");
		}
		out.flush();
		out.close();
	}
}
