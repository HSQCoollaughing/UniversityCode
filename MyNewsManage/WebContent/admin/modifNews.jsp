<%@page import="com.hsq.dto.News"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.hsq.services.AdminServices"%>
<%@page import="com.hsq.dto.Admin"%>
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
	
	<form method="post" action="NewsServlet">
 <input type="hidden"  name="method"   value="modifNews" ></input>
		<table border="1px" align="center" style="width: 300px">
			<caption>AdminInfomation</caption>
<tr>
				<td>ID</td>
				<td><input     readonly="readonly" type="text" 
			name="id"		value="${ newscontent.getId()}"></input></td>
			</tr>

			<tr>
				<td>标题</td>
				<td><input  type="text" name="title"
					value="${ newscontent.getTitle()}"></input></td>
			</tr>
			<tr>
				<td>内容</td>
				<td><input type="text" name="content"
					value="${ newscontent.getContent()}"></input></td>
			</tr>
			<tr>
				<td>作者</td>
				<td><input type="text" name="author"
					value="${ newscontent.getAuthor()}"></input></td>
			</tr>
			<tr>
				<td>时间</td>
				<td><input type="text" name="date"
					value="${ newscontent.getDate()}"></input></td>
			</tr>
			<tr>
				<td>次数</td>
				<td><input type="text" name="count"
					value="${ newscontent.getCount()}"></input></td>
			</tr>
			<tr>

				<td><input type="submit" value="modif"> </input></td>

				
				
			</tr>

		</table>


	</form>





</body>
</html>