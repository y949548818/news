package com.news.dao;

import java.util.List;

import com.news.entity.News;

public interface INewsDao {
	/**
	 * 创建一条新的新闻
	 * @return 返回是否添加成功
	 */
	boolean doCreate(News news);
	/**
	 * 
	 * @param news
	 * @return 返回修改的个数
	 */
	boolean doUpdate(News news);
	/**
	 * 删除一条新闻
	 * @param id 新闻id
	 * @return 返回是否成功
	 */
	boolean doDelete(int id);
	/**
	 * 设置是否可以评论
	 * @param id news id
	 * @param isCanComment
	 */
	boolean setCanComment(int id ,boolean isCanComment);
	/**
	 * 通过id查找相应的news 注：获取的是审核通过的新闻
	 * @param id
	 * @return 
	 */
	News findById(int id);
	/**
	 * 查找所有的news
	 * @return 获取的是审核通过的新闻
	 */
	List<News> findAll();
	/**
	 * 注：获取的是审核通过的新闻
	 * @param start 开始的id
	 * @param count 一共要获取多少个news
	 * @return 
	 */
	List<News> findListByNumber(int start,int count);
	
	/**
	 * 设置新闻的审核状态
	 * 
	 * @param id 新闻id
	 * @param state 1：表示审核通过 0:表示审核未通过
	 * @return
	 */
	boolean setCheckState(int id,int state);
	/**
	 * 获取所有审核未通过的新闻
	 * @return
	 */
	List<News> findAllForUnchecked();
	/**
	 * 注：获取的是审核未通过的新闻
	 * @param start 开始的id
	 * @param count 一共要获取多少个news
	 * @return 
	 */
	List<News> findListByNumberForUnchecked(int start,int count);
	
}
