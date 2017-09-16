package com.hsq.upload;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UploadActionServlet extends HttpServlet {
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
		String action = request.getParameter("action");
		if (action.equals("mergeChunks")) {
			String fileMD5 = request.getParameter("fileMD5");//需要合并文件的标记
			//读取目录里面的所有文件
			File f = new File(serverPath+"/"+fileMD5);
		File[] fileArray=	f.listFiles(new FileFilter() {
				
				public boolean accept(File pathname) {
					//排除目录只有文件
					if (pathname.isDirectory()) {
						return false;
					}
					
					return true;
				}
			});
			//转成集合便于排序
			List<File> fileList=new ArrayList<File>(Arrays.asList(fileArray));
			//从小到大
			Collections.sort(fileList,new Comparator<File>() {

				public int compare(File o1, File o2) {
					if (Integer.parseInt(o1.getName())<Integer.parseInt(o2.getName())) {
						return -1;
					}
					return 1;
				}
			});
			File outputFile = new File(serverPath+"/"+UUID.randomUUID().toString()+".zip");
			outputFile.createNewFile();
			FileChannel channel = new FileOutputStream(outputFile).getChannel();
			//合并
			FileChannel inChannel;
			for (File file : fileList) {
				inChannel=new FileInputStream(file).getChannel();
				inChannel.transferTo(0, inChannel.size(), channel);
				inChannel.close();
				file.delete();
				
			}
			File tempFile = new File(serverPath+"/"+fileMD5);
			if (tempFile.isDirectory()&&tempFile.exists()) {
				tempFile.delete();
				
			}
			System.out.println("合并成功");
		}else if (action.equals("checkChunks")) {
			
			String fileMD5 = request.getParameter("fileMD5");
			String chunk = request.getParameter("chunk");
			String chunkSize = request.getParameter("chunkSize");
			//找到分块文件
			File checkFile = new File(serverPath+"/"+fileMD5+"/"+chunk);
			response.setContentType("text/html;chartset=utf-8");
			if (checkFile.exists()&&checkFile.length()==Integer.parseInt(chunkSize)) {
				response.getWriter().write("{\"ifExit\":1}");
				
			}else {
				response.getWriter().write("{\"ifExit\":0}");
			}
			
			
			
		}
		
	}

}
