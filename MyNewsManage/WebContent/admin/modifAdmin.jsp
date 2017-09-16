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
<script type="text/javascript">
		function upload(){
			window.open ('<c:url value="/upload.jsp"/>','newwindow','height=100,width=400,top=0,left=0,toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no') ;
		}
	</script>
</head>
<body>
	
	<form method="post" action="AdminSrevlet">
 <input type="hidden"  name="method"   value="realmodif" ></input>
		<table border="1px" align="center" style="width: 300px">
			<caption>AdminInfomation</caption>
<tr>
				<td>ID</td>
				<td><input     readonly="readonly" type="text" 
			name="id"		value="${ admin.id}"></input></td>
			</tr>

			<tr>
				<td>username</td>
				<td><input  type="text" name="c"
					value="${admin.loginName}"></input></td>
			</tr>
			<tr>
				<td>password</td>
				<td><input type="text" name="d"
					value="${admin.password}"></input></td>
			</tr>
			<tr>
						    <td>
						          头像：
						    </td>
						    
						    <td>
						         <input type="hidden" name="imgPath" id="imgPath"/>
						         <c:if test="${     empty admin.imagePath }">
										<img id="photo" src="<c:url value="/upload/noimage.jpg"/>" height="120"/><br/>
										</c:if>
										<c:if test="${ admin.imagePath!=null }">
										
										<img id="photo" src='<c:url value="/upload/${admin.imagePath }"/>'height="120"/><br/>
										
										</c:if>
										<a href="#" onclick="upload();">上传图片</a>
						         
						    </td>
						</tr>
			<tr>

				<td><input type="submit" value="modif"> </input></td>

				
				
			</tr>

		</table>


	</form>





</body>
</html>