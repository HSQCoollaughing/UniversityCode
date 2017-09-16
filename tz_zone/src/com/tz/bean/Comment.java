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
public class Comment {

	private Integer id;// 主键
	private String title;// 主题
	private String content;// 内容
	private Integer userId;// 发布的用户ID
	private Date createTime;// 创建时间
	private Date updateTime;// 更新时间
	private Integer status;// 发布状态 0未发布1发布
	private Integer isDelete;// 0未删除1删除
	private Integer sort;// 排序好
	private String tag;// 关键词

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}
	// getter setter
}