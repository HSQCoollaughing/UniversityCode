package com.hsq.dto;

import java.util.Date;

public class News {
private int id;
private String title;
private String content;
private int count;
private String author;
private Date sendTime;
public int getId() {
	return id;
}
public void setId(int id) {
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
public int getCount() {
	return count;
}
public void setCount(int count) {
	this.count = count;
}
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
public Date getSendTime() {
	return sendTime;
}
public void setSendTime(Date sendTime) {
	this.sendTime = sendTime;
}




}
