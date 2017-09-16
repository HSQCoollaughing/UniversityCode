<%@page import="com.tz.bean.Hotel"%>
<%@page import="com.tz.dao.AdminHotelDao"%>
<%@page import="com.tz.bean.TzParams"%>
<%@page import="com.tz.util.TmStringUtils"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@include file="../common/taglib.jsp" %>
<%
	String pid = request.getParameter("pid");
	String pageNo = request.getParameter("pageNo");
	String pageSize = request.getParameter("pageSize");
	String keyword = request.getParameter("keyword");
	Integer pno = TmStringUtils.isEmpty(pageNo)?0:Integer.parseInt(pageNo);
	Integer psize = TmStringUtils.isEmpty(pageSize)?10:Integer.parseInt(pageSize);
	//查询酒店信息
	TzParams params = new TzParams();
	//params.setIsDelete(0);
	//params.setStatus(1);
	params.setPid(TmStringUtils.isNotEmpty(pid)?new Integer(pid):null);
	params.setKeyword(keyword);
	params.setPageNo(pno);
	params.setPageSize(psize);
	AdminHotelDao hotelDao = new AdminHotelDao();
	List<Hotel> hotels = hotelDao.findHotels(params);
	int itemCount = hotelDao.countHotels(params); 
	pageContext.setAttribute("hotels",hotels);
	pageContext.setAttribute("itemCount",itemCount);
%>
<c:if test="${hotels.size()>0}">
	<c:forEach items="${hotels}" var="hotel">
		<tr data-itemcount="${itemCount}">
			<td>${hotel.id}</td>
			<td>${hotel.name}</td>
			<td>${hotel.level}</td>
			<td>${hotel.pname}</td>
			<td>
				<c:if test="${hotel.status==0}"><a href="#" class="green">未发布</a></c:if>
				<c:if test="${hotel.status==1}"><a href="#" class="red">发布</a></c:if>
			</td>
			<td>
				${tz:formatDate(hotel.createTime,'yyyy-MM-dd HH:mm:ss')}
			</td>
			<td>${hotel.gd}/${hotel.wd}</td>
			<td class="t_td">
				<div class="t_action">
					<a href="${basePath}/admin/add.jsp?id=${hotel.id}" class="a_edit" title="编辑"></a>
					<a href="javascript:void(0);" class="a_del" title="删除"></a>
				</div>
			</td>
		</tr>
	</c:forEach>
</c:if>
<c:if test="${hotels.size()==0}">
	<tr><td colspan="8" style="padding:100px;text-align: center;">
		<h1 class="empty"><i class="iconfont icon-iconhottitle fz24"></i>友情提示：暂无您所需要的数据....</h1>
	</td></tr>
</c:if>