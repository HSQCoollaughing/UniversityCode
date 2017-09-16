package com.itheima.mybatis.mapper;

import java.util.List;

import com.itheima.mybatis.po.User;
import com.itheima.mybatis.po.UserQueryVO;

/**
 *  
 * <p>
 * Title: UserMapper
 * </p>
 *  
 * <p>
 * Description: TODO(这里用一句话描述这个类的作用) 
 * <p>
 * <p>
 * Company: www.itcast.com
 * </p>
 *  @author 传智.关云长   @date 2015-12-21 下午3:16:06    @version 1.0
 */
public interface UserMapper {
	// 1、 根据用户ID查询用户信息
	public User findUserById(int id) throws Exception;

	// 3、 添加用户
	public void insertUser(User user) throws Exception;
	
	//综合查询
	public List<User> findUserList(UserQueryVO vo);
	
	//综合查询用户总数
	public int findUserCount(UserQueryVO vo);
	
	//resultMap入门
	public User findUserRstMap(int id);
}
