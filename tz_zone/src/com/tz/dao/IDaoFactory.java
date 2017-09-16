package com.tz.dao;

import java.util.HashMap;
import java.util.List;

import com.tz.bean.TzParams;


public interface IDaoFactory<T> {

	/**
	 * 保存信息
	  * com.tz.dao.IDaoFactory.java 
	  * 方法名：save
	  * 创建人：xuchengfei 
	  * 时间：2016年2月6日下午2:43:59
	  * QQ：761008250
	  * @param params
	  * @return boolean
	  * @exception 
	  * @since  1.0.0
	 */
	public boolean save(T obj);
	
	/**
	 * 更新方法
	  * com.tz.dao.IDaoFactory.java 
	  * 方法名：update
	  * 创建人：xuchengfei 
	  * 时间：2016年2月6日下午2:43:51
	  * QQ：761008250
	  * @param params
	  * @return boolean
	  * @exception 
	  * @since  1.0.0
	 */
	public boolean update(T obj);
	
	/**
	 *  删除信息
	  * com.tz.dao.IDaoFactory.java 
	  * 方法名：delete
	  * 创建人：xuchengfei 
	  * 时间：2016年2月6日下午2:42:32
	  * QQ：761008250
	  * @param params
	  * @return boolean
	  * @exception 
	  * @since  1.0.0
	 */
	public boolean delete(Integer id,Integer userId);
	
	/**
	 *  返回集合信息
	  * com.tz.dao.IDaoFactory.java 
	  * 方法名：findList
	  * 创建人：xuchengfei 
	  * 时间：2016年2月6日下午2:41:13
	  * QQ：761008250
	  * @param params
	  * @return List<?>
	  * @exception 
	  * @since  1.0.0
	 */
	public List<T> findList(TzParams params);
	
	public List<HashMap<String, Object>> findListByPage(TzParams params);
	
	/**
	 *  查询
	 * com.tz.dao.IDaoFactory.java 
	 * 方法名：get
	 * 创建人：xuchengfei 
	 * 时间：2016年2月6日下午2:41:24
	 * QQ：761008250
	 * @param params
	 * @return Object
	 * @exception 
	 * @since  1.0.0 
	 */
	public T get(Integer id);
}
