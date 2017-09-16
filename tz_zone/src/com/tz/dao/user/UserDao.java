package com.tz.dao.user;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.tz.bean.TzParams;
import com.tz.bean.User;
import com.tz.dao.IDaoFactory;
import com.tz.dao.MybatisConnectionUtil;

public class UserDao implements IDaoFactory<User>{
	

	@Override
	public boolean save(User obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(User obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Integer id,Integer userId) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public User get(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<User> findList(TzParams params) {
		SqlSession session = MybatisConnectionUtil.getSession();
		List<User> users = session.selectList("com.tz.dao.UserDaoMapper.findUsers");
		session.close();
		return users;
	}
	
	public static void main(String[] args) {
		List<User> users = new UserDao().findList(null);
		for (User user : users) {
			System.out.println(user.getUsername());
		}
	}

	@Override
	public List<HashMap<String, Object>> findListByPage(TzParams params) {
		// TODO Auto-generated method stub
		return null;
	}

}
