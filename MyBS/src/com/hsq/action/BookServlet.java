package com.hsq.action;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;

import com.hsq.dto.Book;
import com.hsq.dto.Category;
import com.hsq.service.BookService;
import com.hsq.service.CategoryService;

public class BookServlet extends BaseServlet {
	BookService bookservice = new BookService();
    CategoryService categoryservice=new CategoryService();
	public String BookfindByCategory(HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cid = req.getParameter("cid");
		List<Book> list = bookservice.findByCategory(cid);
		List<Category> category = categoryservice.findAllCategory();
		req.setAttribute("categoryList", category);
		req.setAttribute("bookList", list);
		return "f:/jsps/book/list.jsp";
	}
	public String AdminBookfindByCategory(HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cid = req.getParameter("cid");
		List<Book> list = bookservice.findByCategory(cid);
		List<Category> category = categoryservice.findAllCategory();
		req.setAttribute("categoryList", category);
		req.setAttribute("bookList", list);
		return "f:/admin/book/clist.jsp";
	}
	public String Bookdesc(HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String bid = req.getParameter("bid");
		Book book = bookservice.findByid(bid);
		List<Category> category = categoryservice.findAllCategory();
		req.setAttribute("categoryList", category);
		req.setAttribute("book", book);
		return "f:/jsps/book/desc.jsp";
	}
	
	public String findAllBook(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		List<Book> bookList = bookservice.findAllBook();
		req.setAttribute("bookList", bookList);
				return "f:/admin/book/list.jsp";
		
	}
	public String findByBname(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//解决get请求方式乱码问题
		
		String express = req.getParameter("express");
		byte[] bytes = express.getBytes("ISO-8859-1");
		String string = new String(bytes,"utf-8");
		
		List<Book> bookList = bookservice.findBylike(string);
		req.setAttribute("bookList", bookList);
				return "f:/jsps/book/list.jsp";
		
	}
	
	public String indexfindAllBook(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		List<Book> bookList = bookservice.findAllBook();
		req.setAttribute("bookList1", bookList);
				return "f:/jsps/body.jsp";
		
	}
		public String addPre(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
			
			List<Category> category = categoryservice.findAllCategory();
			req.setAttribute("categoryList", category);
					return "f:/admin/book/add.jsp";
			
			
		}
		
		public  String edit(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
					Map map = req.getParameterMap();
					Book book = CommonUtils.toBean(map, Book.class);
					Category category = CommonUtils.toBean(map, Category.class);
					book.setCategory(category);
					bookservice.editBook(book);
					req.setAttribute("msg", "修改成功");
					return "f:/admin/msg.jsp";
			
		}
		
		public  String delete(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
			String bid=req.getParameter("bid");
			bookservice.deleteBook(bid);
			req.setAttribute("msg", "删除成功");
					return "f:/admin/msg.jsp";
			
		}
		public String adminBookdesc(HttpServletRequest req,
				HttpServletResponse resp) throws ServletException, IOException {
			// TODO Auto-generated method stub
			String bid = req.getParameter("bid");
			Book book = bookservice.findByid(bid);
			List<Category> category = categoryservice.findAllCategory();
			req.setAttribute("categoryList", category);
			req.setAttribute("book", book);
			return "f:/admin/book/desc.jsp";
		}
//		public String cadminBookdesc(HttpServletRequest req,
//				HttpServletResponse resp) throws ServletException, IOException {
//			// TODO Auto-generated method stub
//			String cid = req.getParameter("cid");
//			 List<Book> findByCategory = bookservice.findByCategory(cid);
//			List<Category> category = categoryservice.findAllCategory();
//			req.setAttribute("categoryList", category);
//			req.setAttribute("book", findByCategory);
//			return "f:/admin/book/desc.jsp";
//		}
}
