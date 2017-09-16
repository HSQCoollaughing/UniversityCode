package com.hsq.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.PropertyResourceBundle;

public class DataBase {
	private static String url;						//锟斤拷锟捷匡拷锟斤拷锟斤拷锟街达拷
	private static String userName;				//锟斤拷锟捷匡拷锟矫伙拷锟斤拷锟斤拷
	private static String driver;					//锟斤拷锟捷匡拷锟斤拷锟斤拷锟斤拷锟斤拷
	private static String pwd;						//锟斤拷锟捷匡拷锟矫伙拷锟斤拷陆锟斤拷锟斤拷
	private final static String fileName="database";	//锟斤拷锟斤拷锟侥硷拷锟斤拷锟斤拷
		//ThreadLocal 锟斤拷前锟竭程局诧拷锟斤拷锟斤拷
	@SuppressWarnings("rawtypes")
	private static ThreadLocal connection=new ThreadLocal();

		static{
			readConfig();
		}

		//	getConn锟斤拷锟斤拷锟斤拷锟节伙拷取锟斤拷锟捷匡拷锟斤拷锟斤拷
		/**
		 * synchronized 锟斤拷锟狡讹拷锟斤拷锟皆憋拷锟斤拷锟斤拷姆锟斤拷剩锟矫匡拷锟斤拷锟绞碉拷锟斤拷锟接σ伙拷锟斤拷锟斤拷锟�
		 * 每锟斤拷 synchronized 锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟矫碉拷锟矫该凤拷锟斤拷锟斤拷锟斤拷实锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷执锟叫ｏ拷
		 * 锟斤拷锟斤拷锟斤拷锟斤拷锟竭筹拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷一锟斤拷执锟叫ｏ拷锟酵讹拷占锟斤拷锟斤拷锟斤拷直锟斤拷锟接该凤拷锟斤拷锟斤拷锟斤拷时锟斤拷
		 * 锟斤拷锟斤拷锟酵放ｏ拷锟剿猴拷锟斤拷锟斤拷锟斤拷锟竭程凤拷锟杰伙拷酶锟斤拷锟斤拷锟斤拷锟斤拷陆锟斤拷锟斤拷执锟斤拷状态锟斤拷锟斤拷锟街伙拷锟斤拷
		 * 确锟斤拷锟斤拷同一时锟教讹拷锟斤拷每一锟斤拷锟斤拷实锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷为 synchronized 锟侥筹拷员锟斤拷锟斤拷
		 * 锟斤拷锟斤拷锟斤拷只锟斤拷一锟斤拷锟斤拷锟节匡拷执锟斤拷状态锟斤拷锟斤拷为锟斤拷锟斤拷只锟斤拷一锟斤拷锟杰癸拷锟斤拷酶锟斤拷锟绞碉拷锟斤拷锟接︼拷锟斤拷锟斤拷锟斤拷锟�
		 * 锟接讹拷锟斤拷效锟斤拷锟斤拷锟斤拷锟斤拷锟皆憋拷锟斤拷锟斤拷姆锟斤拷食锟酵�
		 */ 
		@SuppressWarnings("unchecked")
		public synchronized static Connection getConn()throws SQLException{
			Connection con=(Connection) connection.get();
			if (con!=null && !con.isClosed()){
				return con;
			}
				try{
					@SuppressWarnings("unused")
					Class providerClass=Class.forName(driver);
					con=DriverManager.getConnection(url,userName,pwd);
					//setAutoCommit
					//锟斤拷锟斤拷锟斤拷锟接碉拷锟皆讹拷锟结交模式锟斤拷锟斤拷为锟斤拷锟斤拷状态锟斤拷锟斤拷锟斤拷锟斤拷哟锟斤拷锟斤拷远锟斤拷峤荒Ｊ斤拷拢锟斤拷锟街达拷锟斤拷锟斤拷锟斤拷锟� SQL 锟斤拷洌拷锟斤拷锟斤拷锟叫╋拷锟斤拷锟斤拷为锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟结交锟斤拷
					//锟斤拷锟斤拷锟斤拷 SQL 锟斤拷浣拷锟斤拷锟截斤拷锟斤拷通锟斤拷锟斤拷锟斤拷 commit 锟斤拷锟斤拷锟斤拷 rollback 锟斤拷锟斤拷锟斤拷止锟斤拷锟斤拷锟斤拷锟叫★拷默锟斤拷锟斤拷锟斤拷拢锟斤拷碌锟斤拷锟斤拷哟锟斤拷锟斤拷远锟斤拷峤荒Ｊ斤拷隆锟� 
					con.setAutoCommit(false);
					connection.set(con);
					return con;
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				return null;
		}

		//锟斤拷取锟斤拷锟斤拷锟侥硷拷锟斤拷息
		@SuppressWarnings("unchecked")
		private static void readConfig(){
			//PropertyResourceBundle使锟斤拷锟斤拷锟斤拷锟侥硷拷锟叫的撅拷态锟街凤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟皆伙拷锟斤拷锟斤拷源锟斤拷
			PropertyResourceBundle prb=(PropertyResourceBundle) PropertyResourceBundle
				.getBundle(fileName);
			//枚锟斤拷Enumeration
			Enumeration enu=prb.getKeys();
			while (enu.hasMoreElements()){
				String propertyName=enu.nextElement().toString();
			//锟斤拷取锟斤拷锟斤拷锟侥硷拷锟叫的撅拷态锟街凤拷锟斤拷锟斤拷锟揭革拷值锟斤拷锟斤拷锟皆憋拷锟斤拷锟�
				if (propertyName.equals("database.driver"))
					driver=prb.getString("database.driver");
				if (propertyName.equals("database.url"))
					url=prb.getString("database.url");
				if (propertyName.equals("database.username"))
					userName=prb.getString("database.username");
				if (propertyName.equals("database.password"))
					pwd=prb.getString("database.password");
			}
		}
			
		//	commit 使锟皆达拷锟斤拷一锟斤拷锟结交/锟截癸拷锟斤拷锟斤拷锟斤拷锟叫碉拷锟斤拷锟叫革拷锟侥筹拷为锟街久革拷锟侥ｏ拷锟斤拷锟酵放达拷 Connection 锟斤拷锟斤拷前锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷菘锟斤拷锟斤拷锟斤拷锟�
		//  锟剿凤拷锟斤拷应锟斤拷只锟斤拷锟窖斤拷锟斤拷锟皆讹拷锟结交模式时使锟矫★拷 
		public static void commit(){
			Connection con=(Connection) connection.get();
			try{
				con.commit();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		//锟截癸拷锟斤拷锟斤拷
		public static void rollback(){
			Connection con=(Connection) connection.get();
			try{
				con.rollback() ;
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
		//锟酵凤拷锟斤拷锟捷匡拷锟斤拷锟斤拷
		public synchronized static void releaseConnection(Connection connection){
			try{
				if (connection!= null && !connection.isClosed())
					connection.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
			connection=null;
		}
		
		public static void main(String[] args){
			try{
				DataBase.getConn();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
}
