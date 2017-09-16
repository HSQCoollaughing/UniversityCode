package com.tz.dao;

import com.tz.dao.comment.CommentDao;
import com.tz.dao.user.UserDao;

public class ObjectFactory{

	/**
	 * 
	 * com.tz.dao.ObjectFactory.java 
	 * 方法名：getInstance
	 * 创建人：xuchengfei 
	 * 时间：2016年2月6日下午2:33:58
	 * QQ：761008250
	 * @param params
	 * @return IDaoFactory
	 * @exception 
	 * @since  1.0.0
	 */
	public static IDaoFactory getInstance(String mark){
		IDaoFactory daoFactory =  null;
		if(mark.equalsIgnoreCase("commentDao")){
			daoFactory = new CommentDao();
		}else if(mark.equalsIgnoreCase("userDao")){
			daoFactory = new UserDao();
		}
		return daoFactory;
	}
	
	public static IDaoFactory getInstance(Class<?> clz){
		try {
			IDaoFactory daoFactory = (IDaoFactory) clz.newInstance();
			return daoFactory;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
//	public T getInstance(Class<?> clz){
//		T t = null;
//		try {
//			t = (T) clz.newInstance();
//		} catch (InstantiationException e) {
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			e.printStackTrace();
//		}
//		return t;
//	}
}
