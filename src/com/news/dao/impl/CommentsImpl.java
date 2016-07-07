package com.news.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.news.dao.CommentsInt;
import com.news.entity.CommentsEnt;
import com.news.utils.Utils;

public class CommentsImpl implements CommentsInt{

	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rs;
	private CommentsEnt ent;
	private List<CommentsEnt> list;
	
	public CommentsImpl(Connection con) {
		// TODO Auto-generated constructor stub
		this.conn=con;
		ent=new CommentsEnt();
	}
	@Override
	public CommentsEnt findById(int id) {
		// TODO Auto-generated method stub
		String sql="select * from comments where comments_id=?";
		conn=Utils.getConnection();
		try {
			pst=conn.prepareStatement(sql);
			pst.setInt(1, id);
			rs=pst.executeQuery();
			while(rs.next()){
				ent=new CommentsEnt();
				ent.setComments_id(rs.getInt(1));
				ent.setComments_detail(rs.getString(2));
				ent.setComments_date(rs.getDate(3).toString());
				ent.setUser_id(rs.getInt(4));
				ent.setNews_id(rs.getInt(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return ent;
	}

	@Override
	public List<CommentsEnt> selectComm(int news_id) {
		// TODO Auto-generated method stub
		String sql="select * from comments where news_id=?";
		conn=Utils.getConnection();
		list=new ArrayList<CommentsEnt>();
		try {
			pst=conn.prepareStatement(sql);
			pst.setInt(1,news_id);
			rs=pst.executeQuery();
			while(rs.next()){
				ent=new CommentsEnt();
				ent.setComments_id(rs.getInt(1));
				ent.setComments_detail(rs.getString(2));
//				ent.setComments_date(rs.getDate(3).toString());
				ent.setComments_date(rs.getString(3));
				ent.setUser_id(rs.getInt(4));
				ent.setNews_id(rs.getInt(5));
				list.add(ent);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return list;
	}

	@Override
	public int deleteComm(CommentsEnt ent) {
		// TODO Auto-generated method stub
		int num=0;
		String sql="delete from comments where comments_id=?";
		conn=Utils.getConnection();
		try {
			pst=conn.prepareStatement(sql);
			pst.setInt(1, ent.getComments_id());
			num=pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return num;
	}

	@Override
	public int insertComm(CommentsEnt ent) {
		// TODO Auto-generated method stub
		int num=0;
		String sql="insert into comments(comments_detail,comments_date,user_id,news_id) values(?,?,?,?)";
		conn=Utils.getConnection();
		try {
			pst=conn.prepareStatement(sql);
//			pst.setInt(1, ent.getComments_id());
			pst.setString(1, ent.getComments_detail());
			pst.setString(2, ent.getComments_date());
			pst.setInt(3, ent.getUser_id());
			pst.setInt(4, ent.getNews_id());
			num=pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return num;
	}

}
