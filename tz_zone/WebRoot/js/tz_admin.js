//关于项目的所有的页面的js代码定义在tz_admin.js中

/*页面置顶*/
function tzUpPage(){
	$(window).scroll(function(){
		var top = $(this).scrollTop();//document.documentElement.scrollTop || document.body.scrollTop;
		if(top>100){
			$("#ke_up").stop(true,true).fadeIn(1000);
		}else{
			$("#ke_up").stop(true,true).fadeOut(1000);
		}
	});	
	

	//置顶
	$("#ke_up").on("click",function(){
		$("html,body").animate({scrollTop:0},600,function(){
			$("#ke_up").hide();
		});
	});
};


/*评论的相关的增删改查*/
var tzComment = {
	del:function(obj){
		if(confirm("您确定删除吗?")){//自定义弹出框
			var $obj = $(obj);//转变成了jquery
			var opid = $obj.data("opid");
			$.ajax({
				type:"post",
				url:basePath+"/comment/del",
				data:{"id":opid},
				success:function(data){
					if(data=="logout"){
						window.location.href = "login.jsp";
					}else if(data=="success"){
						//把当前的元素在页面中移出掉
						$obj.parents(".k_items").fadeOut("slow",function(){
							$(this).remove();	
						});
					}else{
						alert("删除失败");
					}
				}
			});
		}
	}	
};

var tzLogin = {
	logout:function(){
		if(confirm("您确定退出吗")){
			window.location.href = basePath+"/logout";
		}
	}	
};

$(function(){
	//初始化置顶事件
	tzUpPage();
	
});