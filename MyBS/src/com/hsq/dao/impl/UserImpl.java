package com.hsq.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.itcast.jdbc.TxQueryRunner;

import com.hsq.dao.IUser;
import com.hsq.dto.User;

public class UserImpl implements IUser {
private QueryRunner qr=new TxQueryRunner();
	public User Userlogin(String loginName, String password) throws Exception {
	
		String sql="select * from t_user where loginName=? and password=?";
		User user = qr.query(sql, new BeanHandler<User>(User.class),loginName,password);
		return user;
	}
	public void regist(User user) throws Exception {
		// TODO Auto-generated method stub
		String sql="insert into t_user(uid,loginName,password) values(?,?,?)";
		qr.update(sql,user.getUid(),user.getLoginName(),user.getPassword());
	}
	public boolean ajaxloginName(String loginName) throws Exception {
		// TODO Auto-generated method stub
		/*
		 * count(1)，其实就是计算一共有多少符合条件的行。
1并不是表示第一个字段，而是表示一个固定值。
其实就可以想成表中有这么一个字段，这个字段就是固定值1，count(1)，就是计算一共有多少个1.
同理，count(2)，也可以，得到的值完全一样，count('x')，count('y')都是可以的。一样的理解方式。在你这个语句理都可以使用，返回的值完全是一样的。就是计数。
count(*)，执行时会把星号翻译成字段的具体名字，效果也是一样的，不过多了一个翻译的动作，比固定值的方式效率稍微低一些。
		 * 
		 */
		String sql="select count(1) from t_user where loginName=?";
		Number number = (Number) qr.query(sql, new ScalarHandler(),loginName);
		return number.intValue()==0;//如果为0返回true否则false
	}

}
