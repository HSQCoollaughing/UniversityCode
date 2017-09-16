<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@include file="/common/taglib.jsp" %>
<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="Generator" content="EditPlus®">
<meta name="Author" content="">
<meta name="Keywords" content="">
<meta name="Description" content="">
<title>博客</title>
<%@include file="/common/common.jsp" %>
<script type="text/javascript" src="${basePath}/js/tz_index.js"></script>
</head>
<body>
<!-- 头部 -->
<%@include file="common/header.jsp" %>
<!-- 内容区 -->
<div class="content">
<div class="cont_cont clearfix">
    <div class="wth620 fl">
        <div class="clearfix">
            <div class="fl cont_user_img">
                <img src="../images/user_img1.jpg">
            </div>
            <div class="fl cont_comments">
                <p><input type="text" id="title" placeholder="请输入标题" autofocus="autofocus" maxlength="40"/></p>               
                <p><textarea id="content" placeholder="分享新鲜事...少于400." maxlength="400"></textarea></p>
                <ul class="import">
                    <li>
                        <a href="javascript:void(0)" id="sendCharacter"><span><i class="icon_tb text_tb"></i></span>
                        <em>文字</em></a>
                    </li>
                    <li>
                        <a href="javascript:void(0)" id="sendPicture"><span><i class="icon_tb photo_tb"></i></span>
                        <em>图片</em></a>
                    </li>
                    <li>
                        <a href="javascript:void(0)" id="sendVideo"><span><i class="icon_tb video_tb"></i></span>
                        <em>视频</em></a>
                    </li>
                    <li>
                        <a href="javascript:void(0)" id="sendLink"><span><i class="icon_tb link_tb"></i></span>
                        <em>连接</em></a>
                    </li>
                    <li>
                        <a href="javascript:void(0)" id="sendSource"><span><i class="icon_tb code_tb"></i></span>
                        <em>源代码</em></a>
                    </li>
                </ul>
            </div>
        </div>
        
        
        
        <div id="comemntbox"></div>
        <div id="loadingbox" style="display: none;text-align: center;padding: 40px 0;color:#fff;font-size:24px;">
        	<span class="l-1"></span>
			<span class="l-2"></span>
			<span class="l-3"></span>
			<span class="l-4"></span>
			<span class="l-5"></span>
			<span class="l-6"></span>
        </div>
        
     
        
        
       </div>  
    <div class="wth270 fr">
        <div style="margin-bottom:50px;">
             <p class="clearfix left_nav"><i class="icon_tb article_tb fl"></i><a href="javascript:void(0)" class="fl ml20 color_gray">文章</a><span class="fr color_gray1 notice_number1">9</span></p>
             <p class="clearfix left_nav"><i class="icon_tb fans_tb fl"></i><a href="javascript:void(0)" class="fl ml20 color_gray">粉丝</a><span class="fr color_gray1 notice_number1">12</span></p>
             <p class="clearfix left_nav"><i class="icon_tb notice_tb fl"></i><a href="javascript:void(0)" class="fl ml20 color_gray">通知</a><span class="fr notice_number">23</span></p>
             <p class="clearfix left_nav"><i class="icon_tb direct_tb fl"></i><a href="javascript:void(0)" class="fl ml20 color_gray">私信</a><span class="fr notice_number">21</span></p>
         </div>
         <div>
            <p class="color_gray">推荐关注</p>
            <div class="left_nav color_gray clearfix">
                <img src="../images/user_img03.jpg" class="fl ml20 mt10 user_img">
                <div class="fl ml20">
                    <p><a href="javascript:void(0)" class="color_gray">PACO-KONG-</a></p>
                   <p><a href="javascript:void(0)" class="color_gray1">学院推荐</a></p>
                </div>
                <a href="javascript:void(0)" class="fr mr20 mt15"><i class="icon_tb add_bt"></i></a>
            </div>
            <div class="left_nav color_gray clearfix">
                <img src="../images/user_img04.jpg" class="fl ml20 mt10 user_img">
                <div class="fl ml20">
                    <p><a href="javascript:void(0)" class="color_gray">kail-KONG-</a></p>
                   <p><a href="javascript:void(0)" class="color_gray1">学院推荐</a></p>
                </div>
                <a href="javascript:void(0)" class="fr mr20 mt15"><i class="icon_tb add_bt"></i></a>
            </div>
            <div class="left_nav color_gray clearfix">
                <img src="../images/user_img07.jpg" class="fl ml20 mt10 user_img">
                <div class="fl ml20">
                    <p><a href="javascript:void(0)" class="color_gray">silej-KONG-</a></p>
                   <p><a href="javascript:void(0)" class="color_gray1">学院推荐</a></p>
                </div>
                <a href="javascript:void(0)" class="fr mr20 mt15"><i class="icon_tb add_bt"></i></a>
            </div>
            <div class="left_nav color_gray clearfix">
                <img src="../images/user_img03.jpg" class="fl ml20 mt10 user_img">
                <div class="fl ml20">
                    <p><a href="javascript:void(0)" class="color_gray">dfgds-KONG-</a></p>
                   <p><a href="javascript:void(0)" class="color_gray1">学院推荐</a></p>
                </div>
                <a href="javascript:void(0)" class="fr mr20 mt15"><i class="icon_tb add_bt"></i></a>
            </div>
         </div>
    </div>
</div>
</div>
<!-- 底部 -->
<%@include file="common/footer.jsp" %>

<script id="commentTemplate">
/* <div class="clearfix mt20">
<div class="fl cont_user_img">
    <img src="{{headerPic}}">
</div>
<div class="fl cont_comments">
    <p><a href="javascript:void(0)">Tanzhoucanyin 转载自  {{username}}</a></p>
    <h3 class="mt20 essay_title">{{title}}</h3>
    <p class="mt10 essay_cont">{{content}}</p>
    <div class="mt10 clearfix">
        <p class="fl fs12">
            <a href="javascript:void(0)" style="color:#c5c6c9;">#Java</a>
            <a href="javascript:void(0)" style="background:#c5c6c9;" class="link_btn">#Javascript</a>
         </p>   
        <p class="fr fs12">
            <a href="javascript:void(0)" class="Leave_btn"><i class="icon_tb Leave_tb"></i>0</a>
            <a href="javascript:void(0)" class="Leave_btn"><i class="icon_tb forwarding_tb"></i>0</a>
            <a href="javascript:void(0)" class="Leave_btn"><i class="icon_tb collection_tb"></i>0</a>
         </p> 
    </div>
</div>
</div>*/</script>
</body>
</html>