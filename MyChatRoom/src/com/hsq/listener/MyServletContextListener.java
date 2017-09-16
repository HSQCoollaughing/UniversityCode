package com.hsq.listener;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;

import com.hsq.dto.User;

public class MyServletContextListener implements ServletContextListener {
/**
 * 
 * 监听servletcontext对象的创建与销毁
 */
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
	
	}

	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		Map<User,HttpSession> userMap=new HashMap<User, HttpSession>();
		sce.getServletContext().setAttribute("userMap", userMap);
	}

}
