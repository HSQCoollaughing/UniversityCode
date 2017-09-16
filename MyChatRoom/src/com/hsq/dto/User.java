package com.hsq.dto;

import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class User implements HttpSessionBindingListener {
private int id;
private String loginName;
private String  password;
private String type;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getLoginName() {
	return loginName;
}
public void setLoginName(String loginName) {
	this.loginName = loginName;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
@Override
public String toString() {
	return "User [id=" + id + ", loginName=" + loginName + ", password="
			+ password + ", type=" + type + "]";
}


@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + id;
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	User other = (User) obj;
	if (id != other.id)
		return false;
	return true;
}
public void valueBound(HttpSessionBindingEvent hsb) {
	// TODO Auto-generated method stub
	System.out.println("进入了》》》》》》》》》》》》");
	HttpSession session = hsb.getSession();
Map<User,HttpSession> userMap=	(Map<User, HttpSession>) session.getServletContext().getAttribute("userMap");
	userMap.put(this, session);
}
//当Seesion与User对象解除绑定时
public void valueUnbound(HttpSessionBindingEvent hsb) {
	// TODO Auto-generated method stub
	System.out.println("退出了");
	HttpSession session = hsb.getSession();
	Map<User,HttpSession> userMap = (Map<User, HttpSession>) session.getServletContext().getAttribute("userMap");
	
	userMap.remove(this);
	
}





}
