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
	<link rel="stylesheet" href="css/main.css"/>	
	<link rel="stylesheet" href="css/animate.css"/>	
	<script>var basePath  ="${basePath}";</script>
	<!--引入jQuery官方类库-->
	<script type="text/javascript" src="${basePath}/js/jquery-1.11.2.min.js"></script>
</head>
  <body>
	
	
	<a href="javascript:void(0);" onclick="tzLogin.login()">点击保存</a>
	<script type="text/javascript">
		
	
		var tzLogin = {
			login:function(){
				this.template();
				//给登录按钮绑定点击事件
				$("#login").find(".loginbtn").on("click",loginMain);
				function loginMain(){
					var username = $("#d_username").val();
					var password = $("#d_password").val();
					
					if(!username){
						alert("请输入用户名...");
						$("#d_username").focus();
						return false;
					}
					
					if(!password){
						alert("请输入密码...");
						$("#d_password").focus();
						return false;
					}
					
					var params = {username:username,password:password};
					var $btns = $(this);
					
					$.ajax({
						type:"post",
						url:basePath+"/login",
						data:params,
						beforeSend:function(){
							$btns.off("click").val("登录中...");
						},
						error:function(){
							$btns.on("click",loginMain).val("登录");
						},
						success:function(data){
							$btns.on("click",loginMain).val("登录");
							if(data=="success"){
								window.location.href = "http://www.baidu.com";
							}else{
								alert("登录失败...");
								$("#password").val("");
							}
						}
					});
			
				}
				
			},
			template:function(){
				$("body").append("<div id='login' >"+
				"		<h3 class='logo animated rotateIn'><img src='http://localhost/tz_lbs/images/logo.png'/></h3>	"+
				"		<div class='cntbox animated swing'>"+
				"			<p class='animated flipInY'><label for='username'>账号：<input type='text'  maxLength='60' autofocus='autofocus' autocomplete='off' placeholder='请输入账号...' id='d_username'/></label></p>"+
				"			<p class='animated rotateIn'><label for='password'>密码：<input type='password' maxLength='16' id='d_password' autocomplete='off' placeholder='请输入密码(6-16位)...'/></label></p>"+
				"			<p class='animated bounceInLeft'><input type='button' class='loginbtn'  value='登陆'/></p>"+
				"		</div>"+
				"	</div>"+
				"	<div class='tmui-box-overlay'></div>");
			}
				
		};
	
	
	</script>
  </body>
</html>
