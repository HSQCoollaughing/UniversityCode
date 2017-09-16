package com.tz.dao.comment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.tz.bean.Comment;
import com.tz.bean.TzParams;
import com.tz.dao.ConnectionUtil;
import com.tz.dao.IDaoFactory;
import com.tz.dao.ObjectFactory;


/**
 * 
 * 评论数据业务层
 * CommentDao.java
 * 创建人:xuchengfei 
 * 时间：2016年2月6日下午2:07:44 
 * @version 1.0.0
 *
 */
public class CommentDao implements IDaoFactory<Comment>{

	/**
	  * 保存评论信息 
	  * com.tz.dao.comment.CommentDao.java 
	  * 方法名：saveComment
	  * 创建人：xuchengfei 
	  * 时间：2016年2月6日下午2:27:06
	  * QQ：761008250
	  * @param params
	  * @return boolean
	  * @exception 
	  * @since  1.0.0
	 */
	@Override
	public boolean save(Comment comment){//?
		Connection con = null;
		PreparedStatement stat = null;
		try {
			//获取链接对象
			con = ConnectionUtil.getConnection();
			//处理对象
			String sql = "INSERT INTO tz_comment (title,content,user_id,status,is_delete,sort,tag) VALUES(?,?,?,?,?,?,?)";
			stat = con.prepareStatement(sql);
			stat.setString(1, comment.getTitle());
			stat.setString(2, comment.getContent());
			stat.setInt(3, comment.getUserId());
			stat.setInt(4, comment.getStatus());
			stat.setInt(5, comment.getIsDelete());
			stat.setInt(6, comment.getSort());
			stat.setString(7, comment.getTag());
			//返回处理的结果集，执行成功1，说明数据库更新或者添加成功一条记录了，0代表数据没有要更新或者保存失败，或者删除失败
			int count = stat.executeUpdate();
			return count >0 ?true :false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally{
			ConnectionUtil.closeStatement(stat, con);
		}
	}
	
	/**
	 * 查询所有的评论信息
	 * 方法名：findComments
	 * 创建人：xuchengfei 
	 * 时间：2016年2月13日-上午12:10:55 
	 * 手机:1564545646464
	 * @return List<HashMap<String,Object>>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<HashMap<String, Object>> findListByPage(TzParams params){
		Connection con = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		List<HashMap<String, Object>> datas = null;
		try {
			//获取链接对象
			con = ConnectionUtil.getConnection();
			//处理对象
			String sql = " SELECT "+
			"	tc.id, "+
			"	tc.title, "+
			"	tc.content, "+
			"	tc.create_time, "+
			"	tc.tag, "+
			"	tc.user_id, "+
			"	tu.username, "+
			"	tu.male, "+
			"	tu.sign, "+
			"	tu.header_pic "+
			" FROM "+
			"	tz_comment tc "+
			" LEFT JOIN tz_user tu ON tu.id = tc.user_id "+
			" WHERE "+
			"	tu.is_delete = 0 "+
			" AND tc.is_delete = 0 "+
			" AND tc.user_id in ("+params.getUserIds()+") "+
			" AND tc.`status` = 1  "+
			" ORDER BY tc.create_time desc "+
			" LIMIT ?,?";
			stat = con.prepareStatement(sql);
			stat.setInt(1,Integer.parseInt(params.getPageNo()));
			stat.setInt(2, Integer.parseInt(params.getPageSize()));
			//返回结果集
			rs = stat.executeQuery();
			datas = new ArrayList<HashMap<String, Object>>();
			HashMap<String, Object> map= null;
			while(rs.next()){//单个就是if
				map = new HashMap<String,Object>();
				map.put("id", rs.getInt("id"));
				map.put("title", rs.getString("title"));
				map.put("content", rs.getString("content"));
				map.put("createTime", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(rs.getTimestamp("create_time").getTime())));
				map.put("tag", rs.getString("tag"));
				map.put("userId", rs.getInt("user_id"));
				map.put("username", rs.getString("username"));
				map.put("male", rs.getInt("male"));
				map.put("sign", rs.getString("sign"));
				map.put("headerPic", rs.getString("header_pic"));
				datas.add(map);
			}
			return datas;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally{
			ConnectionUtil.closeResultSet(rs, stat, con);
		}
	}
	
	
	@Override
	public boolean delete(Integer id,Integer userId) {
		Connection con = null;
		PreparedStatement stat = null;
		try {
			//获取链接对象
			con = ConnectionUtil.getConnection();
			//处理对象--关于修改和删除语句，不允许使用逻辑判断的去共用
			//String sql = "UPDATE tz_comment SET is_delete = 1 WHERE id = ? and user_id=? ";
			String sql = "UPDATE tz_comment SET is_delete = 1 WHERE id = ?";
			stat = con.prepareStatement(sql);
			stat.setInt(1, id);
			//返回处理的结果集，执行成功1，说明数据库更新或者添加成功一条记录了，0代表数据没有要更新或者保存失败，或者删除失败
			int count = stat.executeUpdate();
			return count >0 ?true :false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally{
			ConnectionUtil.closeStatement(stat, con);
		}
	}


	@Override
	public boolean update(Comment comment) {
		// TODO Auto-generated method stub
		return false;
	}

	

	@Override
	public List<Comment> findList(TzParams params) {
		return null;
	}

	@Override
	public Comment get(Integer id) {
		return null;
	}
	
	
	
	public static void main(String[] args) {
//		IDaoFactory commentDao = ObjectFactory.getInstance("commentDao");
//		System.out.println(commentDao);
		IDaoFactory<Comment> commentDao = ObjectFactory.getInstance(CommentDao.class);
		
		commentDao.delete(2, null);
//		Comment comment = new Comment();
//		comment.setTitle("234水电费水电费水电费23423");
//		comment.setContent("323423是的发送到423");
//		comment.setUserId(1);
//		comment.setStatus(1);
//		comment.setIsDelete(0);
//		comment.setSort(0);
//		comment.setTag("java ,javascript");
//		boolean flag = commentDao.save(comment);
//		System.out.println(flag?"保存成功":"保存失败");
		
//		TzParams params = new TzParams();
//		params.setUserIds("1,2");
//		params.setPageNo("0");
//		params.setPageSize("10");
//		List<HashMap<String, Object>> datas = commentDao.findListByPage(params);
//		for (HashMap<String, Object> hashMap : datas) {
//			System.out.println(hashMap);
//			System.out.println("========================");
//			
//		}
		
		
		
	}
	
}
