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
 * HotelDetail 创建人:xuchengfei 时间：2016年2月19日-上午12:21:44
 * 
 * @version 1.0.0
 * 
 */
public class HotelDetail {
	private Integer id;// 主键
	private String code;// 门牌号
	private String category;// 房间规格
	private Float money;// 酒店加个
	private Integer hotelId;// 隶属酒店
	private Integer userId;// 修改人
	private Integer status;// 0未发布1发布
	private Date createTime;// 创建时间
	private Date updateTime;// 更新时间
	private Integer isDelete;// 删除状态0未删除1删除

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Float getMoney() {
		return money;
	}

	public void setMoney(Float money) {
		this.money = money;
	}

	public Integer getHotelId() {
		return hotelId;
	}

	public void setHotelId(Integer hotelId) {
		this.hotelId = hotelId;
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

}
