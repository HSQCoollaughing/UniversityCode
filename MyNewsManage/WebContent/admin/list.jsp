


<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
</head>
<body>
<c:if test="${empty  admin }">

<c:redirect  url="NewFile.jsp"  />

</c:if>
<h3><c:out value="welcom   ${    admin.loginName }"></c:out></h3>
<a  style="position: relative;  left: 1300px" href="NewFile.jsp" > 退出登录</a>
<hr />
	<ul>
	   <li><a href="">Hello</a></li>
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
	     <li><a href="AdminSrevlet?method=list">AdminList</a></li>
	     <li><a href="">AdminSearch</a></li>
	    </ul>
	    </li>
	</ul>


<input type="hidden" name="method" value="list">
<table  border="1px"  align="center"  style="width: 300px">
<caption>AllInformation</caption>

<tr>
<td   style="width: 100px">ID </td>
<td   style="width: 100px">loginName </td>
<td   style="width: 100px">password </td>
<td   style="width: 100px"  colspan="2"  align="center">caozuo </td>
</tr>
<c:forEach items="${ adminlist}"  var="admin">
<tr>

<td>${ admin.id}  </td>
<td>${admin.loginName}  </td>
<td>${admin.password} </td>
<td><a  href="AdminSrevlet?method=del&id=${admin.id } " >delete</a> </td>
<td><a  href="AdminSrevlet?method=modif&id=${admin.id  } " >update</a> </td>
</tr>

</c:forEach>
</table>

</body>
</html>