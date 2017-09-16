<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>按图名查询</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script src="<c:url value='/jquery/jquery-1.5.1.js'/>"></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
	body {
		margin-top: 5px;
		margin-bottom: 0px;
		margin-left:200px;
		color: #404040;
	}
	input {
		width: 300px;
		height: 30px;
		border-style:solid;
		margin:0px;
		border-color: #15B69A;
	}
	a {
		text-transform:none;
		text-decoration:none;
		border-width: 0px;
	} 
	a:hover {
		text-decoration:underline;
		border-width: 0px;
	}
	span {
		margin: 0px;
	}
</style>
  </head>
  
  <body>
    <form action="<c:url value='/BookServlet'/>" method="get" target="body" id="form1">
    	<input type="hidden" name="method" value="findByBname"/>
    	<input id="se" type="text" name="express"/>
    	<span>
    		<a onclick="validateForm()"><img align="top" border="0" src="../images/btn.bmp"/></a>
    		
    	</span>
    </form>
    
  </body>
  <script type="text/javascript">
  
 
  function validateForm(){
  
  var express= $("#se").val();
  alert(express);
  if (express.length<=0) {
  alert("请输入关键字");
	return;
}
$("#form1").submit();
  
  }
  </script>
</html>
