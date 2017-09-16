/**
 * tzdesk系统平台
 * tz_zone
 * com.tz.core
 * LoginFilter.java
 * 创建人:xuchengfei 
 * 时间：2016年2月17日-上午12:56:24 
 * 2016潭州教育公司-版权所有
 */
package com.tz.core;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tz.util.TzConstanst;

/**
 * 
 * LoginFilter
 * 创建人:xuchengfei 
 * 时间：2016年2月17日-上午12:56:24 
 * @version 1.0.0
 * 
 */
public class LoginFilter implements Filter{

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)resp;
		Integer userId = (Integer)request.getSession().getAttribute(TzConstanst.SESSION_USER_ID);
		String requestType = request.getHeader("X-Requested-With");
		if(userId==null){
			if (requestType != null && requestType.equals("XMLHttpRequest")) {
				response.getWriter().print("logout");
			}else{
				response.sendRedirect("/login.jsp");
			}
		}else{
			chain.doFilter(request, response);
		}
	}
	
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
