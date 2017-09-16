package com.hsq.web.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class LoginInterceptor extends MethodFilterInterceptor {

	@Override
	public String doIntercept(ActionInvocation invocation) throws Exception {
		System.out.println("登录拦截器");
		Object obj = ActionContext.getContext().getSession().get("loginStaff");
		if (obj==null) {
			
			
			Object action = invocation.getAction();//获取当前运行的action
			if(action instanceof ActionSupport){
				ActionSupport actionSupport=(ActionSupport) action;
				actionSupport.addFieldError("", "请登录");//友好信息
				
			}
			return "login";
		}
		return invocation.invoke();
	}

}
