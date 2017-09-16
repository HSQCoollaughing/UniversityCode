package com.hsq.filter;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hsq.bean.ActionConfig;
import com.hsq.utils.ConfigManager;

/**
 * Servlet Filter implementation class strutsPrepareAndExecuteFilter
 */
@WebFilter("/strutsPrepareAndExecuteFilter")
public class strutsPrepareAndExecuteFilter implements Filter {

    private Map<String, ActionConfig> actionConfigs;

	/**
     * Default constructor. 
     */
    public strutsPrepareAndExecuteFilter() {
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
		HttpServletRequest req =(HttpServletRequest) request;
		HttpServletResponse resp=(HttpServletResponse) response;
		String servletName = req.getServletPath();
		System.out.println("haaaaaaa"+servletName);
		if (!servletName.endsWith(".action")) {
			
			chain.doFilter(request, response);
			throw new RuntimeException("没有找到此action，请检查访问路径");
		}
		int start=1;
		int last = servletName.lastIndexOf(".");
		System.out.println(last);
		String actionName = servletName.substring(start,last);
		System.out.println(actionName);
		ActionConfig ac = actionConfigs.get(actionName);
		if (ac==null) {
			throw new RuntimeException("没有找到此action，请检查访问路径");
		}
		String method = ac.getMethod();
		String clazz = ac.getClazz();
		
		try {
			Class actionClass = Class.forName(clazz);
		Method m=	actionClass.getMethod(method);
		Object newInstance = actionClass.newInstance();
		String resultString = (String) m.invoke(newInstance);
		String jsp = ac.getResulttag().get(resultString).getTargetjsp();
		req.getRequestDispatcher(jsp).forward(req, resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("初始化了,配置文件加载好了。。。。。。。。");
		actionConfigs = ConfigManager.getActionConfig();
		
	}

}
