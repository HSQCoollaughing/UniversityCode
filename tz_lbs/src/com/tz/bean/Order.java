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
 * Order 创建人:xuchengfei 时间：2016年2月19日-上午12:21:44
 * 
 * @version 1.0.0
 * 
 */
public class Order {
	private Integer id;//主键
	private Integer userId;//入住用户
	private Integer hotelId;//入住酒店
	private Integer hotelDetailId;//入住的放假
	private Float money;//支付的金额
	private Integer type;//支付类型1支付宝 2微信
	private String orderNumber;//订单号
	private String description;//描述
	private Integer status;//0未发布1发布
	private Date createTime;//创建时间
	private Date updateTime;//更新时间
	private Integer isDelete;//删除状态0未删除1删除

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getHotelId() {
		return hotelId;
	}

	public void setHotelId(Integer hotelId) {
		this.hotelId = hotelId;
	}

	public Integer getHotelDetailId() {
		return hotelDetailId;
	}

	public void setHotelDetailId(Integer hotelDetailId) {
		this.hotelDetailId = hotelDetailId;
	}

	public Float getMoney() {
		return money;
	}

	public void setMoney(Float money) {
		this.money = money;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
}
