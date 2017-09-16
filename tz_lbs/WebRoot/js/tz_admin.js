var tzLogin = {
	login:function(){
		this.template();
		//给登录按钮绑定点击事件
		$("#login").find(".loginbtn").on("click",loginMain);
		function loginMain(){
			var username = $("#d_username").val();
			var password = $("#d_password").val();
			
			if(!username){
				alert("请输入用户名...");
				$("#d_username").focus();
				return false;
			}
			
			if(!password){
				alert("请输入密码...");
				$("#d_password").focus();
				return false;
			}
			
			var params = {username:username,password:password};
			var $btns = $(this);
			
			$.ajax({
				type:"post",
				url:basePath+"/login",
				data:params,
				beforeSend:function(){
					$btns.off("click").val("登录中...");
				},
				error:function(){
					$btns.on("click",loginMain).val("登录");
				},
				success:function(data){
					$btns.on("click",loginMain).val("登录");
					if(data=="success"){
						window.location.href = basePath+"/admin";
					}else if(data=="error"){
						alert("请输入正确的账号和密码...");
						$("#d_password").val("").focus();
					}else if(data=="account_null"){
						alert("请输入账号...");
						$("#d_account").val("");
					}else if(data=="pwd_null"){
						alert("请输入密码...");
						$("#d_password").focus();
					}
				}
			});
		}
	},
	template:function(){
		$("body").append("<div id='login' >"+
		"		<h3 class='logo animated rotateIn'><img src='http://localhost/tz_lbs/images/logo.png'/></h3>	"+
		"		<div class='cntbox animated swing'>"+
		"			<p class='animated flipInY'><label for='username'>账号：<input type='text'  maxLength='60' autofocus='autofocus' autocomplete='off' placeholder='请输入账号...' id='d_username'/></label></p>"+
		"			<p class='animated rotateIn'><label for='password'>密码：<input type='password' maxLength='16' id='d_password' autocomplete='off' placeholder='请输入密码(6-16位)...'/></label></p>"+
		"			<p class='animated bounceInLeft'><input type='button' class='loginbtn'  value='登陆'/></p>"+
		"		</div>"+
		"	</div>"+
		"	<div class='tmui-box-overlay'></div>");
	}
};


var tzCommon = {
	message:function(msg,mark){
		//先根据id去dom查找，看是否存在
		var divDom = document.getElementById("keui-message");
		//如果存在先删除，解决重新追加的问题
		if(divDom)document.body.removeChild(divDom);
		//创建一个新的div
		divDom = document.createElement("div");
		//添加id
		divDom.id  = "keui-message";
		//添加class
		divDom.className = tz_animateIn(5)+" keui-tips keui-"+mark;
		//添加内容
		divDom.innerHTML = "<span><i class='iconfont icon-"+mark+"'></i>"+msg+"</span>";
		//放入body中
		document.body.appendChild(divDom);
		
		divDom.timer = setTimeout(function(){
			divDom.className = tz_animateOut(5)+" keui-tips keui-"+mark;
		},3000);
	}
};


//出来的效果,如果不传递index那么就随机效果
function tz_animateIn(index){
	var animateIn = [];
	animateIn.push("animated bounce");//0--心跳效果
	animateIn.push("animated tada");//1
	animateIn.push("animated swing");//2
	animateIn.push("animated wobble");//3
	animateIn.push("animated flip");//4
	animateIn.push("animated flipInX");//5
	animateIn.push("animated flipInY");//6
	animateIn.push("animated fadeIn");//7
	animateIn.push("animated fadeInUp");//8
	animateIn.push("animated fadeInDown");//9
	animateIn.push("animated fadeInLeft");//10
	animateIn.push("animated fadeInRight");//11
	animateIn.push("animated fadeInUpBig");//12
	animateIn.push("animated fadeInDownBig");//13
	animateIn.push("animated fadeInLeftBig");//14
	animateIn.push("animated fadeInRightBig");//15
	animateIn.push("animated bounceIn");//16
	animateIn.push("animated bounceInUp");//17
	animateIn.push("animated bounceInDown");//18
	animateIn.push("animated bounceInLeft");//19
	animateIn.push("animated bounceInRight");//20
	animateIn.push("animated rotateIn");//21
	animateIn.push("animated rotateInUpLeft");//22
	animateIn.push("animated rotateInDownLeft");//23
	animateIn.push("animated rotateInUpRight");//24
	animateIn.push("animated rotateInDownRight");//25
	animateIn.push("animated rollIn");//26
	if(!index){
		var len = animateIn.length;
		var r = Math.floor(Math.random()*(len-1)+1);
		return animateIn[r];
	}else{
		return animateIn[index];
	}
};

//出去的效果
function tz_animateOut(index){
	var animateOut = [];
	animateOut.push("animated flipOutX");//0
	animateOut.push("animated flipOutY");//1
	animateOut.push("animated fadeOut");//2
	animateOut.push("animated fadeOutUp");//3
	animateOut.push("animated fadeOutDown");//4
	animateOut.push("animated fadeOutLeft");//5
	animateOut.push("animated fadeOutRight");//6
	animateOut.push("animated fadeOutUpBig");//7
	animateOut.push("animated fadeOutDownBig");//8
	animateOut.push("animated fadeOutLeftBig");//9
	animateOut.push("animated fadeOutRightBig");//10
	animateOut.push("animated bounceOut");//11
	animateOut.push("animated bounceOutUp");//12
	animateOut.push("animated bounceOutDown");//13
	animateOut.push("animated bounceOutLeft");//14
	animateOut.push("animated bounceOutRight");//15
	animateOut.push("animated rotateOut");//16
	animateOut.push("animated rotateOutUpLeft");//17
	animateOut.push("animated rotateOutDownLeft");//18
	animateOut.push("animated rotateOutDownRight");//19
	animateOut.push("animated rollOut");//21
//		animateOut.push("animated hinge");//20
	if(!index){
		var len = animateOut.length;
		var r = Math.floor(Math.random()*(len-1)+1);
		return animateOut[r];
	}else{
		return animateOut[index];
	}
};

function deserialize(formObj){
	var params = formObj.serializeArray();
	var json = {};
	for(var i=0;i<params.length;i++){
		json[params[i].name] = [params[i].value,formObj.find("*[name='"+params[i].name+"']")];
	}
	return json;
};


/**
 * 判断非空
 * 
 * @param val
 * @returns {Boolean}
 */
function isEmpty(val) {
	val = $.trim(val);
	if (val == null)
		return true;
	if (val == undefined || val == 'undefined')
		return true;
	if (val == "")
		return true;
	if (val.length == 0)
		return true;
	if (!/[^(^\s*)|(\s*$)]/.test(val))
		return true;
	return false;
};

function isNotEmpty(val) {
	return !isEmpty(val);
};


function getFromElement(formObj,username){
	return 	formObj.find("*[name='"+username+"']");

};
//function changeAddress(href,info){
//	$("#sliderbar").append("<a href='"+href+"'>"+info+"</a>");
//}

function changeAddress(options){
	for(var key in options){
		$("#sliderbar").append("<a href='"+options[key]+"'>"+key+"</a>");
	}
}