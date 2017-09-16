package com.itheima.mybatis.mapper;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.itheima.mybatis.po.User;
import com.itheima.mybatis.po.UserQueryVO;

/**
 *  
 * <p>
 * Title: UserMapperTest
 * </p>
 *  
 * <p>
 * Description: TODO(这里用一句话描述这个类的作用) 
 * <p>
 * <p>
 * Company: www.itcast.com
 * </p>
 *  @author 传智.关云长   @date 2015-12-21 下午3:21:55    @version 1.0
 */
public class UserMapperTest {

	private SqlSessionFactory sqlSessionFactory;

	@Before
	public void setUp() throws Exception {
		// 读取配置文件
		// 全局配置文件的路径
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);

		// 创建SqlSessionFactory
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Test
	public void testFindUserById() throws Exception {
		// 创建UserMapper对象
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// 由mybatis通过sqlsession来创建代理对象
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);

		User user = mapper.findUserById(1);

		System.out.println(user);

		sqlSession.close();

	}

	@Test
	public void testInsertUser() throws Exception {
		// 创建UserMapper对象
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// 由mybatis通过sqlsession来创建代理对象
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);

		User user = new User();
		user.setUsername("东哥hm19");
		user.setAddress("宝盛西里24号楼");

		mapper.insertUser(user);

		System.out.println(user.getId());

		sqlSession.commit();

		sqlSession.close();

	}

	@Test
	public void testFindUserList() throws Exception {
		// 创建UserMapper对象
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 由mybatis通过sqlsession来创建代理对象
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);

		UserQueryVO vo = new UserQueryVO();
		// User user= new User();
		// user.setUsername("东哥");
		// user.setSex("1");
		// vo.setUser(user);
		
		List<Integer> idList = new ArrayList<Integer>();
		idList.add(1);
		idList.add(2);
		idList.add(10);
		
		vo.setIdList(idList);

		List<User> list = mapper.findUserList(vo);
		int count = mapper.findUserCount(vo);

		System.out.println(list);
		System.out.println(count);
		sqlSession.close();
	}

	@Test
	public void testFindUserRstMap() throws Exception {
		// 创建UserMapper对象
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 由mybatis通过sqlsession来创建代理对象
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);

		User user = mapper.findUserRstMap(1);
		System.out.println(user);
		sqlSession.close();
	}

}
