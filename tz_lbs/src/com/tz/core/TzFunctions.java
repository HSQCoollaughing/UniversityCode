package com.tz.core;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TzFunctions {

	/**
	 * 日期格式化
	 * 方法名：format
	 * 创建人：xuchengfei 
	 * 时间：2016年2月28日-上午12:19:52 
	 * 手机:1564545646464
	 * @param date
	 * @param format
	 * @return String
	 * @exception 
	 * @since  1.0.0
	 */
	public static String format(Date date,String format){
		return new SimpleDateFormat(format).format(date);
	}
	
	
}
