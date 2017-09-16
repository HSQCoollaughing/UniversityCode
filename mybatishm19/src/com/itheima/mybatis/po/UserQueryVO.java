package com.itheima.mybatis.po;

import java.util.List;

/**
 * <p>Title: UserQueryVO</p>
 * <p>Description: TODO(这里用一句话描述这个类的作用) <p>
 * <p>Company: www.itcast.com</p>
 * @author 传智.关云长 
 * @date 2015-12-21 下午4:23:23  
 * @version 1.0
 */
public class UserQueryVO {

	//用户信息
	private User user;
	
	//商品ID集合
	private List<Integer> idList;
	
	//商品信息

	public List<Integer> getIdList() {
		return idList;
	}

	public void setIdList(List<Integer> idList) {
		this.idList = idList;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	//订单信息
	
}
