package com.tz.dao.comment;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.tz.bean.Comment;
import com.tz.bean.TzParams;
import com.tz.dao.IDaoFactory;
import com.tz.dao.MybatisConnectionUtil;



/**
 * 
 * 评论数据业务层
 * CommentDao.java
 * 创建人:xuchengfei 
 * 时间：2016年2月6日下午2:07:44 
 * @version 1.0.0
 *
 */
public class CommentMybatisDao implements IDaoFactory<Comment>{

	
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
		SqlSession session = MybatisConnectionUtil.getSession();
		List<HashMap<String, Object>> datas = session.selectList("com.tz.dao.CommentMapper.findComments",params);
		session.close();
		return datas;
	}
	
	//mybatis hibernate springjdbctemplate 都是对jdbc的封装
	@Override
	public boolean save(Comment comment) {
		SqlSession session = MybatisConnectionUtil.getSession();
		int count = session.update("com.tz.dao.CommentMapper.saveComment", comment);
		session.close();
		return count>0?true:false;
	}
	
	
	@Override
	public boolean delete(Integer id, Integer userId) {
		SqlSession session = MybatisConnectionUtil.getSession();
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("id", id);
		map.put("userId", userId);
		int count = session.update("com.tz.dao.CommentMapper.updateComment", map);
		session.close();
		return count>0?true:false;
	}

	
	@Override
	public boolean update(Comment obj) {
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
}
