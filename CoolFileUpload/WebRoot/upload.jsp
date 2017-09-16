<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>web uploader组件上传</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/webuploader.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery.min.js"></script>

<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/webuploader.js"></script>

<style type="text/css">
#dndArea {
	width: 200px;
	height: 100px;
	border-color: red;
	border-style: dashed;
}
</style>
</head>

<body>
	<div id="uploader">

		<div id="dndArea"></div>


		<div id="fileList"></div>
		<div id="filePicker">点击选择文件</div>
	</div>

	<script type="text/javascript">
   
   var fileMD5;
   
   
   WebUploader.Uploader.register({
   "before-send-file":"beforeSendFile",
   "before-send":"beforeSend",
   "after-send-file":"afterSendFile"
   
   
   
   
   
   
   },{
   
   
   
   beforeSendFile:function(file){
   var deferred=WebUploader.Deferred();
   (new WebUploader.Uploader()).md5File(file,0,5*1024*1024)
   .progress(function(percentage){
   
   $("#"+file.id).find("div.state").text("正在获取文件信息.....");
   
   })
   .then(function(val){
   fileMD5=val;
   $("#"+file.id).find("div.state").text("成功获取文件");
   deferred.resolve();
   });
   
   return deferred.promise();
   
   
   },
   
   
   
   
   
    beforeSend:function(block){
    var deferred=WebUploader.Deferred();
  // alert(fileMD5);
   $.ajax({
   type:'post',
   url:'${pageContext.request.contextPath }/UploadActionServlet?action=checkChunks',
   data:{
   //MD5标识
   fileMD5:fileMD5,
   //当前分块下标
   chunk:block.chunk,
   //分块大小，是否上传成功
   chunkSize:block.end-block.start
   
   },
   dataType:'json',
   success:function(response){
   
   if(response.ifExit){
  // alert(response.ifExit);
   //分块存在，跳过该分块
   deferred.reject();  
   }else{
   deferred.resolve();
   
   }
   
   }
   });
   
   //将其传到后台
   this.owner.options.formData.fileMD5=fileMD5;
 // deferred.resolve();
    return deferred.promise();
   },
   
   
   
   
   
   
   
   
   afterSendFile:function(){
   //通知后台合并所有分块
   $.ajax(
   
   {
   
   type:'post',
   url:'${pageContext.request.contextPath }/UploadActionServlet?action=mergeChunks',
   data:{fileMD5:fileMD5},
   success:function(response){
   
   
   
   }
   }
   
   
   
   );
   
   
   
   
   },
   
   
   });
   
   
   
   
   
   
   
   
   
   
   
var uploader=WebUploader.create({

	swf:"${pageContext.request.contextPath }/js/Uploader.swf",
	server:"${pageContext.request.contextPath }/UploadServlet",
	pick:"#filePicker",
	auto:true,
	dnd:"#dndArea",
	disableGlobalDnd:true,
	paste:"#uploader",
	chunked:true,
	chunkSize:5*1024*1024,
});
   
   uploader.on("fileQueued",function(file){
   $("#fileList").append("<div id="+file.id+"><img /><span>"+file.name+"</span><div><span class='percentage'>  </span></div><span class='state' ></span></div>");
   //制作缩略图
   uploader.makeThumb(file,function(error,src){
   
   if (error) {
   
   $("#"+file.id).find("img").replaceWith("无法预览");
	
}
  $("#"+file.id).find("img").attr("src",src);
  
  
   
   
   
   });
   
   });
   uploader.on("uploadProgress",function(file,percentage){
   $("#"+file.id).find("span.percentage").text(Math.round(percentage*100)+"%");
   
   
   });
   
   </script>
</body>
</html>
