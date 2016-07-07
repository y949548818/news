package com.news.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.news.dao.NewsCategoryImp;
import com.news.entity.NewsCategoryEnt;
import com.news.utils.Utils;

public class NewsCategoryImpl implements NewsCategoryImp{
	
	private Connection conn;
	private PreparedStatement pst;
	public NewsCategoryImpl(Connection con){
		this.conn=con;
	}
	@Override
	public int addCategory(String category) {
		// TODO Auto-generated method stub
		int num=0;
		conn=Utils.getConnection();
		try {
			String sql="insert into newstype(type)values(?)";
			this.pst=this.conn.prepareStatement(sql);
			this.pst.setString(1, category);
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
	public int deleteCategory(int id) {
		// TODO Auto-generated method stub
		int num=0;
		conn=Utils.getConnection();
		try {
			String sql="delete from newstype where type_id=?";
			this.pst=this.conn.prepareStatement(sql);
			this.pst.setInt(1, id);
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
	public int updateCategory(int id,String category) {
		// TODO Auto-generated method stub
		
		int num=0;
		conn=Utils.getConnection();
		try {
			String sql="update newstype set type=? where type_id=?";
			this.pst=this.conn.prepareStatement(sql);
			this.pst.setString(1, category);
			this.pst.setInt(2, id);
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
	public NewsCategoryEnt findById(int id){
		NewsCategoryEnt nce=null;
		return nce;
	}
	@Override
	public List<NewsCategoryEnt> findAll() {
		// TODO Auto-generated method stub
		String sql="select * from newstype";
		List list=null;
		conn=Utils.getConnection();
		ResultSet rs=null;
		NewsCategoryEnt nce=null;
		try {
			pst=conn.prepareStatement(sql);
			rs=pst.executeQuery();
			list=new ArrayList<NewsCategoryEnt>();
			while(rs.next()){
				nce=new NewsCategoryEnt();
				nce.setCategoryId(rs.getInt(1));
				nce.setCategory(rs.getString(2));
				list.add(nce);
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
		
		return list;
	}

}
