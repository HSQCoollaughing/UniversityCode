package com.hsq.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.hsq.dao.IAdminDao;
import com.hsq.dao.impl.AdminDAOImpl;
import com.hsq.db.DataBase;
import com.hsq.dto.Admin;

public class AdminServices {
	IAdminDao adao=new AdminDAOImpl();
private	Connection con=null;
ArrayList<Admin> Adminlis;
	public Admin login (String loginName ,String password){
		Admin admin=null;
		try {
			con=DataBase.getConn();
			adao.con(con);
		admin=	adao.login(loginName, password);
		con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return admin;
		
	}
 public ArrayList<Admin> allAdmininfo(){
	 try {
			con=DataBase.getConn();
			adao.con(con);
			Adminlis=	adao.getallAdmininfo();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 try {
		 
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return Adminlis;
	 
 }
 public boolean deletebyID(int id) {
	boolean flag=false; 
	try {
		con=DataBase.getConn();
		adao.con(con);
	flag=adao.deleteByid(id);
	con.commit();
	con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return flag;
	 
	 
 }
 public boolean AddAdmin(Admin admin){
	 boolean flag=false; 
	 try {
			con=DataBase.getConn();
			adao.con(con);
		flag=adao.AddAdmin(admin);
		con.commit();
		con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return flag;
	 
	 
	 
 }
 public boolean modifAdmin(Admin admin ){
	 boolean flag=false; 
	 try {
			con=DataBase.getConn();
			adao.con(con);
	flag=	adao.ModifAdmin(admin);
		con.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return flag;
	 
	 
	 
 }
 public Admin getAdminByid(int id){
	 Admin admin=null;
		try {
			con=DataBase.getConn();
			adao.con(con);
		admin=	adao.getAdminByid(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return admin;
	 
 }
}
