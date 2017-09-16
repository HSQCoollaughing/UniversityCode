package com.hsq.bean;

public class ResultTag {
	private String name;
	private String targetjsp;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTargetjsp() {
		return targetjsp;
	}
	public void setTargetjsp(String targetjsp) {
		this.targetjsp = targetjsp;
	}
	@Override
	public String toString() {
		return "ResultTag [name=" + name + ", targetjsp=" + targetjsp + "]";
	}
	

}
