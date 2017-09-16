<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="css/style.css" rel="stylesheet" >
	<script type="text/javascript">
	function check(){
		if(document.getElementById("form1").username.value==""){
			alert("请输入用户名！");
			document.getElementById("form1").username.focus();
			return false;
		}
		
		if(document.getElementById("form1").password.value==""){
			alert("请输入密码名！");
			document.getElementById("form1").password.focus();
			return false;
		}
	}
</script>
  </head>
  
  <body>
   <br>
	<center><h3 style="color:red;">${ msg }</h3></center>
	<form id="form1" name="form1" method="post" action="${pageContext.request.contextPath }/UserServlet" onSubmit="return check()">
		<input type="hidden" name="method" value="login">
		<table width="371" height="230" border="0" align="center" cellpadding="0" cellspacing="0" background="images/login.jpg">
			<tr>
				<td height="120" colspan="3" class="word_dark">&nbsp;</td>
			</tr>
			<tr>
				<td width="53" align="center" valign="top" class="word_dark">&nbsp;</td>
				<td width="216" align="center" valign="top" class="word_dark">
				<table width="100%" height="100%">
						<tr>
							<td>用户名：</td>
							<td><input type="text" name="loginName" class="login"></td>
						</tr>
					</table>
				</td>
				<td width="94" valign="top" class="word_dark"></td>
			</tr>
			
			<tr>
				<td width="53" align="center" valign="top" class="word_dark">&nbsp;</td>
				<td width="216" align="center" valign="top" class="word_dark">
					<table width="100%" height="100%">
						<tr>
							<td>密&nbsp;&nbsp;码：</td>
							<td><input type="password" name="password" class="login"></td>
						</tr>
					</table>
				</td>
				<td width="94" valign="top" class="word_dark"></td>
			</tr>
			<tr>
				<td width="53" align="center" valign="top" class="word_dark">&nbsp;</td>
				<td width="216" align="center" valign="top" class="word_dark">
				<input name="Submit" type="submit" class="btn_bg" value="进 入">
				</td>
				<td width="94" valign="top" class="word_dark">
				</td>
			</tr>
			

		</table>
	</form>
  </body>
</html>
