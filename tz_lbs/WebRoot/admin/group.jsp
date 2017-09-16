<%@page import="org.apache.struts2.json.JSONUtil"%>
<%@page import="com.tz.util.TmStringUtils"%>
<%@page import="com.tz.dao.UserGroupDao"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String year = request.getParameter("year");
	if(TmStringUtils.isEmpty(year))year=new Date().getYear()+"";
	HashMap<String,Object> data = new  UserGroupDao().findGroupAge(Integer.parseInt(year));
	out.print(JSONUtil.serialize(data));
%>