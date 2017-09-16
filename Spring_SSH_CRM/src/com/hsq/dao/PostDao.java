package com.hsq.dao;

import java.util.List;

import com.hsq.bean.CrmDepartment;
import com.hsq.bean.CrmPost;

public interface PostDao {
	/**
	 * 查询指定部门的所有职务
	 * @param department
	 * @return
	 */
	public List<CrmPost> findAll(CrmDepartment department);

}
