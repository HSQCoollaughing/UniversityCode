package com.hsq.dao;

import java.sql.Connection;
import java.util.ArrayList;

import com.hsq.dto.Admin;
import com.hsq.dto.News;



public interface INewsDAO {
	public void con(Connection con) throws Exception; 
	public ArrayList<News> getallNewsinfo()throws  Exception;
	public News getNewsByid(int id) throws Exception;
	public boolean AddNews(News news) throws Exception;
	public boolean ModifNews(News news ) throws Exception;
	public boolean deleteByid(int id)throws Exception ;
	public boolean  updateCount(News news)throws Exception;
	public boolean UpdateCountByid(int id, int  count);
}
