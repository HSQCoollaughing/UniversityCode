<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!--r_location start-->
<div class="r_location">
	<i></i>
	<p class="fl" id="sliderbar">您当前所在位置：</p>
	<div class="fr" style="padding-right:12px;">
		<a href="${basePath}" style="color:green">点击前往地图首页</a>&nbsp;
		当前用户：${sessionUser.username} , ${sessionUser.telephone }
		<a href="${basePath}/logout.jsp" style="color:green">登出</a>
	</div>
</div>
<!--end r_location-->