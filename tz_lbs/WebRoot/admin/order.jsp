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
	<script src="../js/echarts.js"></script>
	<script src="../js/tz_chart.js"></script>
</head>
<body>
<div class="tz_content">
	<%@include file="left.jsp" %><!-- 服务器路径包括 -->
	<!--t_right start-->
	<div class="t_right">
		<%@include file="header.jsp" %><!-- 服务器路径包括 -->
		
		<select onchange="changeMap(this.value)">
			<option value="line">曲线图</option>	
			<option value="pie">饼图</option>	
			<option value="bar">柱形图</option>	
		</select>
	    <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
	    <div id="main" style="width: 100%;height:400px;"></div>
		
	</div>
</div>
<script type="text/javascript">
	

//聚合查询
function changeMap(value){
	var year = 2016;
	$.ajax({//媒婆
		type:"post",
		url:"group.jsp",
		data:{year:year},
		success:function(data){
			var d = JSON.parse(data);
			var ct  = getTotal(d.count);
			var percents = getPerent(d.count);
			var json  = {//新郎
				type:value,
				name:"年龄分布曲线图",
				title:year+"年度平台年龄统计(总计"+ct+") ",
				xdata:d.text.split(","),
				data:d.count.split(",")
				//data:percents
			};
			tzChar.bar("main",json);
		}
	});
}

changeMap("line");
		
function getTotal(ctext){
	var nums = ctext.split(",");
	var total = 0;
	for(var i=0;i<nums.length;i++){
		total+=parseInt(nums[i]);
	}
	return total;
}

function getPerent(cnt){
	var total = getTotal(cnt);
	var nums = cnt.split(",");
	var percents = [];
	for(var i=0;i<nums.length;i++){
		percents[i] = (parseFloat(nums[i])/total)*100;
	}
	return percents;
}
</script>
</body>
</html>