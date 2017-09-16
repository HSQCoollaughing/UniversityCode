package com.hsq.dao;

import java.sql.Connection;
import java.util.ArrayList;

import com.hsq.dto.Admin;

public interface IAdminDao {
	/**
	 * 
	 * 查询操作返回一个实体类；
	 * 更新操作返回boolean
	 * @param loginName
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public Admin login(String loginName, String password) throws Exception;
	public void con(Connection con) throws Exception; 
	public ArrayList<Admin> getallAdmininfo()throws  Exception;
	public boolean deleteByid(int id)throws Exception ;
	public boolean AddAdmin(Admin admin) throws Exception;
	public boolean ModifAdmin(Admin admin ) throws Exception;
	public Admin getAdminByid(int id) throws Exception;
}
