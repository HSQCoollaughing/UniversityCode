<%@page import="com.tz.dao.HotelDao"%>
<%@page import="com.tz.bean.Hotel"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../common/taglib.jsp" %>
<!doctype html>
<html>
<head>
	<meta charset="utf-8"/>
	<title>潭州特训班 - LBS移动电商系统后台管理中心 - Arry老师</title>
	<meta name="keywords" content="关键词,关键词">
	<meta name="description" content="">
	<%@include file="../common/adminHeader.jsp" %>
	<script type="text/javascript" src="${basePath}/js/tz_pca.js"></script>
</head>
<body>
	<div class="tz_content">
		<%@include file="left.jsp" %><!-- 服务器路径包括 -->
		<!--t_right start-->
		<div class="t_right">
			<%@include file="header.jsp" %><!-- 服务器路径包括 -->
			<!--r_message start-->
			<div class="r_message">
				<div class="m_list m_1">
					<div class="m_pic"></div>
					<div class="m_desc">
						<span>2450</span>
						<p>所有用户数</p>
					</div>
				</div>
				<div class="m_list m_2">
					<div class="m_pic"></div>
					<div class="m_desc">
						<span>2450</span>
						<p>所有用户数</p>
					</div>				
				</div>
				<div class="m_list m_3">
					<div class="m_pic"></div>
					<div class="m_desc">
						<span>2450</span>
						<p>所有用户数</p>
					</div>				
				</div>
				<div class="m_list m_4">
					<div class="m_pic"></div>
					<div class="m_desc">
						<span>2450</span>
						<p>所有用户数</p>
					</div>				
				</div>
				<div class="m_list m_5">
					<div class="m_pic"></div>
					<div class="m_desc">
						<span>2450</span>
						<p>所有用户数</p>
					</div>				
				</div>
				<div class="m_list m_6">
					<div class="m_pic"></div>
					<div class="m_desc">
						<span>2450</span>
						<p>所有用户数</p>
					</div>				
				</div>
				<div class="m_list m_7">
					<div class="m_pic"></div>
					<div class="m_desc">
						<span>2450</span>
						<p>所有用户数</p>
					</div>				
				</div>
				<div class="m_list m_8">
					<div class="m_pic"></div>
					<div class="m_desc">
						<span>2450</span>
						<p>所有用户数</p>
					</div>				
				</div>
				<div class="m_list m_9">
					<div class="m_pic"></div>
					<div class="m_desc">
						<span>2450</span>
						<p>所有用户数</p>
					</div>				
				</div>
				<div class="m_list m_10">
					<div class="m_pic"></div>
					<div class="m_desc">
						<span>2450</span>
						<p>所有用户数</p>
					</div>				
				</div>
				<div class="clear"></div>
			</div>
			<!--end r_message-->

			<!--r_table start-->
			<div class="r_table">
				<div class="r_title">
					<i></i>
					<p>表格表单类</p>
				</div>

				<!--r_label start-->
				<div class="r_label">
					<ul>
						<li>
							<a href="#">
								<i class="l_icon1"></i>
								<span>添加</span>
							</a>
						</li>
						<li>
							<a href="#">
								<i class="l_icon2"></i>
								<span>编辑</span>
							</a>
						</li>
						<li>
							<a href="#">
								<i class="l_icon3"></i>
								<span>添加章节</span>
							</a>
						</li>
						<li>
							<a href="#">
								<i class="l_icon4"></i>
								<span>上传资料</span>
							</a>
						</li>
						<li>
							<a href="#">
								<i class="l_icon5"></i>
								<span>置顶</span>
							</a>
						</li>
						<li>
							<a href="#">
								<i class="l_icon6"></i>
								<span>取消置顶</span>
							</a>
						</li>
						<li>
							<a href="#">
								<i class="l_icon7"></i>
								<span>生成静态页面</span>
							</a>
						</li>
						<li>
							<a href="#">
								<i class="l_icon8"></i>
								<span>删除</span>
							</a>
						</li>
						<li>
							<a href="#">
								<i class="l_icon9"></i>
								<span>审核信息</span>
							</a>
						</li>
						<li>
							<a href="#">
								<i class="l_icon10"></i>
								<span>刷新数据</span>
							</a>
						</li>
						<li>
							<a href="#">
								<i class="l_icon11"></i>
								<span>标记</span>
							</a>
						</li>

					</ul>
				</div>
				<!--end r_label-->

				<!--r_search start-->
				<div class="r_search">
					<input type="button" value="GO" class="r_btn"/>
					<input type="text" class="r_text"/>
				</div>
				<div class="clear"></div>
				<!--end r_search-->
				
				<!--r_table_list start-->
				<div class="r_table_list">
					<table class="t_tab">
						<thead>
							<tr>
								<th>11</th>
								<th>ID</th>
								<th>标题</th>
								<th>发布者</th>
								<th>点击数</th>
								<th>类型</th>
								<th>发布时间</th>
								<th>置顶</th>
								<th>静态化</th>
								<th>评论</th>
								<th>状态</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>111</td>
								<td>007</td>
								<td>Myeclipse注释自动补全</td>
								<td>arry老师</td>
								<td>23423</td>
								<td>文章</td>
								<td>2015/1/26</td>
								<td>已置顶</td>
								<td>已静态化</td>
								<td>是</td>
								<td>已发布</td>
								<td class="t_td">
									<div class="t_action">
										<a href="#" class="a_see" title="查看"></a>
										<a href="#" class="a_edit" title="编辑"></a>
										<a href="#" class="a_save" title="保存"></a>
										<a href="#" class="a_del" title="删除"></a>
									</div>
								</td>
							</tr>
							<tr>
								<td>111</td>
								<td>007</td>
								<td>Myeclipse注释自动补全</td>
								<td>arry老师</td>
								<td>23423</td>
								<td>文章</td>
								<td>2015/1/26</td>
								<td>已置顶</td>
								<td>已静态化</td>
								<td>是</td>
								<td>已发布</td>
								<td>
									<div class="t_action">
										<a href="#" class="a_see" title="查看"></a>
										<a href="#" class="a_edit" title="编辑"></a>
										<a href="#" class="a_save" title="保存"></a>
										<a href="#" class="a_del" title="删除"></a>
									</div>								
								</td>
							</tr>
							<tr>
								<td>111</td>
								<td>007</td>
								<td>Myeclipse注释自动补全</td>
								<td>arry老师</td>
								<td>23423</td>
								<td>文章</td>
								<td>2015/1/26</td>
								<td>已置顶</td>
								<td>已静态化</td>
								<td>是</td>
								<td>已发布</td>
								<td>
									<div class="t_action">
										<a href="#" class="a_see" title="查看"></a>
										<a href="#" class="a_edit" title="编辑"></a>
										<a href="#" class="a_save" title="保存"></a>
										<a href="#" class="a_del" title="删除"></a>
									</div>								
								</td>
							</tr>
							<tr>
								<td>111</td>
								<td>007</td>
								<td>Myeclipse注释自动补全</td>
								<td>arry老师</td>
								<td>23423</td>
								<td>文章</td>
								<td>2015/1/26</td>
								<td>已置顶</td>
								<td>已静态化</td>
								<td>是</td>
								<td>已发布</td>
								<td>
									<div class="t_action">
										<a href="#" class="a_see" title="查看"></a>
										<a href="#" class="a_edit" title="编辑"></a>
										<a href="#" class="a_save" title="保存"></a>
										<a href="#" class="a_del" title="删除"></a>
									</div>								
								</td>
							</tr>
							<tr>
								<td>111</td>
								<td>007</td>
								<td>Myeclipse注释自动补全</td>
								<td>arry老师</td>
								<td>23423</td>
								<td>文章</td>
								<td>2015/1/26</td>
								<td>已置顶</td>
								<td>已静态化</td>
								<td>是</td>
								<td>已发布</td>
								<td>
									<div class="t_action">
										<a href="#" class="a_see" title="查看"></a>
										<a href="#" class="a_edit" title="编辑"></a>
										<a href="#" class="a_save" title="保存"></a>
										<a href="#" class="a_del" title="删除"></a>
									</div>								
								</td>
							</tr>
							<tr>
								<td>111</td>
								<td>007</td>
								<td>Myeclipse注释自动补全</td>
								<td>arry老师</td>
								<td>23423</td>
								<td>文章</td>
								<td>2015/1/26</td>
								<td>已置顶</td>
								<td>已静态化</td>
								<td>是</td>
								<td>已发布</td>
								<td>
									<div class="t_action">
										<a href="#" class="a_see" title="查看"></a>
										<a href="#" class="a_edit" title="编辑"></a>
										<a href="#" class="a_save" title="保存"></a>
										<a href="#" class="a_del" title="删除"></a>
									</div>								
								</td>
							</tr>
						</tbody>

					</table>
				</div>
				<!--end r_table_list-->
				
			</div>
			<!--end r_table-->

		</div>
		<!--end t_right-->

	</div>


</body>
</html>