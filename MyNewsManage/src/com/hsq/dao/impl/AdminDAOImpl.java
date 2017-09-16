package com.hsq.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hsq.dao.IAdminDao;
import com.hsq.db.DataBase;
import com.hsq.dto.Admin;

public class AdminDAOImpl implements IAdminDao {
Connection con=null;
PreparedStatement ps=null;

ResultSet rs=null;
ArrayList<Admin> Adminlis;


	@Override
	public Admin login(String loginName, String password) throws Exception {
		// TODO Auto-generated method stub
		Admin admin=null;
		String sql="select * from admin where LoginName=? and password=?";
		ps=	con.prepareStatement(sql);
	
	ps.setString(1, loginName);
	ps.setString(2, password);//方便sql语句的书写
	
	rs=	ps.executeQuery();
	if(rs.next()){//判断结果集rs是否有记录，并且将指针后移一位
	admin=	new Admin();
	admin.setId(rs.getInt("id"));
		admin.setLoginName(rs.getString("LoginName"));
	admin.setPassword(rs.getString("password"));
	}
		return admin;
	}

	@Override
	public void con(Connection con) throws Exception {
		// TODO Auto-generated method stub
		this.con=con;
	}

	@Override
	public ArrayList<Admin> getallAdmininfo() throws Exception {
		// TODO Auto-generated method stub
		Adminlis=new ArrayList<Admin>();
		Admin admin=null;
		String sql="select * from admin ";
		ps=	con.prepareStatement(sql);
		
		
		rs=	ps.executeQuery();
		while(rs.next()){
		admin=	new Admin();
		admin.setId(rs.getInt("id"));
			admin.setLoginName(rs.getString("LoginName"));
		admin.setPassword(rs.getString("password"));
		Adminlis.add(admin);
		
	}
		
		return Adminlis;
	}

	@Override
	public boolean deleteByid(int id) throws Exception {
		// TODO Auto-generated method stub
		String sql="delete from admin where id=?  ";
		int result;
		boolean flag=false;
		ps=con.prepareStatement(sql);
		ps.setInt(1, id);
		result=ps.executeUpdate();
		if (result>0) {
			flag=true;
		}
		return flag;
	}

	@Override
	public boolean AddAdmin(Admin admin) throws Exception {
		// TODO Auto-generated method stub
		String sql="insert into admin ( LoginName,password,imagePath) values(?,?,?)   ";
		con=DataBase.getConn();
		ps=con.prepareStatement(sql);
		//String sql="insert into admin ( LoginName,password) values(?,?)   ";
	
		ps.setString(1, admin.getLoginName());
		ps.setString(2, admin.getPassword());
		ps.setString(3, admin.getImagePath());
		boolean flag=false;
		
		int result=0;
		result=ps.executeUpdate();
		DataBase.commit();
		if (result>0) {
			return true;
			
		}
		return flag;
		
	}

	@Override
	public boolean ModifAdmin(Admin admin ) throws Exception {
		// TODO Auto-generated method stub
		String sql="update admin set LoginName=? , password=? , imagePath=?  where id=?";
		con=DataBase.getConn();
		ps=con.prepareStatement(sql);
		
		ps.setString(1, admin.getLoginName());
		ps.setString(2, admin.getPassword());
		ps.setString(3, admin.getImagePath());
		ps.setInt(4,admin.getId());
		
boolean flag=false;
		
		int result=0;
		result=ps.executeUpdate();
		DataBase.commit();
		if (result>0) {
			return true;
			
		}
		return flag;
	}

	@Override
	public Admin getAdminByid(int id) throws Exception {
		// TODO Auto-generated method stub
		Admin admin=null;
		String sql="select * from admin where id=? ";
	ps=	con.prepareStatement(sql);
	
	ps.setInt(1, id);
	//方便sql语句的书写
	rs=	ps.executeQuery();
	if(rs.next()){
	admin=	new Admin();
	admin.setId(rs.getInt("id"));
		admin.setLoginName(rs.getString("LoginName"));
	admin.setPassword(rs.getString("password"));
	admin.setImagePath(rs.getString("imagePath"));
	}
		return admin;
	}

	

	
}
