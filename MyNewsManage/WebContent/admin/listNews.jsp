<%@page import="com.hsq.dto.News"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<hr />
	<ul>
	   <li><a href="NewsServlet?method=listNews">Hello</a></li>
	    <li>
	    Newsmanage
	    <ul>
	    <li><a href="AddNews.jsp">AddNews</a></li>
	     <li><a href="NewsServlet?method=listNews">NewsList</a></li>
	     <li><a href="find.jsp">NewsSearch</a></li>
	    </ul>
	    </li>
	</ul>
	<ul>
	  <li>
	 Adminmanagement
	    <ul>
	    <li><a href="AddAdmin.jsp">AddAdmin</a></li>
	     <li><a href="AdminAction?method=list">AdminList</a></li>
	     <li><a href="">AdminSearch</a></li>
	    </ul>
	    </li>
	</ul>
<% request.getAttribute("listNews");
ArrayList<News> list;
list=(ArrayList<News> )request.getAttribute("Newslist");
%>
<table  border="1px"  align="center"  style="width: 300px">
<caption>AllInformation</caption>
<tr>
<td   style="width: 100px">ID </td>
<td   style="width: 100px">title </td>

<td   style="width: 100px">author </td>
<td   style="width: 100px">date </td>
<td   style="width: 100px">count </td>
<td   style="width: 100px"  colspan="2"  align="center">caozuo </td>
</tr>
<% for(int i=0;i<list.size(); i++){
	
	%>
<tr>

<td><%=list.get(i).getId() %> </td>
<td><a href="NewsServlet?method=showNews&id=<%=list.get(i).getId()  %>"  ><%=list.get(i).getTitle() %></a> </td>

<td><%=list.get(i).getAuthor()%> </td>
<td><%=list.get(i).getSendTime() %> </td>
<td><%=application.getAttribute("count")%> </td>
<td><a  href="NewsServlet?method=delNews&id=<%=list.get(i).getId()  %> " >delete</a> </td>
<td><a  href="NewsServlet?method=editNews&id=<%=list.get(i).getId()  %> " >update</a> </td>
</tr>

<%} %>
</table>
<% 
//判断application对象中有没有保存名为count的参数 
//如果没有，在application对象中新增一个名为count的参数 
if(application.getAttribute("count")==null){ 
application.setAttribute("count", new Integer(0)); 
} 
Integer count = (Integer)application.getAttribute("count"); 
//使用application对象读取count参数的值，再在原值基础上累加1 
application.setAttribute("count",new Integer(count.intValue()+1)); 
%> 
<h2> 
<!-- 输出累加后的count参数对应的值 --> 
欢迎您访问，本页面已经被访问过 <font color="#ff0000"><%=application.getAttribute("count") %></font>次。。。。 
</h2> 

</body>
</html>