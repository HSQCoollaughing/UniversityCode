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

import com.tz.bean.User;
import com.tz.util.TzConstanst;

/**
 * 
 * 统一拦截编码处理
 * CharacterFilter
 * 创建人:xuchengfei 时间：2016年2月20日-下午9:53:18 
 * @version 1.0.0
 *
 */
public class LoginFilter implements Filter{

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}
	

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)resp;
		User user = (User) request.getSession().getAttribute(TzConstanst.SESSION_USER_ID);
		if(user==null){			
			response.sendRedirect("../");		
		}else{
			chain.doFilter(request, response);
		}
	}

	@Override
	public void destroy() {
		
	}
}
