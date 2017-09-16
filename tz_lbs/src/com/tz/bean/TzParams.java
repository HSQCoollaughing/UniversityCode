/**
 * tzdesk系统平台
 * tz_lbs
 * com.tz.bean
 * TzParams.java
 * 创建人:xuchengfei 
 * 时间：2016年2月23日-下午11:18:39 
 * 2016潭州教育公司-版权所有
 */
package com.tz.bean;

/**
 * 参数类
 * TzParams 
 * 创建人:xuchengfei 
 * 时间：2016年2月23日-下午11:18:39
 * 
 * @version 1.0.0
 * 
 */
public class TzParams {

	private Integer pid;
	private String keyword;
	private Integer status;
	private Integer isDelete;
	private Integer pageNo = 0;
	private Integer pageSize = 10;

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
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

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

}
