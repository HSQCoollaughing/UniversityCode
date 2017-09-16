package com.tz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.json.JSONException;

import com.tz.bean.Hotel;
import com.tz.util.TmStringUtils;

public class HotelDao {

	
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
	public List<Hotel> findHotels(Integer pid,String keyword,Integer pageNo,Integer pageSize) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		List<Hotel> hotels = null;
		try {
			StringBuilder builder = new StringBuilder();
			builder.append(" SELECT h.id,h.`level`,h.name,h.img,h.icon,h.gd,h.wd,h.city_id,c.province FROM tz_hotel h LEFT JOIN tm_province c ON c.id = h.city_id WHERE is_delete = 0 AND `status` = 1 ");
			if(pid!=null){
				builder.append(" and h.city_id = "+pid);	
			}
			
			if(TmStringUtils.isNotEmpty(keyword)){
				builder.append(" and h.name like '%"+keyword+"%'");
			}
			
			builder.append(" ORDER BY h.create_time DESC LIMIT ?,? ");
			
			System.out.println(builder.toString());
			//获取链接对象
			connection = ConnectionUtil.getConnection();
			//处理对象
			statement = connection.prepareStatement(builder.toString());
			statement.setInt(1, pageNo);
			statement.setInt(2, pageSize);
			//返回结果集
			rs = statement.executeQuery();
			//遍历结果集
			hotels = new ArrayList<Hotel>();//jdk7出现了一种菱形泛型
			Hotel hotel = null;
			while (rs.next()) {
				 hotel = new Hotel();
				 hotel.setId(rs.getInt("id"));
				 hotel.setLevel(rs.getFloat("level"));
				 hotel.setName(rs.getString("name"));
				 hotel.setImg(rs.getString("img"));
				 hotel.setIcon(rs.getString("icon"));
				 hotel.setGd(rs.getString("gd"));
				 hotel.setWd(rs.getString("wd"));
				 hotel.setCityId(rs.getInt("city_id"));
				 hotel.setPname(rs.getString("province"));
				 hotels.add(hotel);
			}
			return hotels;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			ConnectionUtil.closeResultSet(rs, statement, connection);
		}
	}
	
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
	public Hotel getHotel(Integer hotelId){
		//想着和keke老师打电话
		//第一步：connection
		Connection connection = null;
		//第二步 执行sql
		PreparedStatement statement = null;
		//第三步：返回信息
		ResultSet rs = null;
		//返回值
		Hotel hotel = null;
		try {
			//连接初始化
			connection = ConnectionUtil.getConnection();
			String sql = "SELECT id,name,level,img,address,description,telephone from tz_hotel WHERE id = ?";
			//处理对象
			statement = connection.prepareStatement(sql);
			statement.setInt(1, hotelId);
			//返回一个结构集
			rs = statement.executeQuery();
			if(rs.next()){//rs.next()游标
				hotel = new Hotel();
				hotel.setId(rs.getInt("id"));
				hotel.setName(rs.getString("name"));
				hotel.setLevel(rs.getFloat("level"));
				hotel.setImg(rs.getString("img"));
				hotel.setDescription(rs.getString("description"));
				hotel.setTelephone(rs.getString("telephone"));
			}
			return hotel;
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
		
//		Hotel hotel = new HotelDao().getHotel(1);
//		System.out.println(JSONUtil.serialize(hotel,null,null,true,true));
	}
}
