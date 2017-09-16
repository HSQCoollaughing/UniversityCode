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
 * User 创建人:xuchengfei 时间：2016年2月19日-上午12:21:44
 * 
 * @version 1.0.0
 * 
 */
public class User {
	private Integer id;//主键
	private String username;//用户姓名
	private String password;//密码
	private String acccount;//账号
	private String headePpic;//头像
	private Integer male;//性别1男0女
	private String idcard;//身份证
	private String bank;//银行卡
	private String telephone;//电话号码
	private Date createTime;//创建时间
	private Date updateTime;//更新时间
	private Integer isDelete;//删除状态0未删除1删除

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public String getAcccount() {
		return acccount;
	}

	public void setAcccount(String acccount) {
		this.acccount = acccount;
	}

	public String getHeadePpic() {
		return headePpic;
	}

	public void setHeadePpic(String headePpic) {
		this.headePpic = headePpic;
	}

	public Integer getMale() {
		return male;
	}

	public void setMale(Integer male) {
		this.male = male;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
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

}
