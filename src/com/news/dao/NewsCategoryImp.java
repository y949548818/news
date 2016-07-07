package com.news.dao;

import java.util.List;

import com.news.entity.NewsCategoryEnt;

public interface NewsCategoryImp {
	public int	addCategory(String category);
	public int updateCategory(int id,String category);
	public int deleteCategory(int id);
	public List<NewsCategoryEnt> findAll();
	
	/**
	 * 
	 * 通过 新闻id 查找  标签
	 * @param id
	 * @return  list<NewsCategoryEnt>
	 */
	public NewsCategoryEnt findById(int id);
}