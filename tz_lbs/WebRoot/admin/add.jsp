<%@page import="com.tz.dao.AdminHotelDao"%>
<%@page import="com.tz.util.TmStringUtils"%>
<%@page import="com.tz.dao.HotelDao"%>
<%@page import="com.tz.bean.Hotel"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../common/taglib.jsp" %>
<!doctype html>
<html>
<head>
	<meta charset="utf-8"/>
	<title>潭州特训班 - LBS移动电商系统后台管理中心 - Arry老师</title>
	<meta name="keywords" content="关键词,关键词">
	<meta name="description" content="">
	<%@include file="../common/adminHeader.jsp" %>
	<script type="text/javascript" src="${basePath}/js/tz_pca.js"></script>
	<script type="text/javascript" src="${basePath}/js/tz_page.js"></script>
	<style>
		.keui-tips{height:58px;background:red;position:fixed;z-index:888;width:100%;text-align:center;line-height: 58px;color:#fff;font-size:14px;top:0;left:0}
		.keui-tips.keui-success{background:green}
		.keui-tips.keui-error{background:red}
		.keui-tips.keui-tip{background:orange}
		.keui-tips i{padding-right:6px;font-size:18px}
	</style>
</head>
<body>
	<%
		String id = request.getParameter("id");
		if(TmStringUtils.isNotEmpty(id)){
			Hotel hotel = new AdminHotelDao().getHotel(Integer.parseInt(id));
			pageContext.setAttribute("hotel", hotel);
		}
	%>
<!--
	 为什么要建立一个admin目录,其实为了方便登陆拦截
	 建立目录的目的就是为了做拦截时候统一处理
-->

	<div class="tz_content">
		<!--t_left start-->
		<%@include file="left.jsp" %><!-- 服务器路径包括 -->
		<!--t_left end-->
		<!--end t_header-->
		<!--t_right start-->
		<div class="t_right">
			<!--r_location start-->
			<%@include file="header.jsp" %><!-- 服务器路径包括 -->
			<!--end r_location-->
			<!--
		    	作者：xuchengfeifei@163.com
		    	时间：2016-02-27
		    	描述：div.container>ul>li*10>p>label[for='']{文本$：}>input[name='c$']
		    -->
			<div class="container" style="width:640px;">
				<form action="#" id="shopForm">
					<input type="hidden" id="id" name="id" value="${hotel.id}"/>
					<ul>
						<li>
							<p><label for="">城市：<select onchange="tzShop.changeMap(this)" data-opid="${hotel.cityId}" name="cityId" id="province"></select></label></p>
							<script type="text/javascript">
// 								$(function(){
// 									$("#province").find("option[value='${hotel.cityId}']").attr("selected","selected");
// 								});
							</script>
						</li>
						<li>
							<p><label for="">店铺的名称：<input type="text" class="inp" value="${hotel.name}" name="name" autocomplete="off" name="name" autocomplete="off" placeholder="请输入店铺的名称..."  maxlength="100" autofocus="autofocus" /></label></p>
						</li>
						<li>
							<p class="pr">
								<label for="">封面图片：<input type="text" class="inp" id="img" name="img" value="${hotel.img}"  autocomplete="off" placeholder="请上传封面图片..." readonly="readonly"/></label>
								<span><img src="${basePath}/${hotel.img}" id="preview" width="640" height="240"/></span>
								<a href="javascript:void(0);" onclick="openBrowse(this)" class="inp-upload">上传图片</a>
								<input type="file" id="file"  name="file" onchange="uploadFile(this)" style="display:none"/> 
							</p>
						</li>
						<li>
							<p><label for="">等级：
								<select name="level">
									<c:forEach var="num" begin="1" end="5">
										<option value="${num}" ${num==hotel.level?"selected='selected'":""}>${num}星级</option>
									</c:forEach>
								</select>
							</label></p>
						</li>
						<li>
							<p><label for="">图标：
								<select name="icon" id="icon">
									<c:forEach var="num" begin="1" end="9">
										<option value="m${num}" ${num==1?"selected='selected'":""}>m${num}</option>
									</c:forEach>
								</select>
								<script type="text/javascript">
								$(function(){
									$("#icon").find("option[value='${hotel.icon}']").attr("selected","selected");
								});</script>
							</label></p>
						</li>
						<li>
							<p class="pr">
								<label for="">经纬度：<input type="text" class="inp" id="gwd" name="gwd" value="${hotel.gd},${hotel.wd}" autocomplete="off" placeholder="请选择地图上的经纬度"  readonly="readonly"/></label>
								<a href="javascript:void(0);" class="inp-upload">获取经纬度</a>
							</p>
							<div id="tzmap" style="height:400px;background:red;margin-top:2px"></div>
						</li>
						<li>
							<p><label for="">地址：<input type="text" class="inp" name="address" autocomplete="off" value="${hotel.address}" placeholder="请输入店铺的详细地址.."  maxlength="200" /></label></p>
						</li>
						<li>
							<p><label for="">电话号码：<input type="text" class="inp" name="telephone" value="${hotel.telephone}" autocomplete="off" placeholder="请输入店铺的电话号码..."  maxlength="11" /></label></p>
						</li>
						<li>
							<p>
								<label for="">发布状态：
									<label><input type="radio" ${empty hotel.status || hotel.status==1?'checked="checked"':""} name="status" value="1"/>发布</label>&nbsp;&nbsp;&nbsp;&nbsp;
									<label><input type="radio" ${hotel.status==0?'checked="checked"':""} name="status" value="0"/>未发布</label>
								</label>
							</p>
						</li>
						<li>
							<p><label for="">店铺描述：<textarea  class="inp" name="description" autocomplete="off" placeholder="请输入店铺的名称..."  maxlength="1000" />${hotel.description}</textarea></label></p>
						</li>
						<li>
							<p><input type="button"  onclick="tzShop.save(this)" class="inp" value="保存"/></p>
						</li>
					</ul>
				</form>
			</div>
		</div>
		<!--end t_right-->
	</div>
	
	<script type="text/javascript">
		var tzShop = {
			slider:function(){
				changeAddress({
					"店铺首页 > ":"${basePath}/admin/dianpu.jsp",
					"店铺添加页面":"javascript:void(0);",
				});
			},
			save:function(){
				var mark = this.validator();
				if(mark){
					var params = $("#shopForm").serialize();
					var url = basePath+"/hotelSave";
					var id = $("#id").val();
					if(id)url = basePath+"/hotelUpdate";
					$.ajax({
						type:"post",
						url:url,
						data:params,
						success:function(data){
							if(data=="success"){
								window.location.href =window.location.href;
	// 							window.location.href =basePath+"/admin/dianpu.jsp";			
							}else{
								alert("添加失败....");
							}
						}
					});
				}
			},
			validator:function(){
				var json = deserialize($("#shopForm"));
				if(isEmpty(json.cityId[0])){
					json.cityId[1].css("border","1px solid red");
					tzCommon.message("请输入店铺对应的城市","error");
					return false;
				}
				if(isEmpty(json.name[0])){
					json.name[1].focus();
					json.name[1].css("border","1px solid red");
					tzCommon.message("请输入店铺名称","error");
					return false;
				}
				//此处省略其他验证....
				return false;
			},
			initMap:function(){
				var map = new AMap.Map("tzmap", {
				    resizeEnable: true,
				    zoom:11,
				    center: [116.397428, 39.90923]
				});	
				
				map.on('click', function(e) {
					var icon = $("#icon").val();
					$(".micon").remove();
					tzShop.marker(map,e.lnglat.getLng(),e.lnglat.getLat(),icon);
					$("#gwd").val(e.lnglat.getLng()+","+e.lnglat.getLat());
				});
				
				$("#province").change(function(){
					map.setCity($(this).find("option:selected").text());
				});
			},
			marker:function(map,gd,wd,icon){
				var thisMap = map;
				 new AMap.Marker({ //添加自定义点标记
					map: thisMap,
					position: [gd, wd], //基点位置
					offset: new AMap.Pixel(-17, -52), //相对于基点的偏移位置
					draggable: false,  //是否可拖动
					content: '<span class="mp micon '+icon+'"></span>'   //自定义点标记覆盖物内容
				});
			}
			
		};
		
		
		tzShop.slider();
		tzShop.initMap();
		tzFormBlur("shopForm");
		
		function tzFormBlur(formId){
			var formElements = document.getElementById(formId).elements;
			var len = formElements.length;
			var arr = ["submit","button","reset","hidden","file"];
			for(var i=0;i<len;i++){
				if(arr.indexOf(formElements[i].type.toLowerCase())==-1){
					formElements[i].onchange = function(){
						if(isNotEmpty(this.value)){
							this.style.border = "1px solid #ccc";
						}
					};	
				};
			}
		}
		
		
		
		
		
		/*点击按钮的时候--伪装文件上传*/
		function openBrowse(obj){ 
			//判断浏览器的兼容性问题
			var ie=navigator.appName=="Microsoft Internet Explorer" ? true : false; 
			if(ie){ //如果是ie浏览器
				document.getElementById("file").click(); 
				document.getElementById("filename").value=document.getElementById("file").value;
			}else{
				var a=document.createEvent("MouseEvents");//FF的处理 
				a.initEvent("click", true, true);  
				document.getElementById("file").dispatchEvent(a); 
			} 
		} 
		
		function uploadFile() {
			//获取文件上传的js列表对象
		    var fileObj = document.getElementById("file").files[0]; // js 获取文件对象
// 		    alert(fileObj.type);
// 		    alert(fileObj.name);
// 		    alert(fileObj.size);
		    //创建一个FormData 对象
		    var form = new FormData();
		    //设置文件上传的文件对象
		    form.append("doc", fileObj);                           
		    // 创建一个ajax对象
		    var xhr = new XMLHttpRequest();
		    //开始和后台的upload.jsp页面进行交换
		    xhr.open("post", basePath+"/upload", true);
		    //上传成功进入的毁掉函数
		    xhr.onreadystatechange = function(){
				if(xhr.readyState==4 && xhr.status==200){//状态4和200代表和服务器端交互成功
					//获取上传成功的返回数据
					var data = xhr.responseText.trim();
					if(data){
						var jsonArr = JSON.parse(data);
						var json =jsonArr[0];
						$("#preview").attr("src",basePath+"/"+json.url);
						$("#img").val(json.url);
					}
					
				}
			};
			//监听文件上传的进度
		    //xhr.upload.addEventListener("progress", progressFunction, false);
			//发送文件上传的进度
		    xhr.send(form);
		};
		
		//上传进度的回调函数
// 		function progressFunction(evt) {
// 		     var percentageDiv = document.getElementById("percentage");
// 		     var percentDom = document.getElementById("percent");
// 		     if (evt.lengthComputable) {
// 		    	// 获取文件上传的数据和文件的总大小计算百分比
// 		         var p = Math.round(evt.loaded / evt.total * 100) + "%";
// 		    	// 设定给页面的进度条，显示百分比
// 		         percentageDiv.innerHTML = p;
// 		         percentDom.style.width = p;
// 		     }
// 		} ; 
		
	</script>
</body>
</html>