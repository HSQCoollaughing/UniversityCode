<%@page import="com.tz.dao.HotelDao"%>
<%@page import="com.tz.bean.Hotel"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../common/taglib.jsp" %>
<!doctype html>
<html>
<head>
	<meta charset="utf-8"/>
	<title>潭州特训班 - LBS移动电商系统后台管理中心 - Arry老师</title>
	<meta name="keywords" content="关键词,关键词">
	<meta name="description" content="">
	<%@include file="../common/adminHeader.jsp" %>
	<script type="text/javascript" src="${basePath}/js/tz_pca.js"></script>
	<script type="text/javascript" src="${basePath}/js/tz_page.js"></script>
</head>
<body>

<!--
	 为什么要建立一个admin目录,其实为了方便登陆拦截
	 建立目录的目的就是为了做拦截时候统一处理
-->
	<div class="tz_content">
		<!--t_left start-->
		<%@include file="left.jsp" %><!-- 服务器路径包括 -->
		<!--t_left end-->
		
		<!--t_header start-->
		<div class="t_header none">
			
			<!--end h_nav-->

			<!--h_info start-->
			<div class="h_info">
				<div class="h_user">当前用户：Arry , 身份：系统管理员</div>
				<div class="h_out">
					<a href="#">
						<span>退出</span>
						<i></i>
					</a>
				</div>
			</div>
			<!--end h_info-->
		
		</div>
		<!--end t_header-->


		<!--t_right start-->
		<div class="t_right">

			<!--r_location start-->
			<%@include file="header.jsp" %><!-- 服务器路径包括 -->
			<!--end r_location-->
			

			<!--r_table start-->
			<div class="r_table">
				<div class="r_title">
					<i></i>
					<p>表格表单类</p>
				</div>

				<!--r_label start-->
				<div class="r_label">
					<ul>
						<li>
							<a href="${basePath}/admin/add.jsp">
								<i class="l_icon1"></i>
								<span>添加</span>
							</a>
						</li>
						<li>
							<a href="#">
								<i class="l_icon2"></i>
								<span>编辑</span>
							</a>
						</li>
						<li>
							城市:<select id="province" onchange="tzHotel.search()" style="padding: 6px;"></select>
						</li>
					</ul>
				</div>
				<!--end r_label-->

				<!--r_search start-->
				<div class="r_search">
					<input type="button" value="GO" onclick="tzHotel.search()" class="r_btn"/>
					<input type="text" placeholder="请输入酒店名称..." id="keyword" class="r_text"/>
				</div>
				<div class="clear"></div>
				<!--end r_search-->
				
				<!--r_table_list start-->
				<div class="r_table_list">
					<table class="t_tab">
						<thead>
							<tr>
								<th>ID</th>
								<th>名称</th>
								<th>等级</th>
								<th>城市</th>
								<th>状态</th>
								<th>创建时间</th>
								<th>经纬度</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody id="tbody">	
						</tbody>
					</table>
				</div>
				<!--end r_table_list-->
				<div class="page"></div>
				<div style="clear:both"></div>
			</div>
			<!--end r_table-->
		
		</div>
		<!--end t_right-->

	</div>
	
	
	<script type="text/javascript">
		var tzHotel = {
			search:function(){
				tzHotel.load(0,10,function(itemcount){
					tzHotel.initPage(itemcount);
				});
			},
			//模板技术查询分页===减少页面的拼接
			load:function(pno,psize,callback){
				var pid = $("#province").val();
				var keyword = $("#keyword").val();
				var params = {pid:pid,pageNo:pno,pageSize:psize,keyword:keyword};
				//第二种方式,load原理代码
				$.ajax({
					type:"post",
					data:params,
					url:basePath+"/admin/hotelTemplate.jsp",
					success:function(data){
						$("#tbody").html(data);
						if(callback){
							var itemcount = $("#tbody").find("tr:eq(0)").data("itemcount");
							callback(itemcount);
						}
					}
				});
			},
			initPage:function(itemcount){
				$(".page").tzPage(itemcount, {
					num_edge_entries : 1, //边缘页数
					num_display_entries :4, //主体页数
					num_edge_entries:4,
					current_page:0,
					items_per_page : 10, //每页显示X项
					prev_text : "前一页",
					next_text : "后一页",
					callback : function(pageNo,psize){
						tzHotel.load(pageNo *psize,psize);
					}
				});
			}
		};
		
		//初始化的时候
		tzHotel.load(0,10,function(itemcount){
			tzHotel.initPage(itemcount);
		});
		

		changeAddress({
			"店铺管理":"javascript:void(0);",
		});
	</script>
</body>
</html>