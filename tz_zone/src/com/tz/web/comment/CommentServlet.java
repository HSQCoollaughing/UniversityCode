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

public class CommentServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		IDaoFactory<Comment> commentDao = ObjectFactory.getInstance(CommentDao.class);
		IDaoFactory<Comment> commentDao = ObjectFactory.getInstance(CommentMybatisDao.class);
		//用户ID从session中获取
//		Integer userId = (Integer)request.getSession().getAttribute(TzConstanst.SESSION_USER_ID);
		Integer userId = 1;
		Comment comment = new Comment();
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String tag = request.getParameter("tag");
		comment.setTitle(title);
		comment.setContent(content);
		comment.setUserId(userId);
		comment.setStatus(1);
		comment.setIsDelete(0);
		comment.setSort(0);
		comment.setTag(tag);
		boolean flag = commentDao.save(comment);
		PrintWriter out = response.getWriter();
		out.print(flag?"success":"fail");
		out.flush();
		out.close();
	}
}
