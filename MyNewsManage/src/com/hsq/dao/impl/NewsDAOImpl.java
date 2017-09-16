package com.hsq.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.hsq.dao.INewsDAO;
import com.hsq.db.DataBase;
import com.hsq.dto.Admin;
import com.hsq.dto.News;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Text;

public class NewsDAOImpl implements INewsDAO {

	Connection con=null;
	PreparedStatement ps=null;

	ResultSet rs=null;
	ArrayList<News> Newslis;
	@Override
	public void con(Connection con) throws Exception {
		// TODO Auto-generated method stub
		this.con=con;
	}

	@Override
	public ArrayList<News> getallNewsinfo() throws Exception {
		// TODO Auto-generated method stub
		Newslis=new ArrayList<News>();
		News news=null;
		String sql="select * from newscontent ";
		ps=	con.prepareStatement(sql);
		
		
		rs=	ps.executeQuery();
		while(rs.next()){
			news=	new News();
		news.setId(rs.getInt("id"));
		news.setTitle(rs.getString("title"));
		news.setCount(rs.getInt("count"));
		news.setAuthor(rs.getString("author"));
		news.setContent(rs.getString("content"));
		news.setSendTime(rs.getDate("sendTime"));
		

		Newslis.add(news);
	}
		
		return Newslis;
	}

	@Override
	public News getNewsByid(int id) throws Exception {
		// TODO Auto-generated method stub
			News news=null;
		String sql="select * from newscontent where id=? ";
	ps=	con.prepareStatement(sql);
	
	ps.setInt(1, id);
	//·½±ãsqlÓï¾äµÄÊéÐ´
	rs=	ps.executeQuery();
	if(rs.next()){
		news=	new News();
		news.setId(rs.getInt("id"));
		news.setTitle(rs.getString("title"));
		news.setCount(rs.getInt("count"));
		news.setAuthor(rs.getString("author"));
		news.setContent(rs.getString("content"));
		news.setSendTime(rs.getDate("sendTime"));
	}
		return news;
	}

	@Override
	public boolean AddNews(News news) throws Exception {
		// TODO Auto-generated method stub
		String sql="insert into newscontent ( title,count,author,content,sendTime) values(?,?,?,?,?)   ";
		con=DataBase.getConn();
		ps=con.prepareStatement(sql);
		//String sql="insert into admin ( LoginName,password) values(?,?)   ";
	
		ps.setString(1, news.getTitle());
		ps.setInt(2, news.getCount());
		ps.setString(3, news.getAuthor());
		ps.setString(4, news.getContent());
		
		ps.setDate(5,  new java.sql.Date(news.getSendTime().getTime()));
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
	public boolean ModifNews(News news) throws Exception {
		// TODO Auto-generated method stub
		String sql="update newscontent set title=? ,  author=? , content=? , count=?  where id=?";
		con=DataBase.getConn();
		ps=con.prepareStatement(sql);
		
		ps.setString(1, news.getTitle());
		ps.setString(2, news.getAuthor());
		ps.setString(3, news.getContent());
		ps.setInt(4, news.getCount());
		ps.setInt(5,news.getId());
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
	public boolean deleteByid(int id) throws Exception {
		// TODO Auto-generated method stub
		String sql="delete from newscontent where id=?  ";
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
	public boolean updateCount(News news) throws Exception {
		// TODO Auto-generated method stub
		String sql="update  newscontent set count=?  where id=?";
		con=DataBase.getConn();
		ps=con.prepareStatement(sql);
		
		ps.setInt(1, news.getCount()+1);
		ps.setInt(2, news.getId());
boolean flag=false;
		
		int result=0;
		result=ps.executeUpdate();
		DataBase.commit();
		if (result>0) {
			return true;
			
		}
		return  flag;
		
	}

	@Override
	public boolean UpdateCountByid(int id, int count) {
		// TODO Auto-generated method stub
		String sql="update  newscontent set count=?  where id=?";
		
		try {
			con=DataBase.getConn();
			ps=con.prepareStatement(sql);
			
			ps.setInt(1, count+1);
			ps.setInt(2, id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
boolean flag=false;
		
		int result=0;
		try {
			result=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DataBase.commit();
		if (result>0) {
			return true;
			
		}
		return  flag;
	}

	
	
	

}
