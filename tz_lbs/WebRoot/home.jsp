<%@page import="com.tz.dao.HotelDao"%>
<%@page import="com.tz.bean.Hotel"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@include file="common/taglib.jsp" %>
<!doctype html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	<title>潭州特训班 - LBS移动电商系统 - Arry老师</title>
	<meta name="keywords" content="关键词,关键词">
	<meta name="description" content="">
	<%@include file="common/header.jsp" %>
	<script type="text/javascript" src="js/tz_pca.js"></script>
	<script type="text/javascript" src="js/tz_pay.js"></script>
	<script type="text/javascript" src="js/tz_index.js"></script>
</head>
<body>
	<!--top start-->
	<div id="top">
		<div class="t_header">
			<div class="h_logo fl">
				<a href="#"><img src="images/logo.png" alt="潭州学院" width="136" height="35" /></a>
			</div>
				<div class="areabox fl">
					<div class="s_box">
						<span>省份：<select id="province" onchange="searchData(true,0,10)"></select></span>
						<span>关键词：<input type="text" id="keyword" placeholder="请输入酒店名称..." maxlength="20" class="cityinp c2"/></span>
						<span><input type="button" class="citybtn" value="搜索" onclick="searchData(true,0,10)"/></span>  
					</div>
				</div>
			<div class="h_desc" style="color:#fff;">
				<c:if test="${empty sessionUser}">
					<a href="javascript:void(0);" onclick="tzLogin.login()" style="color:#fff">潭州LBS移动电商系统后台</a>
				</c:if>
				<c:if test="${not empty sessionUser}">
					<a href="${basePath}/admin" style="color:#fff">${sessionUser.username}---潭州LBS移动电商系统后台</a>
				</c:if>
			</div>
		</div>
	</div>
	<!--end top-->
	<!--content start-->
	<div id="content">
		<div class="c_map" id="c_map_con"></div>
		<div class="c_list">
			<ul id="k_diapulist"></ul>
		</div>
	</div>
	<!--end content-->
	<!--btn start-->
	<a href="#" id="btn">&gt;&gt;</a>
	<!--end btn-->
</body>
</html>