package com.hsq.action;



import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;

import com.hsq.dto.Book;
import com.hsq.dto.CartItem;
import com.hsq.dto.User;
import com.hsq.service.CartItemService;

public class CartItemServlet extends BaseServlet {
	CartItemService cartItemService=new CartItemService();
	
	
	
	public String ajaxupdateQuantity(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String cartItemId = req.getParameter("cartItemId");
		int quantity = Integer.parseInt(req.getParameter("quantity"));
		CartItem cartItem = cartItemService.updatequantity(quantity, cartItemId);
		//拼成json数据，给客户端返回一个json对象
		StringBuilder sb = new StringBuilder("{");
		sb.append("\"quantity\"").append(":").append(cartItem.getQuantity());
		sb.append(",");
		sb.append("\"subtotal\"").append(":").append(cartItem.getSubtotal());
		sb.append("}");
System.out.println("ajax json"+sb.toString());
		resp.getWriter().print(sb);
		return null;
				
		
		
	}
	public String myCart(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		List<CartItem> list = cartItemService.findByUid(user.getUid());
		req.setAttribute("cartitemList", list);
		
		return "f:/jsps/cart/list.jsp";
	}
	
	
	public String add(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		if(user==null){
			
			return "r:/jsps/user/login.jsp";
			
		}else{
			//注意购物车条目合并
			int quantity = Integer.parseInt(req.getParameter("quantity"));
			String bid = req.getParameter("bid");
			Book book = new Book();
			book.setBid(bid);
			CartItem cartItem = new CartItem();
			cartItem.setUser(user);
			cartItem.setQuantity(quantity);
			cartItem.setBook(book);
		String cartID=	CommonUtils.uuid();
		
		//cartID = cartID.substring(1, 9);
	//	System.out.println("截取的ID"+cartID);
		cartItem.setCartItemId(cartID);
		//System.out.println(bid+"666666666");
		
			CartItem checkcartItem = cartItemService.findByCartItemid(bid, user.getUid());
			System.out.println("-----------"+checkcartItem);
			if (checkcartItem.getCartItemId()==null) {
				cartItemService.AddCartItem(cartItem);
			}else {
				int oldQuantity = checkcartItem.getQuantity();
				cartItemService.updatequantity(quantity+oldQuantity, checkcartItem.getCartItemId());
			}
			
			
			
		}
		
		
		return myCart(req, resp);
	}
	
	public  String DeleteCartItem(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String cartItemId = req.getParameter("cartItemIds");
		cartItemService.deleteCartItemId(cartItemId);
				return myCart(req, resp);
		
	}
	public  String LookCartItemsinfo(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String cartItemIds = req.getParameter("cartItemIds");
		double total = Double.parseDouble(req.getParameter("total"));
		List<CartItem> loadMuchCartItemInfo = cartItemService.loadMuchCartItemInfo(cartItemIds);
		req.setAttribute("cartItemList", loadMuchCartItemInfo);
		req.setAttribute("total", total);
		req.setAttribute("cartItemIds", cartItemIds);
		return "f:/jsps/cart/showitem.jsp";
		
	}
	
	public  String batchDelete(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cartItemIds = req.getParameter("cartItemIds");
		cartItemService.batchDelete(cartItemIds);
		return myCart(req, resp);
	}
}
