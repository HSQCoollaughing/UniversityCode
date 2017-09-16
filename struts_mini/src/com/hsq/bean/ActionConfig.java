package com.hsq.bean;

import java.util.Map;

public class ActionConfig {
	private String name;
	private String clazz;
	private String method;
	private Map<String,ResultTag> resulttag;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getClazz() {
		return clazz;
	}
	public void setClazz(String clazz) {
		this.clazz = clazz;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public Map<String, ResultTag> getResulttag() {
		return resulttag;
	}
	public void setResulttag(Map<String, ResultTag> resulttag) {
		this.resulttag = resulttag;
	}
	@Override
	public String toString() {
		return "ActionConfig [name=" + name + ", clazz=" + clazz + ", method="
				+ method + ", resulttag=" + resulttag + "]";
	} 
	

}
