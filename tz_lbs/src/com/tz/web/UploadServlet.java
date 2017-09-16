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

public class UploadServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<HashMap<String, Object>> datas = new TzFileUploadUtil().uploadFile(request);
		PrintWriter out = response.getWriter();
		if(datas!=null){
			try {
				out.print(JSONUtil.serialize(datas));
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
