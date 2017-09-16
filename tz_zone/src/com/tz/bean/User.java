package com.tz.bean;

import java.sql.Date;

/**
 * 
 * 评论信息表 Comment.java 
 * 创建人:xuchengfei 
 * 时间：2016年2月6日下午2:15:58
 * 
 * @version 1.0.0
 * 
 */
public class User {
	private int id;
	private String username;
	private String password;
	private String telephone;
	private String email;
	private String headerPic;
	private Date createTime;
	private Date updateTime;
	private Integer isDelete;
	private Integer male;
	private String sign;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHeaderPic() {
		return headerPic;
	}

	public void setHeaderPic(String headerPic) {
		this.headerPic = headerPic;
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

	public Integer getMale() {
		return male;
	}

	public void setMale(Integer male) {
		this.male = male;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}
}