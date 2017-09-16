<%@page import="com.hsq.dto.Admin"%>
<%@page import="com.hsq.services.AdminServices"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
	 <jsp:useBean id="now" class="java.util.Date" /> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">

.mytable{
position: relative;
top:350px;

}

body{
    background-image:url(../images/co.png) ;
    background-repeat:no-repeat;
    background-position:center top;
    background-color:#F7ECE8;
}
</style>
</head>
<body>






	<form method="get" action="NewsServlet">
	<input type="hidden" name="method" value="AddNews" >
		<table class="mytable"  width="55%" align="center" border="1">
		<caption>添加新闻</caption>
			<tr>
				<td>标题</td>
				<td><input type="text" name="title"></input></td>
			</tr>
			<tr>
				<td>内容</td>
				<td><textarea rows="5" cols="50" name="content"></textarea></td>
			</tr>
			<tr>
				<td>作者</td>
				<td><input type="text" name="author"></input></td>
			</tr>
			<tr>
				<td>时间</td>
				<td><input type="text" name="date"  value=<fmt:formatDate value="${now}" type="both" dateStyle="long" pattern="yyyy-MM-dd" />></input></td>
			</tr>
			<tr>
				<td>提交</td>
				<td><input type="submit" value="提交"></input></td>
			</tr>


		</table>



	</form>

</body>
</html>