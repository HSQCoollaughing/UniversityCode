package com.tz.dao;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


/**
 * 
 * ConnectionUtil.java
 * 创建人:xuchengfei 
 * 时间：2016年2月6日下午1:37:16 
 * @version 1.0.0
 *
 */
public class MybatisConnectionUtil {
	
	/**
		 * com.tz.dao.ConnectionUtil.java 
		 * 方法名：getConnection
		 * 创建人：xuchengfei 
		 * 时间：2016年2月6日下午1:40:34
		 * @param params
		 * @return Connection
		 * @exception 
		 * @since  1.0.0
	 */
	public static SqlSession getSession(){
		try {
			InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
			SqlSessionFactory sessionFactory  = new SqlSessionFactoryBuilder().build(inputStream);
			SqlSession session = sessionFactory.openSession(true);
			return session;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(getSession());
		System.out.println("sdfsdfsd");
	}
}
