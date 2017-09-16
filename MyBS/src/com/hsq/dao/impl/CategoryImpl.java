package com.hsq.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.jdbc.TxQueryRunner;

import com.hsq.dao.ICategory;
import com.hsq.dto.Category;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class CategoryImpl implements ICategory {
	private QueryRunner qr = new TxQueryRunner();
	public List<Category> findAllCategory() throws SQLException {
		// TODO Auto-generated method stub
		String sql="select * from t_category";
		List<Category> list = qr.query(sql, new BeanListHandler<Category>(Category.class) );
		
		return list;
	}

}
