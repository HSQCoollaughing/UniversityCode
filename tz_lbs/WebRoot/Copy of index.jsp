<%@page import="com.tz.dao.HotelDao"%>
<%@page import="com.tz.bean.Hotel"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
	<script type="text/javascript" src="js/tz_index.js"></script>
</head>
<body>
	<!--top start-->
	<div id="top">
		<div class="t_header">
			<div class="h_logo fl">
				<a href="#"><img src="images/logo.png" alt="潭州学院" width="136" height="35" /></a>
			 	<!-- 
			 	<input type="button" onclick="tzMap.change('北京')" value="切换北京"/>
				<input type="button" onclick="tzMap.change('上海')" value="切换上海"/>
				<span class="micon m1" data-icon="m1"></span>
				<span class="micon m2" data-icon="m2"></span>
				<span class="micon m3" data-icon="m3"></span>
				<span class="micon m4" data-icon="m4"></span>
				<span class="micon m5" data-icon="m5"></span>
				<span class="micon m6" data-icon="m6"></span>
				<span class="micon m7" data-icon="m7"></span>
				<span class="micon m8" data-icon="m8"></span>
				<span class="micon m9" data-icon="m9"></span>
				<span class="micon m10" data-icon="m10"></span>
				<input type="d" id="cicon" value="m1"/>
				<input type="" id="gw" /> -->
				
			</div>
				<div class="areabox fl">
					<div class="s_box">
						<span>省份：<select id="province" onchange="searchData(true,0,10)"></select></span>
						<span>关键词：<input type="text" id="keyword" placeholder="请输入酒店名称..." maxlength="20" class="cityinp c2"/></span>
						<span><input type="button" class="citybtn" value="搜索" onclick="searchData(true,0,10)"/></span>  
					</div>
				</div>
			<div class="h_desc" style="color:#fff;">潭州LBS移动电商系统</div>
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