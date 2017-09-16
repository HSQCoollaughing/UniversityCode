package com.hsq.upload;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;

public class UploadServlet extends HttpServlet {
	//服务器的目录
private String serverPath="c:/uploader/";
	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DiskFileItemFactory diskFileItemFactory=new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
		//设置文件名称的编码
	servletFileUpload.setHeaderEncoding("UTF-8");
	String fileMD5=null;
	String chunk=null;
	
	//开始解析文件
	try {
		List<FileItem> items = servletFileUpload.parseRequest(request);
		//1个FileItem文件里面的信息
		//获取文件信息
		for (FileItem fileItem : items) {
			//判断是文件还是普通数据
			if (fileItem.isFormField()) {
				
				String fieldName = fileItem.getFieldName();
				if (fieldName.equals("info")) {
					System.out.println(fieldName);
					String value = fileItem.getString("utf-8");
					System.out.println(value);
				}
				if (fieldName.equals("fileMD5")) {
					//System.out.println(fieldName);
					fileMD5 = fileItem.getString("utf-8");
					System.out.println(fileMD5);
				}
				if (fieldName.equals("chunk")) {
					//System.out.println(fieldName);
					chunk = fileItem.getString("utf-8");
					System.out.println(chunk);
				}
				
			}else {
				//String fileName = fileItem.getName();
				//获取文件的实际内容-----流
				//InputStream inputStream = fileItem.getInputStream();
				//FileUtils.copyInputStreamToFile(inputStream, new File(serverPath+fileName));
				//保存文件
				File file = new File(serverPath+"/"+fileMD5);
				if (!file.exists()) {
					file.mkdirs();
				}
				//保存
				File chunkfile = new File(serverPath+"/"+fileMD5+"/"+chunk);
				FileUtils.copyInputStreamToFile(fileItem.getInputStream(), chunkfile);
				
				
			}
			
		}
	} catch (FileUploadException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	}

}
