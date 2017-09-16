<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML >
<html>
  <head>
    <title>My JSP 'pca.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style>
		#box{width:800px;height:100px;margin:100px auto;}
		select{padding:10px 16px;}
	</style>
	<script type="text/javascript" src="js/jquery-1.11.2.min.js"></script>
  </head>
  
  <body>
    	
    	<!--
    		省市区的数据，是一种不会修改的数据，这种如果存储到数据进行查询，一定缓存中或者application中
    		
    		
    	  -->
    
    	<div id="box">
    		省份：<select id="province" onchange="changeCity(this.value)">
    			
    		</select>
    		城市：<select id="city" onchange="changeArea(this.value)">
    			<option value="">--请选择城市--</option>
    		</select>
    		区域：<select id="area">
    			<option value="">--请选择区域--</option>
    		</select>
    	
    	</div>
    	
    	<script type="text/javascript">
    	
    		function loadProvince(){
    			$.get("http://localhost/tz_lbs/pca/province.json",function(data){
    				getHTML("province",data,"省份");
        		});
    		};
    		
    		loadProvince();

    		//省份改变城市--讲省市区呢？----ajax最好的案例
    		function changeCity(pid){
    			//if(!pid){
    			if(pid==""){
    				return;
    			}
    			$("#area").html("<option value=''>--请选择区域--</option>");
    			$.ajax({
    				type:"post",
    				data:{pid:pid},
    				url:"http://localhost/tz_lbs/city",
    				success:function(data){
    					var json = eval("("+data+")");
    					getHTML("city",json,"城市");
    				}
    			});
    		};
    		
    		function changeArea(cid){
    			if(cid==""){
    				return;
    			}
    			$.ajax({
    				type:"post",
    				data:{cid:cid},
    				url:"http://localhost/tz_lbs/area",
    				success:function(data){
    					//第二种方式：
    					var json = eval("("+data+")");
    					getHTML("area",json,"区域");
    				}
    			});
    		};
    		
    			
    		function getHTML(id,data,message){
    			var html = "<option value='''>--请选择"+message+"--</option>";
        		for(var i=0,len=data.length;i<len;i++){
        			html+="<option value='"+data[i].id+"'>"+data[i].name+"</option>";
        		}
        		$("#"+id).html(html);
    		}
    	
    	</script>
  </body>
</html>
7