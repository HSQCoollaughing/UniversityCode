package com.hsq.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.util.TokenHelper;

import com.hsq.bean.User;
import com.hsq.dao.IUser;
import com.hsq.dao.impl.IUserImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;

public class UserAction extends ActionSupport implements ModelDriven<User> {
	
	
	
	
	//�����ļ���file
	private File upload;//��name��upload
	//�ļ���strutsҪ���ע���Сд
	private String uploadFileName;
private InputStream inputStream;

	private String oldFileName;
private String isUpload;

	public String getIsUpload() {
	return isUpload;
}

public void setIsUpload(String isUpload) {
	this.isUpload = isUpload;
}

	public String getOldFileName() {
		return oldFileName;
	}

	public void setOldFileName(String oldFileName) {
		this.oldFileName = oldFileName;
	}

	public InputStream getInputStream() {
	return inputStream;
}

public void setInputStream(InputStream inputStream) {
	this.inputStream = inputStream;
}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	private IUser is = new IUserImpl();
	private User user = new User();
	private List<User> users;
	

	

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User getModel() {
		return user;
	}

	public String login() throws Exception {

		User dbuser = is.login(user.getLogonName(), user.getLogonPwd());

		if (dbuser == null) {
			addActionError("�û�������");
			return "input";
		}
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("user", dbuser);
		return SUCCESS;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String addUser() throws Exception {
		
		if (upload!=null) {
			String filePath = ServletActionContext.getServletContext().getRealPath(
					"/upload");
			String dir = generateChildPath(filePath);
			String fileName = TokenHelper.generateGUID()+"_"+uploadFileName;
			user.setPath(dir);
			user.setFilename(fileName);
			//rename fileName  ���ļ������� TofilePath+File.separator+dir 
			//upload �����Ѿ���װ��upload upload���ļ����� File��
			//���ļ����ȥ
			upload.renameTo(new File(filePath+File.separator+dir, fileName));
		}
		int res = is.AddUser(user);
		if (res > 0) {
			return SUCCESS;
		}
		return null;

	}
////������yyyy-MM-dd�ĸ�ʽ�����ļ���
	private String generateChildPath(String filePath) {
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String dir = df.format(date);
		File file = new File(filePath, dir);
		if (!file.exists()) {
			file.mkdirs();
		}
		return dir;
	}
	public String findAll()throws Exception{
		users = is.findAllUser();
		if (users.size()>0) {
			return SUCCESS;
		}
		return null;
		
		
		
	}
	public String findById()throws Exception{
		//��ȡ��һ���µĶ���
		user = is.findByID(user.getUserID());
		ValueStack vs=ActionContext.getContext().getValueStack();
		vs.push(user);
		return SUCCESS;
		
		
	}
	/*
	 * �ļ�����
	 * 
	 */
	public String download()throws Exception{
		String filePath = ServletActionContext.getServletContext().getRealPath("/upload");
		User dbuser = is.findByID(user.getUserID());
		oldFileName=dbuser.getFilename().substring(dbuser.getFilename().indexOf("_")+1);
		inputStream=new FileInputStream(filePath+File.separator+dbuser.getPath()+File.separator+dbuser.getFilename());
		//������stream��������� ע����������
		System.out.println(filePath+File.separator+dbuser.getPath()+File.separator+dbuser.getFilename());
		return SUCCESS;
	}
	public String delete()throws Exception{
		
		int res = is.deleteByID(user.getUserID());
		if (res>0) {
			return SUCCESS;
		}
		return null;
		
		
		
		
	}
	public String edit()throws Exception{
	user=	is.findByID(user.getUserID());
	ValueStack vs = ActionContext.getContext().getValueStack();
	vs.push(user);
		
		return SUCCESS;
	}
	public String update()throws Exception{
		/*
		 * 
		 * �ж��û��Ƿ��ϴ��ļ���1.�û�ѡ����ǰ�����ϼ��  2.�û�ѡ���µ�����   
		 */
		if (upload==null) {
			User dbuser = is.findByID(user.getUserID());
			user.setFilename(dbuser.getFilename());
			user.setPath(user.getPath());
			int res = is.updateUser(user);
			if (res>0) {
				return SUCCESS;
			}
			
		}else {
			String filePath = ServletActionContext.getServletContext().getRealPath(
					"/upload");
			String dir = generateChildPath(filePath);
			String fileName = TokenHelper.generateGUID()+"_"+uploadFileName;
			user.setPath(dir);
			user.setFilename(fileName);
			
				
				upload.renameTo(new File(filePath+File.separator+dir, fileName));
				int res = is.updateUser(user);
				if (res>0) {
					return SUCCESS;
				}
		}
		
		return null;
		
		
	}
	public String findByCondition() throws Exception{
		users = is.findByCondition(user.getUserName(), isUpload, user.getGender(), user.getEducation());
		return SUCCESS;
	}
	
}
