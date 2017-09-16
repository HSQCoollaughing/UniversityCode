package com.tz.web;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * 
 * 文件上传类
 * TzFileUploadUtil
 * 创建人:xuchengfei 
 * 时间：2016年1月25日-下午9:11:12 
 * @version 1.0.0
 *
 */
public class TzFileUploadUtil {

	
	/**
	 * 上传的工具类
	 * 方法名：uploadFile
	 * 创建人：xuchengfei 
	 * 时间：2016年2月27日-下午11:16:09 
	 * 手机:1564545646464
	 * @param request void
	 * @exception 
	 * @since  1.0.0
	 */
	public List<HashMap<String, Object>> uploadFile(HttpServletRequest request){
		//定义获取服务器的目录c盘
		String path = request.getRealPath("upload");//E:\kekeproject3\.metadata\.me_tcat7\webapps\keke-upload
		String relativePath = "upload";
		String dpath = new SimpleDateFormat("/yyyy/MM/dd/").format(new Date());
		path+=dpath;
		relativePath+=dpath;
		File uploadPath = new File(path);
		//如果uplaod目录在服务器不存在，创建一下
		if(!uploadPath.exists())uploadPath.mkdirs();
		//1:获取客户端上传的工厂类
		FileItemFactory factory = new DiskFileItemFactory();
		//2:创建容器的文件上传类
		ServletFileUpload upload = new ServletFileUpload(factory);
		List<HashMap<String, Object>> maps = new ArrayList<HashMap<String, Object>>();
		//3：解析上传对象
		try {
			List<FileItem> fileItems = upload.parseRequest(request);
			//4:讲文件写入服务器目录
			for (FileItem fileItem : fileItems) {
				String newName = getFileName(fileItem.getName());
				fileItem.write(new File(uploadPath,newName));
				HashMap<String, Object> map = new HashMap<String,Object>();
				map.put("name", fileItem.getName());
				map.put("url", relativePath+newName);
				map.put("size", fileItem.getSize());
				maps.add(map);
			}
			return maps;
			//5:循环判断，开始写入服务器
		} catch (FileUploadException e) {
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static String getFileName(String name){
		String filename = UUID.randomUUID().toString();
		String ext = name.substring(name.lastIndexOf("."));
		return filename+ext;
	}
	
	public static void main(String[] args) {
		String path = "upload/";
		path+=new SimpleDateFormat("yyyy/MM/dd/").format(new Date());
		String filename = UUID.randomUUID().toString();
		String name = "name/fasdfas.txt";
		System.out.println(getFileName(name));
	}
}
