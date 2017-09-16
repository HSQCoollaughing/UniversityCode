/**
 * tzdesk系统平台
 * tz_lbs
 * com.tz.bean
 * User.java
 * 创建人:xuchengfei 
 * 时间：2016年2月19日-上午12:21:44 
 * 2016潭州教育公司-版权所有
 */
package com.tz.bean;


/**
 * 
 * User 创建人:xuchengfei 时间：2016年2月19日-上午12:21:44
 * 
 * @version 1.0.0
 * 
 */
public class City {
	private Integer id;//主键
	private String cityName;//城市名称
	private Integer status;//发布状态0未发布1发布

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
