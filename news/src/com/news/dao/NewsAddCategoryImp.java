package com.news.dao;

import java.util.List;

import com.news.entity.NewsCategoryEnt;
import com.news.entity.News_Add_Category_Ent;

public interface NewsAddCategoryImp {
	/**
	 * 给新闻加标题时 向表news_to_type中添加记录
	 * @param News_Add_Category_Ent 实力
	 * @return 返回修改的行数  int型  0表示无效 1表是插入成功  大于1则插入错误
	 */
	public int newsAddCategory(News_Add_Category_Ent ent);
	public List<NewsCategoryEnt> findCategoryByNewsId(int newsid);
}
