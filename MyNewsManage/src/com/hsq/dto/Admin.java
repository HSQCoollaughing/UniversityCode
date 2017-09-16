package com.hsq.dto;

public class Admin {
	private int id;
private String LoginName;
private String password;
private String imagePath;

public String getImagePath() {
	return imagePath;
}
public void setImagePath(String imagePath) {
	this.imagePath = imagePath;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getLoginName() {
	return LoginName;
}
public void setLoginName(String loginName) {
this.	LoginName = loginName;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}


}
