<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@include file="/common/taglib.jsp" %>
<c:forEach items="${datas}" var="data">
	<div data-opid="${data.id}" data-uid="${data.userId}" class="k_items animated bounceInLeft clearfix mt20">
	<div class="fl cont_user_img">
	    <img src="${basePath}/${data.headerPic}">
	</div>
	<div class="fl cont_comments">
	    <p>
		    <a href="javascript:void(0)" class="fl">Tanzhoucanyin 转载自  ${data.username}</a>&nbsp;&nbsp;${data.createTime}
	    	<c:if test="${data.userId==sessionUser}">
	    		<a href="javascript:void(0);" onclick="tzComment.del(this)" data-opid="${data.id}" class="fr del"><i class="iconfont icon-del"></i></a>
	    	</c:if>
	    </p>
	    <h3 class="mt20 essay_title">${data.title}</h3>
	    <p class="mt10 essay_cont">${data.content}</p>
	    <div class="mt10 clearfix">
	        <p class="fl fs12">
	        	<c:forTokens items="${data.tag}" delims="," var="tag">
		            <a href="javascript:void(0)" style="color:#c5c6c9;">#${tag}</a>
	        	</c:forTokens>
	         </p>   
	        <p class="fr fs12">
	            <a href="javascript:void(0)" class="Leave_btn"><i class="icon_tb Leave_tb"></i>0</a>
	            <a href="javascript:void(0)" class="Leave_btn"><i class="icon_tb forwarding_tb"></i>0</a>
	            <a href="javascript:void(0)" class="Leave_btn"><i class="icon_tb collection_tb"></i>0</a>
	         </p> 
	    </div>
	</div>
	</div>
</c:forEach>