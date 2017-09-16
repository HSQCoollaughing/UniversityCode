package com.tz.web.comment;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tz.bean.Comment;
import com.tz.bean.TzParams;
import com.tz.dao.IDaoFactory;
import com.tz.dao.ObjectFactory;
import com.tz.dao.comment.CommentDao;
import com.tz.dao.comment.CommentMybatisDao;
import com.tz.util.TmStringUtils;

public class CommentListServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//IDaoFactory<Comment> commentDao = ObjectFactory.getInstance(CommentDao.class);
		IDaoFactory<Comment> commentDao = ObjectFactory.getInstance(CommentMybatisDao.class);
		//传递过来的分页参数
		String pageNo = request.getParameter("pageNo");
		String pageSize = request.getParameter("pageSize");
		TzParams params = new TzParams();
		params.setUserIds("1,2");//模拟数据
		params.setPageNo(TmStringUtils.isEmpty(pageNo)?"0":pageNo);
		params.setPageSize(TmStringUtils.isEmpty(pageSize)?"10":pageSize);
		List<HashMap<String, Object>> datas = commentDao.findListByPage(params);
		//第一种做法
//		PrintWriter out = response.getWriter();
//		try {
//			if(datas!=null && datas.size()>0){
//				out.print(JSONUtil.serialize(datas));
//			}else{
//				out.print("");
//			}
//		} catch (JSONException e) {
//			e.printStackTrace();
//		}
//		out.flush();
//		out.close();
		
		//第二种方式：模板技术
		request.setAttribute("datas",datas);
		request.getRequestDispatcher("/template/template.jsp").forward(request, response);
	}
}
