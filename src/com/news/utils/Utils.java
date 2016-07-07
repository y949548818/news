package com.news.utils;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Utils {
	
	/**
	 * 数据库的url
	 */
	private static final String DBURL="jdbc:mysql://rdsvi3ou08ee2zjc4890.mysql.rds.aliyuncs.com/dbnews";
	/**
	 * 数据库的jdbc
	 */
	private static final String DRIVER="com.mysql.jdbc.Driver";
	/**
	 * 用户名
	 */
	private static final String user="guestt";
	/**
	 * 密码
	 */
	private static final String password="123456";
	
	
	private static Connection conn=null;
	private static PreparedStatement pst=null;
	/**
	 * 这个方法用于获取数据库连接
	 * @return
	 */
	public static Connection getConnection(){
		try {  
            Class.forName(DRIVER);//指定连接类型  
            conn = DriverManager.getConnection(DBURL, user, password);//获取连接  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
		return conn;
	}
	/**
	 * 获取一段字符的md5值
	 * @param message
	 * @return
	 */
	public static String getMD5(String message){
		try {
			MessageDigest instance=MessageDigest.getInstance("MD5");
			byte[] digest=instance.digest(message.getBytes(Charset.forName("utf-8")));
			StringBuilder sb=new StringBuilder();
			for(byte b:digest)
			{
				int i=b&0xff;
				String hexString =Integer.toHexString(i);
				if(hexString.length()<2)
					hexString="0"+hexString;
				sb.append(hexString);
			}
			return sb.toString();
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
