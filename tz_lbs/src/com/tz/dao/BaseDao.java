package com.tz.dao;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;

import com.tz.util.TmStringUtils;

public class BaseDao {
	
	/**
	 * 
	 * 方法名：getUpdateSql
	 * 创建人：xuchengfei 
	 * 时间：2016年2月28日-上午1:21:55 
	 * 手机:1564545646464
	 * @param tabName
	 * @param id
	 * @param obj
	 * @return String
	 * @exception 
	 * @since  1.0.0
	 */
	public static String getUpdateSql(String tabName, Integer id, Object obj) {
		try {
			Class clz = obj.getClass();
			Field[] fields = clz.getDeclaredFields();
			String sql = "update " + tabName + " set ";
			for (Field field : fields) {
				Method method = clz.getMethod("get"
						+ getMethod(field.getName()));
				Object object = method.invoke(obj);
				if (object != null && !field.getName().equalsIgnoreCase("id")) {
					String value = String.valueOf(object);
					if (TmStringUtils.isNotEmpty(value)) {
						if(field.getType().getName().indexOf("Date")!=-1){
							sql += getField(field.getName()) + "='" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(object) + "',";
						}else{
							sql += getField(field.getName()) + "='" + value + "',";
						}
					}
				}
			}
			sql = sql.substring(0, sql.length() - 1);
			sql = sql + " where id = " + id;
			return sql.indexOf("update " + tabName + " set where") != -1 ? null
					: sql;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String getField(String name) {
		return name.replaceAll("([A-Z])", "_$1").toLowerCase();
	}

	public static String getMethod(String name) {
		return name.substring(0, 1).toUpperCase() + name.substring(1);
	}
}
