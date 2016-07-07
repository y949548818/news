package com.news.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.news.dao.IAdminDAO;
import com.news.entity.User;
import com.news.utils.Utils;

public class AdminDAOimp1 implements IAdminDAO{
	private Connection conn=null;
	private PreparedStatement pstmt=null;
	
	public AdminDAOimp1(Connection conn)
	{
		this.conn=conn;
	}
	
	
	@Override
	public User findByName(String adminname) {
		User u1=null;
		String sql="select * from admin where admin_name=?";
		conn=Utils.getConnection();
		try {
			this.pstmt=this.conn.prepareStatement(sql);
			this.pstmt.setString(1, adminname);
			ResultSet rs=this.pstmt.executeQuery();
			if(rs.next())
			{
				u1=new User();
				u1.setId(rs.getInt(1));
				u1.setUsername(rs.getString(2));
				u1.setPassword(rs.getString(3));
			}
			this.pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return u1;
	}


	@Override
	public User findById(int admin_id) {
		User u1=null;
		String sql="select * from admin where admin_id=?";
		conn=Utils.getConnection();
		try {
			this.pstmt=this.conn.prepareStatement(sql);
			this.pstmt.setInt(1, admin_id);
			ResultSet rs=this.pstmt.executeQuery();
			while(rs.next())
			{
				u1=new User();
				u1.setId(rs.getInt(1));
				u1.setUsername(rs.getString(2));
				u1.setPassword(rs.getString(3));
			}
			this.pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return u1;
	}

}
