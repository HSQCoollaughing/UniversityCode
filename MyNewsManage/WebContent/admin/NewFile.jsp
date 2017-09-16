<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>信息</title>
<link href="../css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="../js/jquery.js"></script>
<script src="../js/cloud.js" type="text/javascript"></script>

<script language="javascript">
	$(function(){
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
	$(window).resize(function(){  
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
    })  
});  
</script> 

</head>
<body style="background-color:#1c77ac; background-image:url(images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;" >
<!-- html 注释 -->
<%--  jsp注释--%>
 <div id="mainBody">
      <div id="cloud1" class="cloud"></div>
      <div id="cloud2" class="cloud"></div>
    </div>  


<div class="logintop">    
    <span>欢迎登录后台管理界面平台</span>    
    <ul>
    <li><a href="#">回首页</a></li>
    <li><a href="#">帮助</a></li>
    <li><a href="#">关于</a></li>
    </ul>    
    </div>
    
    <div class="loginbody">
    
    <span class="systemlogo"></span> 
       
    <div class="loginbox">
     <form method="post" action="AdminSrevlet" >  
        <input type="hidden"  name="method"   value="login" ></input>
    <ul>
    <li><input name="u" type="text" class="loginuser" value="ci" onclick="JavaScript:this.value=''"/></li>
    <li><input name="p" type="password" class="loginpwd" value="ci" onclick="JavaScript:this.value=''"/></li>
    <li><input name="sb" type="submit" class="loginbtn" value="登录"    /><label><input name="" type="checkbox" value="" checked="checked" />记住密码</label><label><a href="#">忘记密码？</a></label></li>
    </ul>
      </form>  
    
    </div>
    
    </div>
    
    
    
    <div class="loginbm">版权所有  2013  uimaker.com 仅供学习交流，勿用于任何商业用途</div>

     <!--     <h3>欢迎来到新闻管理系统</h3>  
        <hr>
     
        <form method="get" action="AdminSrevlet" >  
        <input type="hidden"  name="method"   value="login" ></input>
            <input value="ci"   type="text"   name="u"></input> 
             <br>
            <input  value="ci"  type="password"   name="p"></input>
              <br>
            <input align="left" type="submit" value="重置"  ></input>
  
            <button class="but" type="submit">登录</button>  
            
        </form>  
     

-->
</body>
</html>