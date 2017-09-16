package com.itheima.mybatis.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.itheima.mybatis.po.User;

/**
 *  
 * <p>
 * Title: UserDao
 * </p>
 *  
 * <p>
 * Description: TODO(这里用一句话描述这个类的作用) 
 * <p>
 * <p>
 * Company: www.itcast.com
 * </p>
 *  @author 传智.关云长   @date 2015-12-21 下午2:44:34    @version 1.0
 */
public interface UserDao {
	// 1、 根据用户ID查询用户信息
	public User findUserById(int id) throws Exception;

	// 2、 根据用户名称模糊查询用户列表
	public List<User> findUsersByName(String name) throws Exception;

	// 3、 添加用户
	public void insertUser(User user) throws Exception;

}
