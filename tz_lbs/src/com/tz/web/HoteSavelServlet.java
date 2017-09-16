package com.tz.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tz.bean.Hotel;
import com.tz.dao.AdminHotelDao;
import com.tz.dao.HotelDao;
import com.tz.util.TmStringUtils;

public class HoteSavelServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name  =request.getParameter("name");
		String description  =request.getParameter("description");
		String address  =request.getParameter("address");
		String gwd  =request.getParameter("gwd");
		String img  =request.getParameter("img");
		String telephone  =request.getParameter("telephone");
		String icon  =request.getParameter("icon");
		String level  =request.getParameter("level");
		String cityId  =request.getParameter("cityId");
		String status  =request.getParameter("status");
		String[] gws = gwd.split(","); 
		
		Hotel hotel = new Hotel();
		hotel.setName(name);
		hotel.setLevel(TmStringUtils.isEmpty(level)?0:new Float(level));
		hotel.setDescription(description);
		hotel.setGd(gws[0]);
		hotel.setWd(gws[1]);
		hotel.setAddress(address);
		hotel.setImg(img);
		hotel.setTelephone(telephone);
		hotel.setCityId(Integer.parseInt(cityId));//new Integer(cityId)
		hotel.setIsDelete(0);
		hotel.setStatus(Integer.parseInt(status));
		hotel.setUserId(1);
		hotel.setIcon(icon);
		boolean flag = new AdminHotelDao().saveHotal(hotel);
		//获取的浏览器的输出流
		PrintWriter out = response.getWriter();
		out.print(flag?"success":"fail");
		out.flush();
		out.close();
	}
}
