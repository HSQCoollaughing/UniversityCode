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
<ul>
	   <li><a href="">Hello</a></li>
	   
	   
	    </ul>
	   <ul>
	     <li><a href="">NewsList</a></li>
	     <li><a href="admin/find.jsp">NewsSearch</a></li>
	   
	    </ul>
	    
	    <a href=<c:url value="admin/NewFile.jsp"  ></c:url>>后台登录</a><br>
	    <a   href=<c:url value="/moban.jsp"></c:url>>注册</a>
	
	
	 
	  
<table  border="1px"  align="center"  style="width: 300px">
<caption>AllInformation</caption>
<tr>
<td   style="width: 100px">ID </td>
<td   style="width: 100px">title </td>

<td   style="width: 100px">author </td>
<td   style="width: 100px">date </td>
<td   style="width: 100px">count </td>

</tr>
<c:import url="/FirstAction"></c:import>
<c:forEach  items="${ Newslist}"  var="d">
<tr>

<td>${ d.id}  </td>
<td><a href="FirstAction?method=showNews&id=${ d.id}" />${ d.title}  </td>

<td>${d.author} </td>

<td>${d.sendTime} </td>
<td>${d.count}  </td>

 
</tr>

</c:forEach>
</table>
</body>
</html>