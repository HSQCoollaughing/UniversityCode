package com.tz.web.comment;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tz.bean.Comment;
import com.tz.dao.IDaoFactory;
import com.tz.dao.ObjectFactory;
import com.tz.dao.comment.CommentDao;
import com.tz.dao.comment.CommentMybatisDao;
import com.tz.util.TmStringUtils;
import com.tz.util.TzConstanst;

public class CommentDelServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	
	//我是分支以后的项目
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		IDaoFactory<Comment> commentDao = ObjectFactory.getInstance(CommentDao.class);
		IDaoFactory<Comment> commentDao = ObjectFactory.getInstance(CommentMybatisDao.class);
		//获取用户要删除的id
		//如果登陆了，获取登陆的用户userId,如果没有就跳转登陆页面进行登陆
		String id = request.getParameter("id");
		Integer userId = (Integer) request.getSession().getAttribute(TzConstanst.SESSION_USER_ID);
		PrintWriter out = response.getWriter();
		if(TmStringUtils.isEmpty(id)){
			out.print("fail");
			return;
		}
		//根据id执行删除
		boolean flag = commentDao.delete(Integer.parseInt(id), userId);
		//输出
		out.print(flag?"success":"fail");
		out.flush();
		out.close();
	}
}
