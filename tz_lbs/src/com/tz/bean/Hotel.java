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

import java.util.Date;

/**
 * 
 * Hotel 
 * 创建人:xuchengfei 
 * 时间：2016年2月19日-上午12:21:44
 * 
 * @version 1.0.0
 * 
 */
public class Hotel {

	private Integer id;//主键
	private String name;//酒店名称
	private String description;//酒店描述
	private String gd;//经度
	private String wd;//纬度
	private String address;//地址
	private String img;//封面图
	private String telephone;//酒店联系电话
	private Float level;//级别
	private Integer cityId;//城市
	private String pname;//城市名
	private Integer userId;//酒店创始人
	private Integer status;//0未发布1发布
	private Date createTime;//创建时间
	private Date updateTime;//更新时间
	private Integer isDelete;//删除状态0未删除1删除
	private String icon;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getGd() {
		return gd;
	}

	public void setGd(String gd) {
		this.gd = gd;
	}

	public String getWd() {
		return wd;
	}

	public void setWd(String wd) {
		this.wd = wd;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Float getLevel() {
		return level;
	}

	public void setLevel(Float level) {
		this.level = level;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
	
	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}
}