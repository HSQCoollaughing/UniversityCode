<%@page import="com.hsq.dto.Admin"%>
<%@page import="com.hsq.services.AdminServices"%>
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





	<form method="get" action="AdminSrevlet">
	<input type="hidden" name="method" value="AddAdmin" >
		<table  border="1px"  align="center"  style="width: 300px">
		<caption>添加管理员信息</caption>
			<tr>
				<td>登录名</td>
				<td><input type="text" name="a"></input></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input type="password" name="b"></input></td>
			</tr>
			<tr>
				
			</tr>
			<tr>
						    <td>
						          头像：
						    </td>
						    
						    <td>
						         <input type="hidden" name="imgPath" id="imgPath"/>
										<img id="photo" src="<c:url value="/upload/noimage.jpg"/>" height="120"/><br/>
										<a href="#" onclick="upload();">上传图片</a>
						         
						    </td>
						</tr>
			
			<tr>
				<td>提交</td>
				<td><input type="submit" value="提交"></input></td>
			</tr>


		</table>



	</form>

</body>
</html>