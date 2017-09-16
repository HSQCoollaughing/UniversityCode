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
			<div class="r_location">
				<i></i>
				<p class="fl">您当前所在位置：后台 > 店铺管理</p>
				<div class="fr" style="padding-right:12px;">当前用户：Arry , 身份：系统管理员</div>
			</div>
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
							<a href="#">
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
							<a href="#">
								<i class="l_icon3"></i>
								<span>添加章节</span>
							</a>
						</li>
						<li>
							<a href="#">
								<i class="l_icon4"></i>
								<span>上传资料</span>
							</a>
						</li>
						<li>
							<a href="#">
								<i class="l_icon5"></i>
								<span>置顶</span>
							</a>
						</li>
						<li>
							<a href="#">
								<i class="l_icon6"></i>
								<span>取消置顶</span>
							</a>
						</li>

					</ul>
				</div>
				<!--end r_label-->

				<!--r_search start-->
				<div class="r_search">
					<input type="button" value="GO" onclick="tzHotel.search()" class="r_btn"/>
					<input type="text" id="keyword" class="r_text"/>
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
	

		/**
		 * 对Date的扩展，将 Date 转化为指定格式的String 月(M)、日(d)、12小时(h)、24小时(H)、分(m)、秒(s)、周(E)、季度(q)
		 * 可以用 1-2 个占位符 年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字) eg: (new
		 * Date()).format("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423 (new
		 * Date()).format("yyyy-MM-dd E HH:mm:ss") ==> 2009-03-10 二 20:09:04 (new
		 * Date()).format("yyyy-MM-dd EE hh:mm:ss") ==> 2009-03-10 周二 08:09:04 (new
		 * Date()).format("yyyy-MM-dd EEE hh:mm:ss") ==> 2009-03-10 星期二 08:09:04 (new
		 * Date()).format("yyyy-M-d h:m:s.S") ==> 2006-7-2 8:9:4.18
		 */
		Date.prototype.format = function(fmt) {
			var o = {
				"Y+" : this.getFullYear(),
				"M+" : this.getMonth() + 1,
				// 月份
				"d+" : this.getDate(),
				// 日
				"h+" : this.getHours() % 12 == 0 ? 12 : this.getHours() % 12,
				// 小时
				"H+" : this.getHours(),
				// 小时
				"m+" : this.getMinutes(),
				// 分
				"s+" : this.getSeconds(),
				// 秒
				"q+" : Math.floor((this.getMonth() + 3) / 3),
				// 季度
				"S" : this.getMilliseconds()
			// 毫秒
			};
			var week = {
				"0" : "/u65e5",
				"1" : "/u4e00",
				"2" : "/u4e8c",
				"3" : "/u4e09",
				"4" : "/u56db",
				"5" : "/u4e94",
				"6" : "/u516d"
			};
			if (/(y+)/.test(fmt)) {
				fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "")
						.substr(4 - RegExp.$1.length));
			}
			if (/(E+)/.test(fmt)) {
				fmt = fmt
						.replace(
								RegExp.$1,
								((RegExp.$1.length > 1) ? (RegExp.$1.length > 2 ? "/u661f/u671f"
										: "/u5468")
										: "")
										+ week[this.getDay() + ""]);
			}
			for ( var k in o) {
				if (new RegExp("(" + k + ")").test(fmt)) {
					fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k])
							: (("00" + o[k]).substr(("" + o[k]).length)));
				}
			}
			return fmt;
		};
		
		function getStatusHtml(status){
			var html = "";
			if(status==1){
				html = "<a href='#' class='red'>发布</a>";
			}else{
				html = "<a href='#' class='green'>未发布</a>";
			}
			return html;
		}
		
		
		function getDateTime(time,format){
			time = time.replace("T"," ").replace(/-/g,"/");
			var date = new Date(time);
			return date.format(format);
		};
	
		var tzHotel = {
			load:function(){
				$.ajax({
					type:"post",
					url:basePath+"/admin/hotel",
					success:function(data){
						if(data){
// 							var jsonArr = eval("("+data+")");
							var jsonArr = JSON.parse(data);
							var html = "";
							jsonArr.forEach(function(obj){
								html +="<tr>"+
								"	<td>"+obj.id+"</td>"+
								"	<td>"+obj.name+"</td>"+
								"	<td>"+obj.level+"</td>"+
								"	<td>"+obj.pname+"</td>"+
								"	<td>"+getStatusHtml(obj.status)+"</td>"+
								"	<td>"+getDateTime(obj.createTime,'yyyy年MM月dd日  HH:mm:ss')+"</td>"+
								"	<td>"+obj.gd+"/"+obj.wd+"</td>"+
								"	<td class='t_td'>"+
								"		<div class='t_action'>"+
								"			<a href='javascript:void(0);' class='a_edit' title='编辑'></a>"+
								"			<a href='javascript:void(0);' class='a_del' title='删除'></a>"+
								"		</div>"+
								"	</td>"+
								"</tr>";
							});
							$("#tbody").html(html);
						}
					}
				});
			},
			search:function(){
				tzHotel.load2(0,10,function(itemcount){
					tzHotel.initPage(itemcount);
				});
			},
			//模板技术查询分页===减少页面的拼接
			load2:function(pno,psize,callback){
				var pid = "";
				var keyword = $("#keyword").val();
				var params = {pid:pid,pageNo:pno,pageSize:psize,keyword:keyword};
				//第一种方式
				//$("#tbody").load(basePath+"/admin/hotelTemplate.jsp",params);
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
						tzHotel.load2(pageNo *psize,psize);
					}
				});
			}
		};
		

		tzHotel.load2(0,10,function(itemcount){
			tzHotel.initPage(itemcount);
		});
	</script>
</body>
</html>