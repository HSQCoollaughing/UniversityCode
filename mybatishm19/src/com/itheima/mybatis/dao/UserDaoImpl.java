package com.itheima.mybatis.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.itheima.mybatis.po.User;

/**
 *  
 * <p>
 * Title: UserDaoImpl
 * </p>
 *  
 * <p>
 * Description: TODO(这里用一句话描述这个类的作用) 
 * <p>
 * <p>
 * Company: www.itcast.com
 * </p>
 *  @author 传智.关云长   @date 2015-12-21 下午2:46:23    @version 1.0
 */
public class UserDaoImpl implements UserDao {

	// 依赖注入
	private SqlSessionFactory sqlSessionFactory;

	public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public User findUserById(int id) throws Exception {
		// 创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 调用SqlSession的增删改查方法
		// 第一个参数：表示statement的唯一标示
		User user = sqlSession.selectOne("test.findUserById", id);
		System.out.println(user);
		// 关闭资源
		sqlSession.close();
		return user;
	}

	@Override
	public List<User> findUsersByName(String name) {
		// 创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// 调用SqlSession的增删改查方法
		// 第一个参数：表示statement的唯一标示
		List<User> list = sqlSession.selectOne("test.findUsersByName", name);
		System.out.println(list);
		// 关闭资源
		sqlSession.close();
		return list;
	}

	@Override
	public void insertUser(User user) {
		// 创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// 调用SqlSession的增删改查方法
		// 第一个参数：表示statement的唯一标示
		sqlSession.insert("test.insertUser", user);

		System.out.println(user.getId());
		// 提交事务
		sqlSession.commit();
		// 关闭资源
		sqlSession.close();
	}

}
