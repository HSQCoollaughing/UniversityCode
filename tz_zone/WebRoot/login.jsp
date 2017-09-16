<%@page import="com.tz.util.TzConstanst"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@include file="/common/taglib.jsp" %>
<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="Generator" content="EditPlus®">
<meta name="Author" content="">
<meta name="Keywords" content="">
<meta name="Description" content="">
<title>博客</title>
<%@include file="/common/common.jsp" %>
</head>
<body>
<%
	Integer userId = (Integer)request.getSession().getAttribute(TzConstanst.SESSION_USER_ID);
	if(userId!=null){
		response.sendRedirect("/");
	}
%>
<!-- 头部 -->
<%@include file="common/header.jsp" %>
<!-- 内容区 -->
<div class="content">
	<h1>登陆</h1>
	<p>账号：<input type="text" id="username"></p>	
	<p>密码：<input type="password" id="password"></p>	
	<p><input type="button" onclick="tzLogin()" value="登陆"></p>
</div>

<script type="text/javascript">
	function tzLogin(){
		var username = $("#username").val();
		var password = $("#password").val();
		$.ajax({
			type:"post",
			data:{username:username,password:password},
			url:basePath+"/login",
			success:function(data){
				if(data=="success"){
					window.location.href = "/";
				}
			}
			
		});
		
	}
</script>
</body>
</html>