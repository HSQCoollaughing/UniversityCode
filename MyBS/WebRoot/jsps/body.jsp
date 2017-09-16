<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="">
     <script src="jquery/bxp/jquery.js"></script>
    <title>My JSP 'top.jsp' starting page</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='css/list.css'/>">
	<link rel="stylesheet" type="text/css" href="<c:url value='jsps/pager/pager.css'/>" />
	 <script type="text/javascript" src="<c:url value='jsps/pager/pager.js'/>"></script>
	<script type="text/javascript" src="<c:url value='jquery/jquery-1.5.1.js'/>"></script>
	<script type="text/javascript" src="<c:url value='jsps/js/book/list.js'/>"></script>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">

*{
			padding: 0px;
			margin: 0px;
		}
		.container{
			width: 900px;
			height: 300px;
			margin: 20px auto;
			overflow: hidden;
			position: relative;
		}
		.show{
			width: 2700px;
			height: 300px;
		}
		.left{
			position: absolute;
			top:0px;
			left:0px;
			width:100px;
			height:300px;
			background: #000;
			opacity:0.3;
			color:#fff;
			text-align: center;
			line-height: 300px;
			font-size: 50px;
			font-weight: bold;
			cursor: pointer;
		}

		.left:hover{
			opacity:0.7;
		}
		.right:hover{
			opacity:0.7;
		}

		.right{
			position: absolute;
			top:0px;
			right:0px;
			width:100px;
			height:300px;
			background: #000;
			opacity:0.3;
			color:#fff;
			text-align: center;
			line-height: 300px;
			font-size: 50px;
			font-weight: bold;
			cursor: pointer;
		}
		.show img{
			margin-left: 0px;
			display: inline-block;
			float: left;
		}

		.target{
			position: absolute;
			left: 50%;
			bottom: 10px;	
			margin-left: -48px;
		}

		.target em{
			width: 12px;
			height: 12px;
			border-radius: 50%;
			display: block;
			background-color: #ccc;
			float: left;	
			margin-left: 20px;
			cursor: pointer;
		}
		.on{
			background-color: red!important;
		}
</style>
  </head>
  
  <body>
   <div class="container">
		<div class="show">
			<img src="images/a.jpg">
			<img src="images/b.jpg">
			<img src="images/c.jpg">				
		</div>
		<div class="left">
			<	
		</div>
		<div class="right">
			>				
		</div>

		
		<div class="target">
			<em></em>
			<em></em>
			<em></em>
		</div>
	</div>
	<ul>
<c:forEach items="${bookList1 }" var="book">
  <li>
  <div class="inner">
    <a class="pic" href="<c:url value='BookServlet?method=Bookdesc&bid=${book.bid }'/>"><img src="<c:url value='/${book.image_b }'/>" border="0"/></a>
    <p class="price">
		<span class="price_n">&yen;${book.currPrice }</span>
		<span class="price_r">&yen;${book.price }</span>
		(<span class="price_s">${book.discount }折</span>)
	</p>
	<p><a id="bookname" title="${book.bname }" />">${book.bname }</a></p>
	<%-- url标签会自动对参数进行url编码 --%>
	
	<p><a href="${authorUrl }" name='P_zz' title='${book.author }'>${book.author }</a></p>
	<p class="publishing">
		<span>出 版 社：</span><a href="${pressUrl }">${book.press }</a>
	</p>
	<p class="publishing_time"><span>出版时间：</span>${book.publishtime }</p>
  </div>
  </li>
</c:forEach>







 




</ul>

<
  </body>
  <script>
// 给图片添加index属性
j=0;
$('.show img').each(function(){
	$(this).attr({'index':j});
	j++;
});


i=0;

//设置页面刚刷新时指示灯
$('.target em').first().addClass('on');

function ride(){
	sobj=setInterval(function(){
		if(i>2){
			i=0;
		}
		$('.show img[index='+i+']').animate({
			'margin-left':'-900px'
		},1000,function(){
			if(i==2){
				$('.target em').eq(0).addClass('on');
				$('.target em').not($('.target em').eq(0)).removeClass('on');
			}else{
				$('.target em').eq(i+1).addClass('on');
				$('.target em').not($('.target em').eq(i+1)).removeClass('on');
			}

			$(this).css({'margin-left':'0px'});
			$(this).appendTo($('.show'));
			i++;
		});
	},3000);
}

ride();


$('.right').click(function(){
	clearInterval(sobj);

	idx=$('.show img').first().attr('index');
	i=parseInt(idx)+1;
	$('.show img[index='+idx+']').animate({
		'margin-left':'-900px'
	},500,function(){
		$(this).css({'margin-left':'0px'});
		$(this).appendTo($('.show'));
		if(i>2){
			i=0;
		}
			$('.target em').eq(i).addClass('on');
			$('.target em').not($('.target em').eq(i)).removeClass('on');
	});

	ride();	
});

$('.left').click(function(){
	clearInterval(sobj);

	idx=$('.show img').first().attr('index');
	i=parseInt(idx)-1;

	if(i<0){
		i=2;
	}
	$('.target em').eq(i).addClass('on');
	$('.target em').not($('.target em').eq(i)).removeClass('on');
	$('.show img[index='+i+']').css({'margin-left':'-900px'}).prependTo($('.show'));
	$('.show img[index='+i+']').stop().animate({
		'margin-left':'0px'
	},500);
	ride();	
});

//指示灯点击事件
$('.target em').click(function(){
	x=$(this).index(); //获取指示灯序号
	// alert(x);
	$('.show img[index='+x+']').prependTo($('.show')); //将要显示的图追加到第一张	
	$('.target em').eq(x).addClass('on');
	$('.target em').not($('.target em').eq(x)).removeClass('on');

	arr=[];
	for(k=0;k<x;k++){
		arr[k]=k;
	}
	
	// document.title=arr;
	for(l=0;l<arr.length;l++){
		$('.show img[index='+l+']').appendTo($('.show'));//将数组中值对应的图追加到最后
	}
	i=x;
	clearInterval(sobj);

	ride();
});
</script>
</html>
