<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>注册</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="<c:url value='/css/login.css'/>">
	<script type="text/javascript" src="<c:url value='/jquery/jquery-1.5.1.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/jsps/js/user/login.js'/>"></script>
	<script src="<c:url value='/js/common.js'/>"></script>


  </head>
  
  <body>
	<div class="main">
	 
	  <div align="center">
	    
        <div class="login1">
	      <div class="login2">
            <div class="loginTopDiv">
              <span class="loginTop">会员注册</span>
              <span>
                <a href="<c:url value='/jsps/user/regist.jsp'/>" class="registBtn"></a>
              </span>
            </div>
            <div>
              <form target="_top" action="<c:url value='/UserServlet'/>" method="post" id="loginForm">
                <input type="hidden" name="method" value="UserRegist" />
                  <table>
                    <tr>
                      <td width="50"></td>
                      <td><label class="error" id="msg" >666</label></td>
                    </tr>
                    <tr>
                      <td width="50">用户名</td>
                      <td><input class="input" type="text" name="loginName" id="loginname"/></td>
                    </tr>
                    <tr>
                      <td height="20">&nbsp;</td>
                      <td><label id="loginnameError" class="error"></label></td>
                    </tr>
                    <tr>
                      <td>密　码</td>
                      <td><input class="input" type="password" name="password" id="loginpass" /></td>
                    </tr>
                    <tr>
                      <td height="20">&nbsp;</td>
                      <td><label id="loginpassError" class="error"></label></td>
                    </tr>
                  
                    <tr>
                      <td height="20px">&nbsp;</td>
                      <td><label id="verifyCodeError" class="error"></label></td>
                    </tr>
                    <tr>
                      <td>&nbsp;</td>
                      <td align="left">
                        <input type="image" id="submit" src="<c:url value='/images/login1.jpg'/>" class="loginBtn"/>
                      </td>
                    </tr>																				
                 </table>
              </form>
            </div>
          </div>
        </div>
      </div>
	</div>
  </body>
  <script type="text/javascript">
  
  $(function(){
 
  $("#loginname").blur(function(){
 flag= ajaxLoginName();
 
  
 
  
  });
 // alert("你好");
 
 $("#loginname").focus(function(){
 $("#msg").text("");
 
 });
 $("#loginForm").submit(function(){
 var flag;
 var q=$("#loginname").val();
 flag= ajaxLoginName();
 if(!flag){
 $("#msg").text("请换个登录名");
 return flag;
 }
 if(!q){
 $("#msg").text("用户名不能为空");
 return false;
 }
 if(!$("#loginpass").val()){
 $("#loginpassError").text("密码不能为空");
 return false;
 }
 return flag;
 
 });
	
});
  
  function ajaxLoginName(){
  var bol;
  var value=$("#loginname").val();
  $.ajax({
		url:"/MyBS/UserServlet",//要请求的servlet
		data:{method:"ajaxLoginName", loginName:value},//给服务器的参数
		type:"POST",
		dataType:"json",
		async:false,//是否异步请求，如果是异步，那么不会等服务器返回，我们这个函数就向下运行了。
		cache:false,
		success:function(result) {
			if(!result) {//如果校验失败
				$("#msg").text("用户名已被注册！");
				//alert("用户名已被注册！");
				
				bol=false;
			}else{
			bol=true;
			
			}
		}
	});
	return bol;
  
  }
  </script>
</html>
	