package com.tz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.struts2.json.JSONException;
import org.apache.struts2.json.JSONUtil;

public class AreaDao {

	/**
	 * 根据城市id查询对应区域
	 * 方法名：findCitys
	 * 创建人：xuchengfei 
	 * 时间：2016年2月20日-下午9:43:28 
	 * 手机:1564545646464
	 * @param pid
	 * @return List<HashMap<String,Object>>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<HashMap<String, Object>> findAreas(Long cityId) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		List<HashMap<String, Object>> citys = null;
		try {
			String sql = "SELECT id,area FROM tm_area WHERE city_id =  ?";
			//获取链接对象
			connection = ConnectionUtil.getConnection();
			//处理对象
			statement = connection.prepareStatement(sql);
			statement.setLong(1, cityId);
			//返回结果集
			rs = statement.executeQuery();
			//遍历结果集
			citys = new ArrayList<HashMap<String, Object>>();//jdk7出现了一种菱形泛型
			HashMap<String, Object> city =null;
			while (rs.next()) {
				 city = new HashMap<String, Object>();
				 city.put("id", rs.getLong("id"));
				 city.put("name", rs.getString("area"));
				 citys.add(city);
			}
			return citys;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			ConnectionUtil.closeResultSet(rs, statement, connection);
		}
	}
	
	public static void main(String[] args) throws JSONException {
		List<HashMap<String, Object>> maps = new AreaDao().findAreas(220100L);
		System.out.println(JSONUtil.serialize(maps));
	}

}
