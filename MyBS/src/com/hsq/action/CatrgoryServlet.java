package com.hsq.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.servlet.BaseServlet;

import com.hsq.dto.Category;
import com.hsq.service.CategoryService;

public class CatrgoryServlet extends BaseServlet {
	CategoryService cs = new CategoryService();

	/*
	 * ��ѯ���з���
	 */
	public String findAllCategory(HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException {
List<Category> list = cs.findAllCategory();
System.out.println(list);
req.setAttribute("listCategory", list);
		return "f:/jsps/left.jsp";

	}
	public String AdminfindAllCategory(HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException {
List<Category> list = cs.findAllCategory();
System.out.println(list);
req.setAttribute("alllistCategory", list);
		return "f:/admin/book/category.jsp";

	}
}