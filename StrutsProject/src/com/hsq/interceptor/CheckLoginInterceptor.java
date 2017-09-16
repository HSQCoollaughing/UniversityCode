package com.hsq.interceptor;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.hsq.bean.User;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class CheckLoginInterceptor extends MethodFilterInterceptor {
	/**
	 * ԭ����intercept()�����ֶ�ActionInvocation��invoke()�������еݹ���ã�
	 * ActionInvocationѭ��Ƕ����intercept()�У�һֱ�����result =
	 * invocation.invoke()ִ�н���������
	 * ��Interceptor�ֻᰴ�ոտ�ʼִ�е�����˳������ִ�н�����һ����������ͨ���ݹ���ã������һ����ջִ�й���
	 * ����һ������ִ�еĴ�������2��ִ��˳����ȫ�෴�Ĵ�����̣��Ӷ������ʵ����AOP����Ҳ�ͳ�Ϊ��Struts2��Action���AOP������
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
			// û�� ǰ����¼ҳ��
			return "login";
		}
		// �� ����
		return invocation.invoke();
	}

}
