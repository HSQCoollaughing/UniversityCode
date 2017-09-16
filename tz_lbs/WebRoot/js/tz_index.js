// 商品列表收缩
$(function(){
	var map = new AMap.Map('c_map_con', {
	    resizeEnable: true,
	    zoom:11,
	    center: [116.397428, 39.90923]
	});	
	
	/******************************实时更改数据层的高度****************************/
	function changeHeight(){
		$(".c_list").height($(window).height()-55);
	};
	//随着窗口更改的时候，触发的函数，改变元素的高度
	$(window).resize(changeHeight);
	changeHeight();
	/******************************实时更改数据层的高度****************************/
	
	
	/*******************实现滚动条分页**********************/
	
	$(".c_list").scroll(function(){
		var scrollTop = $(this).scrollTop();//document.getElementById("box").scrollTop;
		var scrollHeight = $(this).get(0).scrollHeight;
		var clientHeight = $(this).height();//真实的clientHeight
		//var innerHeight = $(this).innerHeight();//包含边框 真实的clientHeight + border
		//var outerHeight = $(this).outerHeight(true);//border padding margin 真实的clientHeight + padding+border+margin
		//var outerHeight2= $(this).outerHeight();//padding border 真实的clientHeight+padding+border
		var sbit = scrollTop + clientHeight + 3;
		//console.log(clientHeight+"=="+innerHeight+"==="+outerHeight+"==="+outerHeight2);
		if(sbit >= scrollHeight && cmark){//scrollHeight;这个说明滚动已经拉底部了
			clearTimeout(this.timer);//为了解决用户恶意拉动的一些延时处理
			this.timer = setTimeout(function(){
				pageNo++;
				loadDianPuData(false,pageNo * pageSize,10);
			},200);
		}
	});
	
	
	
	//初始化,获取经纬度的初始化
	tzMap.init(map);
	$("#btn").click(function(){
		var text = $("#btn").text();
		if(">>" == text){
			$("#content .c_list").animate({right:"-285px"});
			$(this).animate({right:0}).html("&lt;&lt;");
		} else {
			$("#content .c_list").animate({right:0});
			$(this).animate({right:"285px"}).html("&gt;&gt;");				
		}
	});

	$(".micon").click(function(){
		var icon = $(this).data("icon");
		$("#cicon").val(icon);
	});
	
	loadDianPuData(false,0,10);
});

/*搜索的业务*/
function searchData(mark,pno,psize){
	cmark = true;
	$("#k_diapulist").empty();
	pageNo = 0;
	pageSize = 10;
	loadDianPuData(mark,pno,psize);
}

var pageNo = 0;
var pageSize = 10;
var cmark = true;
/*通过ajax查询数据*/
function loadDianPuData(mark,pageNo,pageSize){
	//获取选中的省份
	var pid = $("#province").find("option:selected").val();
	if(!pid && mark){
		alert("请选择一个省份在进行此操作...");
		return;
	}
	var address = $("#province").find("option:selected").text();
	var keyword = $("#keyword").val();
	tzMap.change(address);
	if(!cmark)return;
	$.ajax({
		type:"post",
		data:{pid:pid,pageNo:pageNo,pageSize:pageSize,keyword:keyword},
		url:basePath+"/hotel",
		success:function(data){
			if(!data){
				cmark = false;
				return;
			}
			if(data){
				var jsonArr = eval("("+data+")");
				var html = "";
				for(var i=0,len=jsonArr.length;i<len;i++){
					var data = jsonArr[i];
					html += "<li>"+
					"	<a href='javascript:void(0);' data-opid='"+data.id+"'  class='ke_dianpu' data-gd='"+data.gd+"'  data-wd='"+data.wd+"' data-icon='"+data.icon+"'>"+
					"		<img src='"+data.img+"' alt='"+data.name+"' width='48' height='48' align='center'/>"+
					"		<span class='micon c_pos "+data.icon+"' data-icon='"+data.icon+"'></span>"+
					"	</a>"+
					"	<div class='c_box'><span class='title'>"+data.name+"</span>"+
					"	<span class='desc'>"+getStar(data.level)+"</span></div>"+
					"</li>";
					//数据加载的键店铺定位地图中
					tzMap.marker(data.gd,data.wd,data.icon);
				};
				
				$("#k_diapulist").append(html);//追加


				$("#k_diapulist").find(".ke_dianpu").click(function(){
					var gd = $(this).data("gd");
					var wd = $(this).data("wd");
					var icon = $(this).data("icon");
					//获取当前点击的店铺id，拿到当前的id通过异步查询加载
					var opid = $(this).data("opid");
					tzMap.marker(gd,wd,icon,function(tzMap,marker){
						var map = this;
						$.ajax({
							type:"post",
							url:basePath+"/hotelDetail",
							data:{hotelId:opid},
							success:function(data){
								if(data){
									var json = JSON.parse(data);
									var template  = "<div class='hotel'>"+
									"		<div class='h_pic'>"+
									"			<img src='"+json.img+"' alt='' width='420' height='200' />"+
									"		</div>"+
									"		<div class='h_info'>"+
									"			<div class='h_left'>"+
									"				<p class='h_title'>"+
									"					<a href='#'><i class='iconfont icon-iconhottitle'></i>&nbsp;&nbsp;"+json.name+"</a>"+
									"					<span class='h_icon'></span>"+
									"				</p>"+
									"				<p class='h_level'><span></span></p>"+
									"			</div>"+
									"			<div class='h_right'>"+
									"				<span class='h_price'>"+getStar(json.level)+"</span>"+
									"				<span class='h_price'><i class='iconfont icon-tel'></i>&nbsp;&nbsp;"+json.telephone+"</span>"+
									"			</div>"+
									"			<div class='clear'></div>"+
									"		</div>"+
									"		<p class='h_addr desc'>"+(json.description||"")+"</p>"+
									"		<p class='h_addr'>"+(json.address||"")+"</p>"+
									"		<a href='javascript:void(0);' title='"+json.name+"' data-money='25.5' onclick='tzMapPay(this)'  class='h_pay'><i class='iconfont icon-pay'></i>&nbsp;&nbsp;立即预定支付</a>"+
									"	</div>";
									
									//窗口对象初始化
									var infowindow = new AMap.InfoWindow({
										 content: template,
										 offset: new AMap.Pixel(-4, -50),
										 size:new AMap.Size(0,0)
									});
									//打开窗口
									infowindow.open(map, marker.getPosition());
								}
							}
						});
					});
				});
			}
		}
	});
};

//根据等级获取星数
function getStar(num){
	var num1 = Math.floor(num);
	var num2 = num - num1;
	var html = "";
	for(var i=0;i<num1;i++){
		html+="<i class='iconfont icon-iconlove'></i>";
	}
	if(num2>0)html+="<i class='iconfont icon-icon'></i>";
	return html;
};




function tzMapPay(obj){
	var pno = new Date().getTime();
	var subject = $(obj).attr("title");
	//var money = $(obj).data("money");
	var money = "0.01";
	var desc = $(obj).prev().prev().text();
	var detailUrl = window.location.href;
	var opts = {payType:"ali",
		pno:pno,
		subject:subject,
		money:money,
		desc:desc,
		detailUrl:detailUrl
	};
	tzPay.pay(opts);
}
