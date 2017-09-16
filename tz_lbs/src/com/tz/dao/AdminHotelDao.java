package com.tz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.struts2.json.JSONException;

import com.tz.bean.Hotel;
import com.tz.bean.TzParams;
import com.tz.util.TmStringUtils;

public class AdminHotelDao extends BaseDao{

	
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
	public List<Hotel> findHotels(TzParams params) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		List<Hotel> hotels = null;
		try {
			StringBuilder builder = new StringBuilder();
			builder.append(" SELECT h.id,h.`level`,h.name,h.img,h.icon,h.gd,h.wd,h.city_id,c.province,h.status,h.is_delete,h.create_time FROM tz_hotel h LEFT JOIN tm_province c ON c.id = h.city_id WHERE 1=1 ");

			if(params.getIsDelete()!=null){
				builder.append(" and  is_delete = "+params.getIsDelete());
			}
			
			if(params.getStatus()!=null){
				builder.append(" and  `status` = "+params.getStatus());
			}
			
			if(params.getPid()!=null){
				builder.append(" and h.city_id = "+params.getPid());	
			}
			
			if(TmStringUtils.isNotEmpty(params.getKeyword())){
				builder.append(" and h.name like '%"+params.getKeyword()+"%'");
			}
			
			builder.append(" ORDER BY h.create_time DESC LIMIT ?,? ");
			
			System.out.println(builder.toString());
			//获取链接对象
			connection = ConnectionUtil.getConnection();
			//处理对象
			statement = connection.prepareStatement(builder.toString());
			statement.setInt(1, params.getPageNo());
			statement.setInt(2, params.getPageSize());
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
				 hotel.setCreateTime(new Date(rs.getTimestamp("create_time").getTime()));//不要在这里处理日期格式----hibernate mybatis 都数据类型转换
				 hotel.setStatus(rs.getInt("status"));
				 hotel.setIsDelete(rs.getInt("is_delete"));
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
			String sql = "SELECT id,name,level,img,address,description,telephone,gd,wd,status,city_id,icon from tz_hotel WHERE id = ?";
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
				hotel.setGd(rs.getString("gd"));
				hotel.setWd(rs.getString("wd"));
				hotel.setStatus(rs.getInt("status"));
				hotel.setCityId(rs.getInt("city_id"));
				hotel.setIcon(rs.getString("icon"));
				hotel.setAddress(rs.getString("address"));
			}
			return hotel;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally{
			ConnectionUtil.closeResultSet(rs, statement, connection);
		}
	}
	
	/**
	 * 求总数
	 * com.tz.dao 
	 * 方法名：countHotels
	 * 创建人：xuchengfei 
	 * 手机号码:15074816437
	 * 时间：2016年2月24日-上午12:34:50 
	 * @param params
	 * @return 
	 * 返回类型：int
	 * @exception 
	 * @since  1.0.0
	 */
	public int countHotels(TzParams params) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			StringBuilder builder = new StringBuilder();
			builder.append(" SELECT count(1) FROM tz_hotel h LEFT JOIN tm_province c ON c.id = h.city_id WHERE 1=1 ");

			if(params.getIsDelete()!=null){
				builder.append(" and  is_delete = "+params.getIsDelete());
			}
			
			if(params.getStatus()!=null){
				builder.append(" and  `status` = "+params.getStatus());
			}
			
			if(params.getPid()!=null){
				builder.append(" and h.city_id = "+params.getPid());	
			}
			
			if(TmStringUtils.isNotEmpty(params.getKeyword())){
				builder.append(" and h.name like '%"+params.getKeyword()+"%'");
			}
			//获取链接对象
			connection = ConnectionUtil.getConnection();
			//处理对象
			statement = connection.prepareStatement(builder.toString());
			//返回结果集
			rs = statement.executeQuery();
			//遍历结果集
			int count = 0;
			if(rs.next()){
				count = rs.getInt(1);
			}
			return count;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			ConnectionUtil.closeResultSet(rs, statement, connection);
		}
	}
	
	
	
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
	public boolean saveHotal(Hotel hotel){
		//想着和keke老师打电话
		//第一步：connection
		Connection connection = null;
		//第二步 执行sql
		PreparedStatement statement = null;
		try {
			//连接初始化
			connection = ConnectionUtil.getConnection();
			String sql = "INSERT INTO tz_hotel(name,level,description,gd,wd,address,img,telephone,city_id,is_delete,status,user_id,icon)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
			System.out.println("执行的sql是:"+sql);
			//处理对象
			statement = connection.prepareStatement(sql);
			statement.setString(1, hotel.getName());
			statement.setFloat(2, hotel.getLevel());
			statement.setString(3, hotel.getDescription());
			statement.setString(4, hotel.getGd());
			statement.setString(5, hotel.getWd());
			statement.setString(6, hotel.getAddress());
			statement.setString(7, hotel.getImg());
			statement.setString(8, hotel.getTelephone());
			statement.setInt(9, hotel.getCityId());
			statement.setInt(10, hotel.getIsDelete());
			statement.setInt(11, hotel.getStatus());
			statement.setInt(12, hotel.getUserId());
			statement.setString(13, hotel.getIcon());
			int count = statement.executeUpdate();
			return count>0?true:false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally{
			ConnectionUtil.closeStatement(statement, connection);
		}
	}
	
	
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
	public boolean updateHotal(Hotel hotel){
		//想着和keke老师打电话
		//第一步：connection
		Connection connection = null;
		//第二步 执行sql
		PreparedStatement statement = null;
		try {
			//连接初始化
			connection = ConnectionUtil.getConnection();
			String sql = getUpdateSql("tz_hotel", hotel.getId(), hotel);
			System.out.println(sql);
			statement = connection.prepareStatement(sql);
			int count = statement.executeUpdate();
			return count>0?true:false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally{
			ConnectionUtil.closeStatement(statement, connection);
		}
	}
	
	
	
	public static void main(String[] args) throws JSONException {
//		List<Hotel> hotels = new HotelDao().findHotels(310000,"yu",0, 10);
//		System.out.println(JSONUtil.serialize(hotels));
		
//		Hotel hotel = new AdminHotelDao().getHotel(1);
//		System.out.println(JSONUtil.serialize(hotel,null,null,true,true));
		
//		TzParams params = new TzParams();
//		params.setIsDelete(0);
//		params.setStatus(1);
//		params.setPid(110000);
//		params.setKeyword("keke");
//		StringBuilder builder = new StringBuilder();
//		builder.append(" SELECT h.id,h.`level`,h.name,h.img,h.icon,h.gd,h.wd,h.city_id,c.province FROM tz_hotel h LEFT JOIN tm_province c ON c.id = h.city_id WHERE 1 = 1  ");
//
//		if(params.getIsDelete()!=null){
//			builder.append(" and  is_delete = "+params.getIsDelete());
//		}
//		
//		if(params.getStatus()!=null){
//			builder.append(" and  `status` = "+params.getStatus());
//		}
//		
//		if(params.getPid()!=null){
//			builder.append(" and h.city_id = "+params.getPid());	
//		}
//		
//		if(TmStringUtils.isNotEmpty(params.getKeyword())){
//			builder.append(" and h.name like '%"+params.getKeyword()+"%'");
//		}
//		
//		builder.append(" ORDER BY h.create_time DESC LIMIT ?,? ");
//		Hotel hotel = new Hotel();
//		hotel.setLevel(3f);
//		hotel.setName("keke");
//		System.out.println(getUpdateSql("tz_hotel",1,hotel));
		
//		User user = new User();
//		user.setUsername("keke");
//		user.setPassword("23423keke");
//		System.out.println(getUpdateSql("tz_user", 1, user));
		
		Hotel hotel =new Hotel();
		hotel.setId(1);
		hotel.setName("sdfsdfsdfsdfsd");
		hotel.setAddress("ddddddddddddddddddd");
		hotel.setUpdateTime(new Date());
		Boolean flag = new AdminHotelDao().updateHotal(hotel);
		System.out.println(flag);
		
		
		
	}
	
	
	
	
}
