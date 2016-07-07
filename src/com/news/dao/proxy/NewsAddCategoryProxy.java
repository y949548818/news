package com.news.dao.proxy;

import java.sql.Connection;
import java.util.List;

import com.news.dao.NewsAddCategoryImp;
import com.news.dao.impl.NewsAddCategoryImpl;
import com.news.entity.News;
import com.news.entity.NewsCategoryEnt;
import com.news.entity.News_Add_Category_Ent;
import com.news.utils.Utils;

public class NewsAddCategoryProxy implements NewsAddCategoryImp{

	private NewsAddCategoryImpl nacimpl;
	public NewsAddCategoryProxy() {
		// TODO Auto-generated constructor stub
		this.nacimpl=new NewsAddCategoryImpl(Utils.getConnection());
	}
	@Override
	public int newsAddCategory(News_Add_Category_Ent ent) {
		// TODO Auto-generated method stub
		int num=0;
		if(nacimpl.newsAddCategory(ent)==1){
			num=1;
			System.out.println("插入成功");
		}else{
			System.out.println("插入失败");
			num=0;
		}
		return num;
	}
	@Override
	public List<NewsCategoryEnt> findCategoryByNewsId(int newsid) {
		// TODO Auto-generated method stub
		return nacimpl.findCategoryByNewsId(newsid);
	}

}
