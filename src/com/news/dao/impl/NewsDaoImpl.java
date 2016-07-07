package com.news.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.news.dao.INewsDao;
import com.news.entity.News;
import com.news.utils.Utils;

public class NewsDaoImpl implements INewsDao {
	private Connection conn=null;
	private PreparedStatement pst=null;
	@Override
	public boolean doCreate(News news) {
		try {
			conn=Utils.getConnection();
			String content=news.getContent();
			String date=news.getDate();
			String title=news.getTitle();
			String imageUrl=news.getImageUrl();
			int user_id=news.getUser_id();
			String sql="insert into news(news_title,news_detail,news_date,news_author,news_image) values(?,?,?,?,?)";
			pst=conn.prepareStatement(sql);
			pst.setString(1, title);
			pst.setString(2, content);
			pst.setString(3, date);
			pst.setInt(4,user_id);
			pst.setString(5, imageUrl);
			int count=pst.executeUpdate();
			if(count>0)return true;
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
		return false;

	}



	@Override
	public News findById(int id) {
		// TODO Auto-generated method stub
		
		try {
			News news=new News();
			conn=Utils.getConnection();
			String sql="select * from news where news_id = ?";
			
			pst=conn.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet res=pst.executeQuery();
			if(res.next())
			{
//				System.out.println(res.findColumn("news_id"));
//				System.out.println(res.findColumn("news_title"));
//				System.out.println(res.findColumn("news_detail"));
//				System.out.println(res.findColumn("news_date"));
//				System.out.println(res.findColumn("news_author"));
//				System.out.println(res.findColumn("news_image"));
				
				news.setId(res.getInt(res.findColumn("news_id")));
				news.setTitle(res.getString(res.findColumn("news_title")));
				news.setContent(res.getString(res.findColumn("news_detail")));
				news.setDate(res.getString(res.findColumn("news_date")));
				news.setUser_id(res.getInt(res.findColumn("news_author")));
				news.setImageUrl(res.getString(res.findColumn("news_image")));
				news.setCanComment((res.getInt(res.findColumn("cancomment"))==1)?true:false);
				news.setCommentNumber(res.getInt(res.findColumn("commentNumber")));
			}
			return news;
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
		return null;
	}

	@Override
	public List<News> findAll() {
		// TODO Auto-generated method stub
		try {
			List<News> lists=new ArrayList<News>();
			News news=null;
			conn=Utils.getConnection();
			String sql="select * from news where checked=1";
			
			pst=conn.prepareStatement(sql);
			ResultSet res=pst.executeQuery();
			while(res.next())
			{
				news=new News();
				
				news.setId(res.getInt(res.findColumn("news_id")));
				news.setTitle(res.getString(res.findColumn("news_title")));
				news.setContent(res.getString(res.findColumn("news_detail")));
				news.setDate(res.getString(res.findColumn("news_date")));
				news.setUser_id(res.getInt(res.findColumn("news_author")));
				news.setImageUrl(res.getString(res.findColumn("news_image")));
				news.setCanComment((res.getInt(res.findColumn("cancomment"))==1)?true:false);
				news.setCommentNumber(res.getInt(res.findColumn("commentNumber")));
				lists.add(news);
			}
			return lists;
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
		return null;
	}

	@Override
	public List<News> findAllForUnchecked() {
		// TODO Auto-generated method stub
		try {
			List<News> lists=new ArrayList<News>();
			News news=null;
			conn=Utils.getConnection();
			String sql="select * from news where checked=0";
			
			pst=conn.prepareStatement(sql);
			ResultSet res=pst.executeQuery();
			while(res.next())
			{
				news=new News();
				
				news.setId(res.getInt(res.findColumn("news_id")));
				news.setTitle(res.getString(res.findColumn("news_title")));
				news.setContent(res.getString(res.findColumn("news_detail")));
				news.setDate(res.getString(res.findColumn("news_date")));
				news.setUser_id(res.getInt(res.findColumn("news_author")));
				news.setImageUrl(res.getString(res.findColumn("news_image")));
				news.setCanComment((res.getInt(res.findColumn("cancomment"))==1)?true:false);
				news.setCommentNumber(res.getInt(res.findColumn("commentNumber")));
				lists.add(news);
			}
			return lists;
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
		return null;
	}



	@Override
	public List<News> findListByNumberForUnchecked(int start, int count) {
		// TODO Auto-generated method stub
		try {
			List<News> lists=new ArrayList<News>();
			News news=null;
			conn=Utils.getConnection();
			String sql="select * from news  where checked=0 limit ?,?";
			
			pst=conn.prepareStatement(sql);
			pst.setInt(1, start);
			pst.setInt(2, count);
			ResultSet res=pst.executeQuery();
			while(res.next())
			{
				news=new News();
				
				news.setId(res.getInt(res.findColumn("news_id")));
				news.setTitle(res.getString(res.findColumn("news_title")));
				news.setContent(res.getString(res.findColumn("news_detail")));
				news.setDate(res.getString(res.findColumn("news_date")));
				news.setUser_id(res.getInt(res.findColumn("news_author")));
				news.setImageUrl(res.getString(res.findColumn("news_image")));
				news.setCanComment((res.getInt(res.findColumn("cancomment"))==1)?true:false);
				news.setCommentNumber(res.getInt(res.findColumn("commentNumber")));
				lists.add(news);
			}
			return lists;
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
		return null;
	}



	@Override
	public List<News> findListByNumber(int start, int count) {
		// TODO Auto-generated method stub
		try {
			List<News> lists=new ArrayList<News>();
			News news=null;
			conn=Utils.getConnection();
			String sql="select * from news  where checked=1 limit ?,?";
			
			pst=conn.prepareStatement(sql);
			pst.setInt(1, start);
			pst.setInt(2, count);
			ResultSet res=pst.executeQuery();
			while(res.next())
			{
				news=new News();
				
				news.setId(res.getInt(res.findColumn("news_id")));
				news.setTitle(res.getString(res.findColumn("news_title")));
				news.setContent(res.getString(res.findColumn("news_detail")));
				news.setDate(res.getString(res.findColumn("news_date")));
				news.setUser_id(res.getInt(res.findColumn("news_author")));
				news.setImageUrl(res.getString(res.findColumn("news_image")));
				news.setCanComment((res.getInt(res.findColumn("cancomment"))==1)?true:false);
				news.setCommentNumber(res.getInt(res.findColumn("commentNumber")));
				lists.add(news);
			}
			return lists;
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
		return null;
	}

	@Override
	public boolean doUpdate(News news) {
		// TODO Auto-generated method stub
		try {
			conn=Utils.getConnection();
			String content=news.getContent();
			String date=news.getDate();
			int news_id=news.getId();
			String title=news.getTitle();
			String imageUrl=news.getImageUrl();
			int cancomment=(news.isCanComment()==true)?1:0;
			int user_id=news.getUser_id();
			String sql="update  news set news_title=?,news_detail=?,news_date=?,news_author=?,news_image=?,cancomment=? where news_id=?";
			pst=conn.prepareStatement(sql);
			pst.setString(1, title);
			pst.setString(2, content);
			pst.setString(3, date);
			pst.setInt(4,user_id);
			pst.setString(5, imageUrl);
			pst.setInt(6, cancomment);
			pst.setInt(7, news_id);
			int count=pst.executeUpdate();
			if(count>0)return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;

	}
	@Override
	public boolean setCheckState(int id, int state) {
		try {
			conn=Utils.getConnection();
			String sql="update  news set checked=? where news_id=?";
			pst=conn.prepareStatement(sql);
			pst.setInt(1, state);
			pst.setInt(2, id);
			int count=pst.executeUpdate();
			if(count>0)return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	@Override
	public boolean doDelete(int id) {
		// TODO Auto-generated method stub
		try {
			conn=Utils.getConnection();
			String sql="delete from news where news_id = ?";
			pst=conn.prepareStatement(sql);
			pst.setInt(1, id);
			int count=pst.executeUpdate();
			if(count>0)return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;

	}

	@Override
	public boolean setCanComment(int id,boolean isCanComment) {
		// TODO Auto-generated method stub
		try {
			conn=Utils.getConnection();
			
			String sql="update  news set cancomment=? where news_id=?";
			pst=conn.prepareStatement(sql);
			pst.setInt(1, (isCanComment==true)?1:0);
			pst.setInt(2, id);
			int count=pst.executeUpdate();
			if(count>0)return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}


}
