package com.hsq.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.hsq.dao.INewsDAO;
import com.hsq.dao.impl.NewsDAOImpl;
import com.hsq.db.DataBase;
import com.hsq.dto.Admin;
import com.hsq.dto.News;



public class NewsServices {
	private	Connection con=null;
	ArrayList<News> Newslis;
	INewsDAO indao =new NewsDAOImpl();
	public ArrayList<News> allNewsinfo(){
		 try {
				con=DataBase.getConn();
				indao.con(con);
				Newslis=	indao.getallNewsinfo();
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
		return Newslis;
		 
	 }
	public News getNewsByid(int id){
		News news=null;
			try {
				con=DataBase.getConn();
				indao.con(con);
			news=	indao.getNewsByid(id);
			indao.updateCount(news);
			//System.out.println("¸üÐÂcount");
			con.commit();
			con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return news;
		 
	 }
	 public boolean AddNews(News news){
		 boolean flag=false; 
		 try {
				con=DataBase.getConn();
				indao.con(con);
			flag=indao.AddNews(news);
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
	 public boolean modifNews(News news ){
		 boolean flag=false; 
		 try {
				con=DataBase.getConn();
				indao.con(con);
		flag=	indao.ModifNews(news);
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
	 public boolean deletebyID(int id) {
			boolean flag=false; 
			try {
				con=DataBase.getConn();
				indao.con(con);
			flag=indao.deleteByid(id);
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
	public boolean UpdateCountByid(int id, int count) {
		// TODO Auto-generated method stub
		 boolean flag=false; 
		 try {
				con=DataBase.getConn();
				indao.con(con);
			flag=indao.UpdateCountByid(id, count);
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
}
