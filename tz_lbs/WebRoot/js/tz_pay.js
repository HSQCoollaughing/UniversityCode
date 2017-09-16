var tzPay = {
	pay:function(opts){
		var params = this.params[opts.payType](opts);
		$.ajax({
			type:"post",
			url:"http://localhost/tzpay/"+opts.payType+"/pay.html",
			data:params,
			success:function(data){
				$("body").append(data);
				//window.open("http://localhost/tzpay/wait.jsp");
			}
		});
	},
	
	params:{
		ali:function(opts){
			return {
				pno:opts.pno,
				subject:opts.subject,
				money:opts.money,
				desc:opts.desc,
				userId:1,
				hotelId:1,
				from:"tzlbs",
				detailUrl:opts.detailUrl
			};
		},
		weixin:function(opts){
			return {
				wpno:opts.pno,
				wsubject:opts.subject,
				wmoney:opts.money,
				wdesc:opts.desc,
				wdetailUrl:opts.detailUrl
			};
		},
		wangyin:function(){
			//....
		}
			
	}
};