package com.news.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.news.dao.IUserDAO;
import com.news.entity.User;
import com.news.utils.Utils;

public class UserDAOImp1 implements IUserDAO{
	private Connection conn=null;
	private PreparedStatement pstmt=null;
	public UserDAOImp1(Connection conn)
	{
		this.conn=conn;
	}

	@Override
	public boolean doCreate(User user) throws Exception {
		boolean b=false;
		String sql="insert into users(username,password)values(?,?)";
		conn=Utils.getConnection();
		this.pstmt=this.conn.prepareStatement(sql);
		this.pstmt.setString(1, user.getUsername());
		this.pstmt.setString(2, user.getPassword());
		System.out.println(user.toString());
		if(this.pstmt.executeUpdate()>0)
		{
			b=true;
		}
		this.pstmt.close();
		conn.close();
		return b;
	}

	@Override
	public boolean doDelete(int id) throws Exception {
		boolean b=false;
		conn=Utils.getConnection();
		String sql="delete from users where user_id=?";
		this.pstmt=this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, id);
		if(this.pstmt.executeUpdate()>0)
			b=true;
		conn.close();
		return b;
	}

	@Override
	public List<User> findAll() throws Exception {
		List<User>all=new ArrayList<User>();
		conn=Utils.getConnection();
		String sql="select * from users";
		this.pstmt=this.conn.prepareStatement(sql);
		ResultSet rs=this.pstmt.executeQuery();
		User u1=null;
		
		while(rs.next())
		{
			u1=new User();
			u1.setId(rs.getInt(1));
			u1.setUsername(rs.getString(2));
			u1.setPassword(rs.getString(3));
			u1.setState(rs.getString(4));
			all.add(u1);
		}
		this.pstmt.close();
		conn.close();
		return all;
	}

	@Override
	public User findById(int userId) throws Exception {
		User u1=null;
		conn=Utils.getConnection();
		String sql="select * from users where user_id=?";
		this.pstmt=this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, userId);
		ResultSet rs=this.pstmt.executeQuery();
		if(rs.next())
		{
			u1=new User();
			u1.setId(rs.getInt(1));
			u1.setUsername(rs.getString(2));
			u1.setPassword(rs.getString(3));
			u1.setState(rs.getString(4));
		}
		this.pstmt.close();
		conn.close();
		return u1;
	}

	@Override
	public User findByName(String username) throws Exception {
		User u1=null;
		conn=Utils.getConnection();
		String sql="select * from users where username=?";
		this.pstmt=this.conn.prepareStatement(sql);
		this.pstmt.setString(1, username);
		ResultSet rs=this.pstmt.executeQuery();
		if(rs.next())
		{
			u1=new User();
			u1.setId(rs.getInt(1));
			u1.setUsername(rs.getString(2));
			u1.setPassword(rs.getString(3));
			u1.setState(rs.getString(4));
		}
		this.pstmt.close();
		conn.close();
		return u1;
	}


	@Override
	public boolean setUserActive(int userId) throws Exception {
		boolean b=false;
		conn=Utils.getConnection();
		String sql="update users set state='active' where user_id=?";
		this.pstmt=this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, userId);
		if(this.pstmt.executeUpdate()>0)
		{
			b=true;
		}
		conn.close();
		return b;
	}

	@Override
	public boolean setUserLocked(int userId) throws Exception {
		boolean b=false;
		conn=Utils.getConnection();
		String sql="update users set state='locked' where user_id=?";
		this.pstmt=this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, userId);
		if(this.pstmt.executeUpdate()>0)
		{
			b=true;
		}
		conn.close();
		return b;
	}

}
