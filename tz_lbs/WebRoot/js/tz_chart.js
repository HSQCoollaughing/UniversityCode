
var tzChar = {
	bar:function(targetId,json){
		 // 基于准备好的dom，初始化echarts实例
		var myChart = echarts.init(document.getElementById(targetId));
		// 指定图表的配置项和数据
		var option = {
			title: {
				text: json.title,
			},
			tooltip: {
			},
			legend: {
				data:[json.name]
			},
			xAxis: {
				data: json.xdata
			},
			yAxis: {
			},
			series: [{
				name: json.name,
				type: json.type,
				data: json.data
			}]
		};
		// 使用刚指定的配置项和数据显示图表。
		myChart.setOption(option);
	},
	map:function(){//地图
		
	}
	//此处省略其他的封装
	
};