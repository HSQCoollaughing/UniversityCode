package com.hsq.service.impl;

import java.util.List;

import com.hsq.bean.CrmDepartment;
import com.hsq.bean.CrmPost;
import com.hsq.dao.PostDao;
import com.hsq.service.PostService;

public class PostServiceImpl implements PostService {
	private PostDao postDao;
	public void setPostDao(PostDao postDao) {
		this.postDao = postDao;
	}
	@Override
	public List<CrmPost> findAll(CrmDepartment department) {
		return postDao.findAll(department);
	}
	

}
