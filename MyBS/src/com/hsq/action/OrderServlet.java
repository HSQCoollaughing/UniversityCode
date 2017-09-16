package com.hsq.action;



import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;

import com.hsq.dto.CartItem;
import com.hsq.dto.Order;
import com.hsq.dto.OrderItem;
import com.hsq.dto.Page;
import com.hsq.dto.User;
import com.hsq.service.CartItemService;
import com.hsq.service.OrderService;

public class OrderServlet extends BaseServlet {
   OrderService orderservice=   new OrderService();
 CartItemService cartservice=      new CartItemService();
public  String myOrders(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
	String pagenum = req.getParameter("pagenum");
	User user = (User) req.getSession().getAttribute("user");
//	Order order = (Order) req.getAttribute("sendorder");
	Page page = orderservice.findByUid(user.getUid(),pagenum);
//	if (order!=null) {
//		
//		list.add(order);
//	}
	
	req.setAttribute("page", page );
	return "f:/jsps/order/list.jsp";
}
public  String load(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
	String oid = req.getParameter("oid");
	Order order = orderservice.load(oid);
	System.out.println(order+"[[[[[[[[[");
	req.setAttribute("order", order);
	return "f:/jsps/order/desc.jsp";
}

	public String createOrder(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//思路:从购物车模块搞数据
		String cartItemIds=req.getParameter("cartItemIds");
			Order order = new Order();
			String address = req.getParameter("address");
			User user = (User) req.getSession().getAttribute("user");
			String oid=CommonUtils.uuid();
			String ordertime = String.format("%tF %<tT", new Date());
			System.out.println(ordertime);
			//List<CartItem> cartIttem = cartservice.findByUid(user.getUid());总价得不到数据，换个方式
			List<CartItem> list = cartservice.loadMuchCartItemInfo(cartItemIds);
			BigDecimal total = new BigDecimal("0");
			for (CartItem cartItem : list) {
				total=total.add(new BigDecimal(cartItem.getSubtotal()+""));
			}
			System.out.println(total);
			double ototal = total.doubleValue();
			System.out.println(ototal);
			
			
			order.setOid(oid);
			order.setStatus(1);
			order.setTotal(ototal);
			order.setAddress(address);
			order.setOrdertime(ordertime);
			order.setOwner(user);
			//接下来设置list集合
			List<OrderItem> orderItemList=new ArrayList<OrderItem>();
			
			
			for (CartItem cartItem : list) {
				
				OrderItem orderItem = new OrderItem();
			orderItem.setBook(cartItem.getBook());
			orderItem.setOrder(order);
			System.out.println("-eotrwotowertooertertert"+cartItem.getBook());
			orderItem.setQuantity(cartItem.getQuantity());
			orderItem.setSubtotal(cartItem.getSubtotal());
			orderItem.setOrderItemId(CommonUtils.uuid());
			orderItemList.add(orderItem);
			}
			
			order.setOrderItemList(orderItemList);
			System.out.println(orderItemList.size());
			orderservice.createOrder(order);
			req.setAttribute("order", order);
		//List<Order> listOrder=	(List<Order>) req.getAttribute("myorder");不是application空指针
		//listOrder.add(order);
			cartservice.batchDelete(cartItemIds);
			return "f:/jsps/order/ordersucc.jsp";
		
		
	}
	
		public String findAll(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
			String pagenum = req.getParameter("pagenum");
			Page page = orderservice.findAll(pagenum);
			req.setAttribute("page", page);
					return "f:/admin/order/list.jsp";
			
		}
}
