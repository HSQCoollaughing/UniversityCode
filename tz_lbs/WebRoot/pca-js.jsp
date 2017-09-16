<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML >
<html>
  <head>
    <title>My JSP 'pca.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style>
		#box{width:800px;height:100px;margin:100px auto;}
		select{padding:10px 16px;}
	</style>
	<script type="text/javascript" src="js/jquery-1.11.2.min.js"></script>
	<script type="text/javascript" src="js/tz_pca.js"></script>
  </head>
  
  <body>
    
    	<div id="box">
    		省份：<select id="province">
    		</select>
    		城市：<select id="city">
    			<option value="">--请选择城市--</option>
    		</select>
    		区域：<select id="area">
    			<option value="">--请选择区域--</option>
    		</select>
    	</div>
    	
  </body>
</html>
7