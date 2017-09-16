package com.hsq.dto;

import java.util.List;



public class Page {
	private List<Order> list;
	private int totalpage; //��ҳ��
	private int totalrecode; //�ܼ�¼��
private int pagesize=10;
private int pagenum;//�û��뿴��ҳ��

private int startpage;//��ʼҳ��
private int endpage;//����ҳ��
private int startindex;
public Page(int totalrecord,int pagenum){
	
	this.totalrecode=totalrecord;
	if (totalrecord%this.pagesize==0) {
		this.totalpage=totalrecord/this.pagesize;
	}else {
		this.totalpage=totalrecord/this.pagesize+1;
	}
	this.pagenum=pagenum;//1
	this.startindex=(this.pagenum-1)*this.pagesize;
	if (this.totalpage<=10) {
		this.startpage=1;
		this.endpage=this.totalpage;
	}else {
		//����뿴��ҳ�������ʼҳ�룻��ҳ����ֻ��ʾʮ��ҳ��
		//20  3  18    С��1    ������ҳ��
		this.startpage=this.pagenum-4;
		this.endpage=this.pagenum+5;
		if (this.startpage<1) {
			this.startpage=1;
			this.endpage=10;
		}
		if (this.endpage>this.totalpage) {
			this.startpage=this.totalpage-9;
			this.endpage=this.totalpage;
		}
	}
}
public List<Order> getList() {
	return list;
}
public void setList(List<Order> list) {
	this.list = list;
}
public int getTotalpage() {
	return totalpage;
}
public void setTotalpage(int totalpage) {
	this.totalpage = totalpage;
}
public int getTotalrecode() {
	return totalrecode;
}
public void setTotalrecode(int totalrecode) {
	this.totalrecode = totalrecode;
}
public int getPagesize() {
	return pagesize;
}
public void setPagesize(int pagesize) {
	this.pagesize = pagesize;
}
public int getPagenum() {
	return pagenum;
}
public void setPagenum(int pagenum) {
	this.pagenum = pagenum;
}
public int getStartindex() {
	return startindex;
}
public void setStartindex(int startindex) {
	this.startindex = startindex;
}
public int getStartpage() {
	return startpage;
}
public void setStartpage(int startpage) {
	this.startpage = startpage;
}
public int getEndpage() {
	return endpage;
}
public void setEndpage(int endpage) {
	this.endpage = endpage;
}
@Override
public String toString() {
	return "Page [list=" + list + ", totalpage=" + totalpage + ", totalrecode="
			+ totalrecode + ", pagesize=" + pagesize + ", pagenum=" + pagenum
			+ ", startpage=" + startpage + ", endpage=" + endpage
			+ ", startindex=" + startindex + "]";
}


}
