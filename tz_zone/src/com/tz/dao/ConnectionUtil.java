package com.tz.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static com.tz.util.TzConstanst.*;


/**
 * 
 * ConnectionUtil.java
 * 创建人:xuchengfei 
 * 时间：2016年2月6日下午1:37:16 
 * @version 1.0.0
 *
 */
public class ConnectionUtil {
	
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
	public static Connection getConnection(){
		try {
			Class.forName(DRIVER);
			Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			return connection;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	* 关闭查询语句
	* com.tz.dao.ConnectionUtil.java 
	* 方法名：closeResultSet
	* 创建人：xuchengfei 
	* 时间：2016年2月6日下午2:04:09
	* @param params
	* @return void
	* @exception 
	* @since  1.0.0
	 */
	public static void closeResultSet(ResultSet rs,PreparedStatement stat,Connection con){
		try {
			if(rs!=null)rs.close();
			if(stat!=null)stat.close();
			if(con!=null)con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 关闭处理语言的,增删改
		* com.tz.dao.ConnectionUtil.java 
		* 方法名：closeStatement
		* 创建人：xuchengfei 
		* 时间：2016年2月6日下午2:04:34
		* @param params
		* @return void
		* @exception 
		* @since  1.0.0
	 */
	public static void closeStatement(PreparedStatement stat,Connection con){
		try {
			if(stat!=null)stat.close();
			if(con!=null)con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
