package com.news.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.news.dao.NewsAddCategoryImp;
import com.news.entity.News;
import com.news.entity.NewsCategoryEnt;
import com.news.entity.News_Add_Category_Ent;
import com.news.utils.Utils;

public class NewsAddCategoryImpl implements NewsAddCategoryImp{

	private Connection conn;
	private PreparedStatement pst;
	private NewsCategoryEnt ent;
	public NewsAddCategoryImpl(Connection con) {
		// TODO Auto-generated constructor stub
		conn=con;
	}

	@Override
	public int newsAddCategory(News_Add_Category_Ent ent) {
		// TODO Auto-generated method stub
		int num=0;
		String sql="insert into news_to_type values(?,?)";
		conn=Utils.getConnection();
		try {
			pst=conn.prepareStatement(sql);
			pst.setInt(1, ent.getType_id());
			pst.setInt(2, ent.getNews_id());
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
	public List<NewsCategoryEnt> findCategoryByNewsId(int newsid) {
		// TODO Auto-generated method stub
		List<NewsCategoryEnt>list=null;
		conn=Utils.getConnection();
		
		try{
			list=new ArrayList<NewsCategoryEnt>();
			String sql="select * from news_to_type inner join newstype where newsid=? and (news_to_type.typeid=newstype.type_id)";
			pst=conn.prepareStatement(sql);
			pst.setInt(1, newsid);
			ResultSet rs=pst.executeQuery();
			while(rs.next()){
				ent=new NewsCategoryEnt();
				ent.setCategoryId(rs.getInt(rs.findColumn("type_id")));
				ent.setCategory(rs.getString(rs.findColumn("type")));
				list.add(ent);
			}
			
		}catch(Exception e){
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
