package com.tz.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.json.JSONException;
import org.apache.struts2.json.JSONUtil;

import com.tz.bean.Hotel;
import com.tz.dao.HotelDao;

public class HotelDetailServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String hotelId = request.getParameter("hotelId");
		
		Hotel hotel = new HotelDao().getHotel(new Integer(hotelId));
		//获取的浏览器的输出流
		PrintWriter out = response.getWriter();
		if(hotel!=null){
			try {
				out.print(JSONUtil.serialize(hotel,null,null,true,true));
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
