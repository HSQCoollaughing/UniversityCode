package com.tz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.struts2.json.JSONException;
import org.apache.struts2.json.JSONUtil;

import com.tz.bean.User;

public class UserDao {

	

	
	/**
	 * 根据酒店id查询对应酒店信息
	 * com.tz.dao 
	 * 方法名：getHotel
	 * 创建人：xuchengfei 
	 * 手机号码:15074816437
	 * 时间：2016年2月22日-下午9:34:35 
	 * @param hotelId
	 * @return 
	 * 返回类型：Hotel
	 * @exception 
	 * @since  1.0.0
	 */
	public User getUser(String username,String password){
		//想着和keke老师打电话
		//第一步：connection
		Connection connection = null;
		//第二步 执行sql
		PreparedStatement statement = null;
		//第三步：返回信息
		ResultSet rs = null;
		//返回值
		User user = null;
		try {
			//连接初始化
			connection = ConnectionUtil.getConnection();
			String sql = "SELECT id,username,`password`,acccount,header_pic,male,idcard,telephone FROM tz_user WHERE acccount = ? AND `password`=?";
			//处理对象
			statement = connection.prepareStatement(sql);
			statement.setString(1, username);
			statement.setString(2, password);
			//返回一个结构集
			rs = statement.executeQuery();
			if(rs.next()){//rs.next()游标
				user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setAcccount(rs.getString("acccount"));
				user.setHeadePpic(rs.getString("header_pic"));
				user.setMale(rs.getInt("male"));
				user.setIdcard(rs.getString("idcard"));
				user.setTelephone(rs.getString("telephone"));
			}
			return user;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally{
			ConnectionUtil.closeResultSet(rs, statement, connection);
		}
	}
	
	
	public static void main(String[] args) throws JSONException {
//		List<Hotel> hotels = new HotelDao().findHotels(310000,"yu",0, 10);
//		System.out.println(JSONUtil.serialize(hotels));
		
		User user = new UserDao().getUser("keke","Gnt1KGp9GfcfQtSD/ciUDStw==");
		System.out.println(JSONUtil.serialize(user));
		
//		Hotel hotel = new UserDao().getHotel(1);
//		System.out.println(JSONUtil.serialize(hotel,null,null,true,true));
	}
}
