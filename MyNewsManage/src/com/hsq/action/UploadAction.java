package com.hsq.action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Iterator;

import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class UploadAction
 */
@WebServlet("/UploadAction")
public class UploadAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String CONTENT_TYPE = "text/html; charset=utf-8";
	private static final String ALLOW_EXT="jpg,jpeg,png,bmp,gif"; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// WEB��ʽ�ı��ֵ�ַ��ʾ����http://127.0.0.1:8080/uploadtest/
				String path = request.getContextPath();
				String basePath = request.getScheme() + "://" + request.getServerName()
						+ ":" + request.getServerPort() + path + "/";
				
				System.out.println("web��ַ��"+basePath);
						
				// ��ñ��ص�ַ��ʾ���磺c://tomcat/webapp/
				String temp = getServletContext().getRealPath("/") + "upload/temp"; // ��ʱĿ¼
				String loadpath = getServletContext().getRealPath("/") + "upload"; // �ϴ��ļ����Ŀ¼
				
				System.out.println("���ص�ַ��"+loadpath);	
				
				response.setContentType(CONTENT_TYPE);
				PrintWriter out = response.getWriter();
				try {
					// Create a factory for disk-based file items
					DiskFileItemFactory factory = new DiskFileItemFactory();
					// Set factory constraints�������ֻ�������ڴ��д洢������,��λ:�ֽ�
					factory.setSizeThreshold(4096);
					// ����һ���ļ���С����getSizeThreshold()��ֵʱ���ݴ����Ӳ�̵�Ŀ¼(����)
					factory.setRepository(new File(temp));
					// Create a new file upload handler
					ServletFileUpload upload = new ServletFileUpload(factory);
					// Set overall request size constraint���������û��ϴ��ļ���С,��λ:�ֽڣ�������Ϊ1M
					upload.setSizeMax(1 * 1024 * 1024);
					// Parse the request
					List /* FileItem */fileItems = upload.parseRequest(request);
					// ��ʼ��ȡ�ϴ���Ϣ
					// ���δ���ÿ���ϴ����ļ�
					Iterator iter = fileItems.iterator();
					while (iter.hasNext()) {
						FileItem item = (FileItem) iter.next();
						 if(item.isFormField()) { 					
			                    System.out.print("form field:");  
			                    System.out.print(item.getFieldName() + "  ");  
			                    System.out.print(item.getString());  
			                } 
						// �������������ļ�������б���Ϣ
						
						if (!item.isFormField()) {
							//�ϴ��ļ���
							String name = item.getName();
							System.out.println("�ϴ��ļ���:"+name);
							long size = item.getSize();
							System.out.println("�ϴ��ļ���С:"+size);
							if ((name == null || name.equals("")) && size == 0)
								continue;
							name = name.substring(name.lastIndexOf("\\") + 1);// ��ȫ·������ȡ�ļ���
							String extName=name.substring(name.lastIndexOf(".") + 1);
							System.out.println("�ϴ��ļ���:"+name);
							System.out.println("�ϴ��ļ���չ��:"+extName);
							if(ALLOW_EXT.indexOf(extName)==-1){
								request.setAttribute("error", "ֻ�����ϴ�jpg,png,bmp,gifͼƬ");
								request.getRequestDispatcher("upload.jsp").forward(request, response);
							}
							// �������ı������⣬ǰ̨��UTF��8������������Ҫ��Ӧ�ϣ����ǰ̨��gb2312�Ļ�������ҲӦ����gb2312
							name = new String(name.getBytes(), "utf-8");
							try {
								// �����ϴ����ļ���ָ����Ŀ¼
								// ���������ϴ��ļ������ݿ�ʱ�����������д
								Date d=new Date();
								name=d.getTime()+"."+extName;
								System.out.println("�ϴ��ļ�����Ϊ:"+name);
								File fNew = new File(loadpath, name);
								item.write(fNew);
								request.setAttribute("imgPath", name);
								request.getRequestDispatcher("upload.jsp").forward(request, response);
							}
							catch (Exception e) {
								e.printStackTrace();
								out.println(e);
							}
						}
					}
				}
				catch (Exception e) {
					request.setAttribute("error", "�ϴ�����ʧ�ܣ������ļ���С�Ƿ�������1M��Χ��?");
					request.getRequestDispatcher("upload.jsp").forward(request, response);			
					e.printStackTrace();
				}
			}
	

}
