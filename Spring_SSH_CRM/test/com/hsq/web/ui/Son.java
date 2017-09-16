package com.hsq.web.ui;

public class Son extends Parent {
	public void init(){
		//运行时this
		//this与super出现在同一个类中
		super.init();
		System.out.println("3 son init");
		this.demo();
	}
	public void demo(){
		System.out.println("4 son demo");
	}
}
