<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	//登出
	request.getSession().invalidate();
	response.sendRedirect("/tz_lbs");
%>