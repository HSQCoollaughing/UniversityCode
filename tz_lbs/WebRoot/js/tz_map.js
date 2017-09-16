/*关于地图的操作*/	
var tzMap = {
	map:null,
	//其实地图初始化相关
	init:function(map){
		this.map = map;
		//为地图注册click事件获取鼠标点击出的经纬度坐标,并且同时打标记
		var clickEventListener = this.map.on('click', function(e) {
			var cicon = $("#cicon").val();
			tzMap.marker(e.lnglat.getLng(), e.lnglat.getLat(),cicon);
			$("#gw").val(e.lnglat.getLng()+","+e.lnglat.getLat());
			//tzMap.dialog(e.lnglat.getLng(), e.lnglat.getLat());
		});
	},
	//城市切换
	change:function(city){
		this.map.setCity(city);
	},
		//雪碧图(合成图)的方式切换标记，
	marker:function(gd,wd,icon,callback){
		var thisMap = this.map;
		var marker = new AMap.Marker({ //添加自定义点标记
			map: thisMap,
			position: [gd, wd], //基点位置
			offset: new AMap.Pixel(-17, -52), //相对于基点的偏移位置
			draggable: false,  //是否可拖动
			content: '<span class="mp micon '+icon+'"></span>'   //自定义点标记覆盖物内容
		});
		
		//标记绑定点击事件，打开窗口
		AMap.event.addListener(marker, 'click', function() {
			var dialog = tzMap.markDialog();
			dialog.open(thisMap, marker.getPosition());
		});
		
		if(callback)callback.call(thisMap,tzMap,marker);
	},
	//标记物窗口
	markDialog:function(){
		var template  = "<div class='hotel'>"+
		"		<div class='h_pic'>"+
		"			<img src='images/h_1.jpg' alt='' width='420' height='200' />"+
		"		</div>"+
		"		<div class='h_info'>"+
		"			<div class='h_left'>"+
		"				<p class='h_title'>"+
		"					<a href='#'>上海中环国际大酒店</a>"+
		"					<span class='h_icon'></span>"+
		"				</p>"+
		"				<p class='h_level'><span></span></p>"+
		"			</div>"+
		"			<div class='h_right'>"+
		"				<span class='h_price'>586.00￥</span>"+
		"			</div>"+
		"			<div class='clear'></div>"+
		"		</div>"+
		"		<p class='h_addr'>普陀区富平路800号，近真金路。 （ 曹杨、真如地区大宁国际商业区）</p>"+
		"		<a href='javascript:void(0)' onclick='tzMapPay(this)'  class='h_pay'>立即预定支付</a>"+
		"	</div>";
		var infowindow = new AMap.InfoWindow({
			 content: template,
			 offset: new AMap.Pixel(-4, -50),
			 size:new AMap.Size(0,0)
		});
		return infowindow;
	},
	//经纬度窗口
	dialog:function(gd,wd){
		var infowindow = new AMap.InfoWindow({
			 content: '<h3>高德地图</h1><div>高德是中国领先的数字地图内容、导航和位置服务解决方案提供商。</div>',
			 offset: new AMap.Pixel(0, -30),
			 size:new AMap.Size(230,0)
		});
		//直接根据经度和纬度打开窗口
		infowindow.open(this.map,new AMap.LngLat(gd,wd));
	}


	//单独图片的切换标记
	/*marker2:function(gd,wd,icon){
		var marker = new AMap.Marker();
		marker.setMap(map);
		marker.setIcon(new AMap.Icon({            
		size: new AMap.Size(40, 50),  //图标大小
			image: "http://webapi.amap.com/theme/v1.3/images/newpc/"+icon+".png",
			imageOffset: new AMap.Pixel(0, -60)
		}));
		marker.setPosition([gd, wd]);
	},*/
	
};


function tzMapPay(obj){
	var opts = {payType:"ali"};
	tzPay.pay(opts);
}
