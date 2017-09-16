<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>订单列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	
	<link href="/mcss/bootstrap/bootstrap.css" rel="stylesheet">
    <link href="/mcss/bootstrap/bootstrap-overrides.css" type="text/css" rel="stylesheet">

    <!-- global styles -->
    <link rel="stylesheet" type="text/css" href="/mcss/compiled/layout.css">
    <link rel="stylesheet" type="text/css" href="/mcss/compiled/elements.css">
    <link rel="stylesheet" type="text/css" href="/mcss/compiled/icons.css">

    <!-- libraries -->
    <link href="/mcss/lib/font-awesome.css" type="text/css" rel="stylesheet" />
    
    <!-- this page specific styles -->
    <link rel="stylesheet" href="/mcss/compiled/tables.css" type="text/css" media="screen" />

    <!-- open sans font -->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
	
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="<c:url value='/jsps/pager/pager.css'/>" />
    <script type="text/javascript" src="<c:url value='/jsps/pager/pager.js'/>"></script>
    <link rel="stylesheet" type="text/css" href="<c:url value='/admin/css/order/list.css'/>" />
    <link rel="stylesheet" type="text/css" href="<c:url value='/css/css.css'/>" />

  </head>
  
  <body>

<div class="divMain">
	<div class="title">
		<div style="margin-top:7px;">
			<span style="margin-left: 150px;margin-right: 280px;">商品信息</span>
			<span style="margin-left: 40px;margin-right: 100px;">金额</span>
			<span style="margin-left: 50px;margin-right: 53px;">订单状态</span>
			<span style="margin-left: 100px;">操作</span>
		</div>
	</div>
	<br/>
	<table align="center" border="0" width="100%" cellpadding="0" cellspacing="0">
<c:forEach items="${page.list }" var="order">	
	
		<tr class="tt">
			<td width="320px">订单号：<a  href="<c:url value='/OrderServlet?method=load&oid=${order.oid }'/>">${order.oid }</a></td>
			<td width="200px">下单时间：${order.ordertime }</td>
			<td width="178px">&nbsp;</td>
			<td width="205px">&nbsp;</td>
			<td>&nbsp;</td>
		</tr>	

		<tr style="padding-top: 10px; padding-bottom: 10px;">
			<td colspan="2">


  <c:forEach items="${order.orderItemList }" var="orderItem">
	    <img border="0" width="70" src="<c:url value='/${orderItem.book.image_b }'/>"/>
  </c:forEach>

			</td>
			<td style="padding-left: 0">
				<span class="price_t">&yen;${order.total }</span>
			</td>
			<td>
<c:choose>
	<c:when test="${order.status eq 1 }">(等待付款)</c:when>
	<c:when test="${order.status eq 2 }">(准备发货)</c:when>
	<c:when test="${order.status eq 3 }">(等待确认)</c:when>
	<c:when test="${order.status eq 4 }">(交易成功)</c:when>
	<c:when test="${order.status eq 5 }">(已取消)</c:when>
</c:choose>	
			</td>
						
			<td>
			<a href="<c:url value='/OrderServlet?method=load&oid=${order.oid }'/>">查看</a><br/>
<c:if test="${order.status eq 1 }">
				<a href="<c:url value='/OrderServlet?method=load&oid=${order.oid }&btn=cancel'/>">取消</a><br/>						
</c:if>
<c:if test="${order.status eq 2 }">
				<a href="<c:url value='/OrderServlet?method=load&oid=${order.oid }&btn=deliver'/>">发货</a><br/>
</c:if>			

			</td>
		</tr>
</c:forEach>

	</table>
	<br/>
	 <ul >
           
              
               
                    <li><a href="#">   当前第[${page.pagenum }] 页 </a></li>
                 
                    <li><a href="OrderServlet?method=findAll&pagenum=${page.pagenum-1 }">&#8249;</a></li>
                 
                <c:forEach  var="pageindex" begin="${page.startpage }" end="${page.endpage}"> 
                <li class="active"><a href="OrderServlet?method=findAll&pagenum=${pageindex }">${pageindex }</a></li>
               </c:forEach>
             
                 <li><a href="OrderServlet?method=findAll&pagenum=${page.pagenum+1 }">&#8250;</a></li>
     
               <li><a href="#">  共[${page.totalpage }] 页,总共${page.totalrecode }条记录</a></li>
                
                <input type="text"   style="width: 30px"  id="pagenum"/>
               <input   type="button"   value="查询"    onclick="Gowhich(document.getElementById('pagenum'))"/>
             
            </ul>
          
            <script type="text/javascript">
            
            function Gowhich(input){
         var pagenum=  input.value;
         alert(pagenum);
            window.location.href="OrderServlet?method=findAll&pagenum="+pagenum;
            
            }
            
            
            
            </script>
</div>
  </body>
</html>
