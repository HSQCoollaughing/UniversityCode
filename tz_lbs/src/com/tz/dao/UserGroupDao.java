package com.tz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.apache.struts2.json.JSONException;
import org.apache.struts2.json.JSONUtil;

import com.tz.bean.Hotel;
import com.tz.bean.TzParams;
import com.tz.bean.User;
import com.tz.util.TmStringUtils;

public class UserGroupDao {

	/**
	 * 保存店铺信息
	 * 方法名：saveHotal
	 * 创建人：xuchengfei 
	 * 时间：2016年2月27日-下午10:52:32 
	 * 手机:1564545646464
	 * @param hotel void
	 * @exception 
	 * @since  1.0.0
	 */
	public boolean saveUser(String username,Integer age){
		//想着和keke老师打电话
		//第一步：connection
		Connection connection = null;
		//第二步 执行sql
		PreparedStatement statement = null;
		try {
			//连接初始化
			connection = ConnectionUtil.getConnection();
			String sql = "INSERT INTO tz_user_group(username,age)VALUES(?,?)";
			System.out.println("执行的sql是:"+sql);
			//处理对象
			statement = connection.prepareStatement(sql);
			statement.setString(1, username);
			statement.setInt(2, age);
			int count = statement.executeUpdate();
			return count>0?true:false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally{
			ConnectionUtil.closeStatement(statement, connection);
		}
	}
	
	
//	var json = {
//		total:320,
//		xdata:[],
//		ydata:[34,59,7,89,]
//			
//	}
	
	public HashMap<String, Object> findGroupAge(Integer year) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			StringBuilder builder = new StringBuilder();
			builder.append(" SELECT GROUP_CONCAT(c.cn) as ctext,GROUP_CONCAT(CONVERT(c.ct,CHARACTER))as cnt FROM ( ");
			builder.append(" SELECT \"少年(0-12)\" as cn,COUNT(1)as ct FROM tz_user_group   ");
			builder.append(" WHERE DATE_FORMAT(create_time,'%Y') = "+year+" "); 
			builder.append(" AND age BETWEEN 0 AND 12 ");
			builder.append(" UNION ALL ");
			builder.append(" SELECT \"青少年(13-20)\" as cn,COUNT(1)as ct FROM tz_user_group ");  
			builder.append(" WHERE DATE_FORMAT(create_time,'%Y') = "+year+" "); 
			builder.append(" AND age BETWEEN 13 AND 20 ");
			builder.append(" UNION ALL ");
			builder.append(" SELECT \"青年(21-30)\" as cn,COUNT(1) FROM tz_user_group ");  
			builder.append(" WHERE DATE_FORMAT(create_time,'%Y') = "+year+" "); 
			builder.append(" AND age BETWEEN 21 AND 30 ");
			builder.append(" UNION ALL ");
			builder.append(" SELECT \"壮年(31-40)\" as cn,COUNT(1)as ct FROM tz_user_group ");  
			builder.append(" WHERE DATE_FORMAT(create_time,'%Y') = "+year+" "); 
			builder.append(" AND age BETWEEN 31 AND 40 ");
			builder.append(" UNION ALL ");
			builder.append(" SELECT \"中年(41-60)\" as cn,COUNT(1)as ct FROM tz_user_group ");  
			builder.append(" WHERE DATE_FORMAT(create_time,'%Y') = "+year+" "); 
			builder.append(" AND age BETWEEN 41 AND 60 ");
			builder.append(" UNION ALL ");
			builder.append(" SELECT \"老年(>60)\" as cn,COUNT(1) as ct FROM tz_user_group ");  
			builder.append(" WHERE DATE_FORMAT(create_time,'%Y') = "+year+" "); 
			builder.append(" AND age > 60 ");
			builder.append(" ) c");

			//获取链接对象
			connection = ConnectionUtil.getConnection();
			//处理对象
			statement = connection.prepareStatement(builder.toString());
			//返回结果集
			rs = statement.executeQuery();
			HashMap<String, Object> map = new HashMap<String,Object>();
			if (rs.next()) {
				map.put("text", rs.getString("ctext"));
				map.put("count", rs.getString("cnt"));
			}
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			ConnectionUtil.closeResultSet(rs, statement, connection);
		}
	}

	

	
	
	
	
	public static void main(String[] args) throws JSONException {
//		for(int i=1;i<=320;i++){
//			int age = new Random().nextInt(100);
//			new UserGroupDao().saveUser("keke_"+i, age);
//		}
		
		
		System.out.println(new UserGroupDao().findGroupAge(2016));
		
		
		
//		System.out.println(builder.toString());
	}
}
