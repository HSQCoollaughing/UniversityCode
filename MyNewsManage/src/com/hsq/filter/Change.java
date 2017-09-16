package com.hsq.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * Servlet Filter implementation class Change
 */
@WebFilter(
		urlPatterns = { "/Change" }, 
		initParams = { 
				@WebInitParam(name = "hh", value = "utf-8")
		})
public class Change implements Filter {
	 private String encoding = null;  
    /**
     * Default constructor. 
     */
    public Change() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		 
		        request.setCharacterEncoding(encoding);  
		        response.setContentType("text/html;charset=" + encoding);  
		        chain.doFilter(request, response);  
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		this.encoding = fConfig.getInitParameter("hh");  
	}

}
