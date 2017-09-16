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
</head>
<body>
	<!--top start-->
	<div id="top">
		<div class="t_header">
			<div class="h_logo fl">
				<a href="#"><img src="images/logo.png" alt="潭州学院" width="136" height="35" /></a>
			
				<input type="button" onclick="tzMap.change('北京')" value="切换北京"/>
				<input type="button" onclick="tzMap.change('上海')" value="切换上海"/>
<!-- 				<span class="micon m1" data-icon="m1"></span> -->
<!-- 				<span class="micon m2" data-icon="m2"></span> -->
<!-- 				<span class="micon m3" data-icon="m3"></span> -->
<!-- 				<span class="micon m4" data-icon="m4"></span> -->
<!-- 				<span class="micon m5" data-icon="m5"></span> -->
<!-- 				<span class="micon m6" data-icon="m6"></span> -->
<!-- 				<span class="micon m7" data-icon="m7"></span> -->
<!-- 				<span class="micon m8" data-icon="m8"></span> -->
<!-- 				<span class="micon m9" data-icon="m9"></span> -->
<!-- 				<span class="micon m10" data-icon="m10"></span> -->
<!-- 				<input type="d" id="cicon" value="m1"/> -->
<!-- 				<input type="" id="gw" /> -->
				
			</div>
			<style>
					.areabox{height:54px;margin-left:60px;}
					.areabox .s_box{height:36px;width:100%;margin-top:9px;line-height:36px;color:#fff}
					.cityinp{height:24px;width:72px;}
					.c2{width:142px;}
					.citybtn{height:28px;width:72px;background:#424347;border:0;color:#fff;outline:none;}
					.citybtn:hover{background:#000}
				</style>	
				<div class="areabox fl">
					<div class="s_box">
						<span>目的地：<input type="text" class="cityinp"/></span>
						<span>关键词：<input type="text" class="cityinp c2"/></span>
						<span><input type="button" class="citybtn" value="搜索" /></span>  
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
			<%
				List<Hotel> hotels = new HotelDao().findHotels(0, 10);
				pageContext.setAttribute("hotels",hotels);
			%>
			<ul id="k_diapulist">
				<c:forEach items="${hotels}" var="hotel">
					<li>
						<a href="javascript:void(0);" class="ke_dianpu"
						data-gd="${hotel.gd}" data-wd="${hotel.wd}" data-icon="${hotel.icon}"> <img
							src="${hotel.img}" alt="${hotel.name}" width="60" height="60"
							align="center">
						</a> <span>${hotel.name}</span>
					</li>
				</c:forEach>
			</ul>
		</div>
	</div>
	<!--end content-->
	<!--btn start-->
	<a href="#" id="btn">&gt;&gt;</a>
	<!--end btn-->
<script>
	// 商品列表收缩
	$(function(){
		var map = new AMap.Map('c_map_con', {
		    resizeEnable: true,
		    zoom:11,
		    center: [116.397428, 39.90923]
		});	
		//初始化,获取经纬度的初始化
		tzMap.init(map);
		$("#btn").click(function(){
			var text = $("#btn").text();
			if(">>" == text){
				$("#content .c_list").animate({right:"-285px"});
				$(this).animate({right:0}).html("&lt;&lt;");
			} else {
				$("#content .c_list").animate({right:0});
				$(this).animate({right:"285px"}).html("&gt;&gt;");				
			}
		});

		$(".micon").click(function(){
			var icon = $(this).data("icon");
			$("#cicon").val(icon);
		});
		
		function loadMarker(){
			$("#k_diapulist").children().each(function(){
				var $a = $(this).find("a");
				var gd = $a.data("gd");
				var wd = $a.data("wd");
				var icon = $a.data("icon");
				tzMap.marker(gd,wd,icon);
			});
			
			$("#k_diapulist").find(".ke_dianpu").click(function(){
				var gd = $(this).data("gd");
				var wd = $(this).data("wd");
				var icon = $(this).data("icon");
				tzMap.marker(gd,wd,icon,function(dialog,marker){
					dialog.open(this, marker.getPosition());
				});
			});
		};
		
		loadMarker();
	

		/*function loadDianPuData(){
			var jsonArr = [
				{id:1,gd:116.283102,wd:39.927399,icon:"m1",title:"语阁刺绣欧根纱公主111",desc:"语阁刺绣 欧根纱",img:"images/1.jpg"},
				{id:2,gd:116.460068,wd:40.033289,icon:"m2",title:"语阁刺绣欧根纱公主2222",desc:"语阁刺绣 欧根纱",img:"images/2.jpg"},
				{id:3,gd:116.521368,wd:39.823061,icon:"m3",title:"语阁刺绣欧根纱公主333",desc:"语阁刺绣 欧根纱",img:"images/3.jpg"}
			];

			var html = "";
			for(var i=0,len=jsonArr.length;i<len;i++){
				var data = jsonArr[i];
				html += "<li>"+
				"	<a href='javascript:void(0);' class='ke_dianpu' data-gd='"+data.gd+"'  data-wd='"+data.wd+"' data-icon='"+data.icon+"'>"+
				"		<img src='"+data.img+"' alt='"+data.title+"' width='60' height='60' align='center'/>"+
				"	</a>"+
				"	<span>"+data.title+"</span>"+
				"</li>";

				//数据加载的键店铺定位地图中
				tzMap.marker(data.gd,data.wd,data.icon);
			};
			
			$("#k_diapulist").html(html);


			$("#k_diapulist").find(".ke_dianpu").click(function(){
				var gd = $(this).data("gd");
				var wd = $(this).data("wd");
				var icon = $(this).data("icon");
				tzMap.marker(gd,wd,icon,function(dialog,marker){
					dialog.open(this, marker.getPosition());
				});
			});

		};

		loadDianPuData();*/

	});

</script>
</body>
</html>