package com.hsq.interceptor;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.hsq.bean.User;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class CheckLoginInterceptor extends MethodFilterInterceptor {
	/**
	 * 原来在intercept()方法又对ActionInvocation的invoke()方法进行递归调用，
	 * ActionInvocation循环嵌套在intercept()中，一直到语句result =
	 * invocation.invoke()执行结束。这样
	 * ，Interceptor又会按照刚开始执行的逆向顺序依次执行结束。一个有序链表，通过递归调用，变成了一个堆栈执行过程
	 * ，将一段有序执行的代码变成了2段执行顺序完全相反的代码过程，从而巧妙地实现了AOP。这也就成为了Struts2的Action层的AOP基础。
	 * 
	 * 
	 * 
	 * 
	 */
	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		HttpSession session = ServletActionContext.getRequest().getSession();
		User user = (User) session.getAttribute("user");
		if (user == null) {
			// 没有 前往登录页面
			return "login";
		}
		// 有 放行
		return invocation.invoke();
	}

}
