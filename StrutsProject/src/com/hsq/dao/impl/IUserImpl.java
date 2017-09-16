package com.hsq.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.jws.soap.SOAPBinding.Use;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.lang3.StringUtils;

import com.hsq.bean.User;
import com.hsq.dao.IUser;
import com.hsq.db.JNDIUtil;

public class IUserImpl implements IUser {
	private QueryRunner qr = new QueryRunner(JNDIUtil.getDataSource());

	public User login(String loginName, String password) {
		try{
			return qr.query("select * from t_user where logonName=? and logonPwd=? ", new BeanHandler<User>(User.class),loginName,password);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}

	public User findByID(int id) {
		try{
			return qr.query("select * from t_user where userID = ? ", new BeanHandler<User>(User.class),id);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}

	public List<User> findAllUser() {
		try{
			return qr.query("select * from t_user ", new BeanListHandler<User>(User.class));
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}

	public List<User> findByCondition(String userName, String isUpload,
			String gender, String eduction) {
		if (StringUtils.isBlank(eduction)&&StringUtils.isBlank(gender)&&StringUtils.isBlank(isUpload)&&StringUtils.isBlank(userName)) {
			return findAllUser();
		}else {
			String sql="select * from t_user ";
			StringBuffer sb = new StringBuffer(sql);
			sb.append("where 1=1 ");
			List<Object> param=new ArrayList<Object>();
			if (StringUtils.isNotBlank(userName)) {
				
				sb.append("and userName like  ?");
				
				param.add("%"+userName+"%");
			}
			
			if (StringUtils.isNotBlank(isUpload)) {
				if("true".equals(isUpload)){
					sb.append(" and filename is not null ");//数据库中判断是否为null 不能用!=  =。用的是is not  /is
				}else{
					sb.append(" and filename is null ");
				}
			}
			if (StringUtils.isNotBlank(gender)) {
				sb.append(" and  gender= ?");
				param.add(gender);
			}
			if (StringUtils.isNotBlank(eduction)) {
				sb.append(" and education= ?");
				param.add(eduction);
			}
			String newsql = sb.toString();
			try {
				return qr.query(newsql, new BeanListHandler<User>(User.class),param.toArray());
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		
		
		
	}


	public int AddUser(User user) {
		try{
			return qr.update("insert into t_user(userID,userName,logonName,logonPwd,gender,birthday,education,telephone,hobby,path,filename,remark)values(?,?,?,?,?,?,?,?,?,?,?,?)",
					user.getUserID(),user.getUserName(),user.getLogonName(),user.getLogonPwd(),user.getGender(),user.getBirthday(),user.getEducation(),user.getTelephone(),
					user.getHobby(),user.getPath(),user.getFilename(),user.getRemark());
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}

	public int updateUser(User user) {
		try{
			return qr.update("update t_user set userName=?,logonName=?,logonPwd=?,gender=?,birthday=?,education=?,telephone=?,hobby=?,path=?,filename=?,remark=? where userID = ?",
					user.getUserName(),user.getLogonName(),user.getLogonPwd(),user.getGender(),user.getBirthday(),user.getEducation(),user.getTelephone(),
					user.getHobby(),user.getPath(),user.getFilename(),user.getRemark(),user.getUserID());
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}

	public int deleteByID(Integer id) {
		try{
			return qr.update("delete from t_user where userID = ?",id);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}

}
