var tzIndex = (function(){
	return {
		sendCharacter:function(){
			var content = $("#content").val();//document.getElementById("content").value;
			var title = $("#title").val();
			if(isEmpty(title)){
				alert("请输入标题...");
				$("#title").focus();
				return;
			}
			if(isEmpty(content)){
				alert("请输入内容...");
				$("#content").focus();
				return;
			}
			
			$.ajax({
				type:"post",
				url:basePath+"/comment/save",
				data:{title:title,content:content,tag:"java,javascript"},
				success:function(data){
					if(data=="logout"){
						window.location.href = "login.jsp";
					}else if(data.trim()=="success"){
						//清空输入框
						$("#content").val("");
						$("#title").val("").focus();
						var json = {
							title:title,
							content:content,
							tag:"",
							username:"keke",
							headerPic:basePath+"/images/user_img2.jpg"
						};
						var html = getTemplate("commentTemplate").formatObject(json);
						$("#comemntbox").prepend(html);
					}else{
						alert("保存失败....");
					}
				}
			});
		},
		sendPicture:function(){
			alert(2);
		},
		sendVideo:function(){
			alert(3);
		},
		sendLink:function(){
			alert(4);
		},
		sendSource:function(){
			alert(5);
		},
		
		createTag:function(tagName){
			var html = "";
			if(isNotEmpty(tagName)){
				var tnames = tagName.split(",");
				tnames.forEach(function(obj){
					html +=" <a href='javascript:void(0)' style='color:#c5c6c9;'>#"+obj+"</a>";
				});
			}
			return html;
		},
		scrollPage:function(){
			var obj = this;
			//当前可视区域的高度+滚动条的Top==滚动条的高度或者内容的高度
			window.onscroll = function(){
				var clientHeight = window.innerHeight || document.documentElement.clientHeight;
				var stop = document.documentElement.scrollTop || document.body.scrollTop;
				var bodyHeight = document.body.clientHeight;
				if((clientHeight+stop+30) >=bodyHeight){
					if(obj.mark && obj.smark){
						$("#loadingbox").show();
						clearTimeout(this.stimer);
						this.stimer = setTimeout(function(){
							obj.list();	
						},200);
					}else{
						$("#loadingbox").show().html("加载完毕了...");
					}
				}
			};
		},
		pageNo:0,
		pageSize:10,
		mark:true,
		smark:true,
		list:function(callback){
			var obj = this;
			/*第一种方式
			$.ajax({
				type:"post",
				url:basePath+"/commentList",
				success:function(data){
					
					if(data){
						var jsonArray = JSON.parse(data);
						var html = "";
						for(var i=0,len=jsonArray.length;i<len;i++){
							var json = jsonArray[i];
							var tagHtml = obj.createTag(json.tag);
							html+="<div data-uid='"+json.userId+"' data-opid="+json.id+" class='clearfix mt20'>"+
							"	<div class='fl cont_user_img'>"+
							"	    <img src='"+basePath+"/"+json.headerPic+"'>"+
							"	</div>"+
							"	<div class='fl cont_comments'>"+
							"	    <p><a href='javascript:void(0)'>Tanzhoucanyin 转载自  "+json.username+"</a> "+json.createTime+"</p>"+
							"	    <h3 class='mt20 essay_title'>"+json.title+"</h3>"+
							"	    <p class='mt10 essay_cont'>"+json.content+"</p>"+
							"	    <div class='mt10 clearfix'>"+
							"	        <p class='fl fs12'>"+tagHtml+"</p> "+
							"	        <p class='fr fs12'>"+
							"	            <a href='javascript:void(0)' class='Leave_btn'><i class='icon_tb Leave_tb'></i>0</a>"+
							"	            <a href='javascript:void(0)' class='Leave_btn'><i class='icon_tb forwarding_tb'></i>0</a>"+
							"	            <a href='javascript:void(0)' class='Leave_btn'><i class='icon_tb collection_tb'></i>0</a>"+
							"	         </p> "+
							"	    </div>"+
							"	</div>"+
							"	</div>";
						}
						$("#comemntbox").append(html);
					}
				}
			});
			*/
			
			
			if(obj.mark){
				obj.mark = false;
				//第二种方式:
				var pno = obj.pageNo * obj.pageSize;
				//if(pno>totalCount)return;
				$.ajax({
					type:"post",
					url:basePath+"/comment/list",
					data:{pageNo:pno,pageSize:obj.pageSize},//0 10 /10 10 /20 10
					success:function(data){
						if(isNotEmpty(data)){
							if(data=="logout"){
								window.location.href = "login.jsp";
								return;
							}
							$("#comemntbox").append(data);
							obj.pageNo++;
							obj.mark = true;
						}else{
							obj.smark = false;
						}
						$("#loadingbox").hide();
						if(callback)callback();
					}
				});
			}
			//$("#comemntbox").load(basePath+"/commentList");
		}
	};
})();

function getTemplate(id){
	return $("#"+id).html().replace(/\/\*/,"").replace(/\*\/$/,"");
};

//jquery初始化diamante
$(function(){
	for(var key in tzIndex){
		$("#"+key).on("click",tzIndex[key]);
	}
	
	//初始化
	tzIndex.list(function(){
		tzIndex.scrollPage();
	});
});


