package com.tz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.struts2.json.JSONException;
import org.apache.struts2.json.JSONUtil;

public class CityDao {

	/**
	 * 根据省份id查询对应的城市
	 * 方法名：findCitys
	 * 创建人：xuchengfei 
	 * 时间：2016年2月20日-下午9:43:28 
	 * 手机:1564545646464
	 * @param pid
	 * @return List<HashMap<String,Object>>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<HashMap<String, Object>> findProvince() {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		List<HashMap<String, Object>> citys = null;
		try {
			String sql = "SELECT id,province from tm_province";
			//获取链接对象
			connection = ConnectionUtil.getConnection();
			//处理对象
			statement = connection.prepareStatement(sql);
			//返回结果集
			rs = statement.executeQuery();
			//遍历结果集
			citys = new ArrayList<HashMap<String, Object>>();//jdk7出现了一种菱形泛型
			HashMap<String, Object> city =null;
			while (rs.next()) {
				 city = new HashMap<String, Object>();
				 city.put("id", rs.getLong("id"));
				 city.put("name", rs.getString("province"));
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
	
	/**
	 * 根据省份id查询对应的城市
	 * 方法名：findCitys
	 * 创建人：xuchengfei 
	 * 时间：2016年2月20日-下午9:43:28 
	 * 手机:1564545646464
	 * @param pid
	 * @return List<HashMap<String,Object>>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<HashMap<String, Object>> findCitys(Long pid) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		List<HashMap<String, Object>> citys = null;
		try {
			String sql = "SELECT id,city FROM tm_city WHERE province_id = ?";
			//获取链接对象
			connection = ConnectionUtil.getConnection();
			//处理对象
			statement = connection.prepareStatement(sql);
			statement.setLong(1, pid);
			//返回结果集
			rs = statement.executeQuery();
			//遍历结果集
			citys = new ArrayList<HashMap<String, Object>>();//jdk7出现了一种菱形泛型
			HashMap<String, Object> city =null;
			while (rs.next()) {
				 city = new HashMap<String, Object>();
				 city.put("id", rs.getLong("id"));
				 city.put("name", rs.getString("city"));
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
//		List<HashMap<String, Object>> maps = new CityDao().findCitys(220000L);
//		System.out.println(maps);
//		System.out.println(JSONUtil.serialize(maps));
//		
//		String jsonstring ="[{\"id\":10,\"age\":20},{\"id\":20,\"age\":40}]";
//		List<HashMap<String, Object>> maps2 = (List<HashMap<String, Object>>) JSONUtil.deserialize(jsonstring);
//		for (HashMap<String, Object> hashMap : maps2) {
//			System.out.println(hashMap.get("id")+"==="+hashMap.get("age"));
//		}
		
		
		List<HashMap<String, Object>> provinces = new CityDao().findProvince();
		System.out.println(JSONUtil.serialize(provinces));
//		TreeMap<Long, Object> map = new TreeMap<>();
//		TreeMap<Long, Object> map2 = new TreeMap<>();
//		for (HashMap<String, Object> hashMap : provinces) {
//			Long pid = (Long) hashMap.get("id");
//			List<HashMap<String, Object>> citys = new CityDao().findCitys(pid);
//			for (HashMap<String, Object> hashMap2 : citys) {
//				Long cid = (Long) hashMap2.get("id");
//				List<HashMap<String, Object>> areas = new AreaDao().findAreas(cid);
//				map2.put(cid,areas);
//			}
//			map.put(pid, citys);
//		}
//		
////		System.out.println(JSONUtil.serialize(map));
//		System.out.println(JSONUtil.serialize(map2));
		
		
	}

}
