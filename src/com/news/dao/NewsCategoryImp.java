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
	 * ͨ�� ����id ����  ��ǩ
	 * @param id
	 * @return  list<NewsCategoryEnt>
	 */
	public NewsCategoryEnt findById(int id);
}