package com.news.dao;

import java.util.List;

import com.news.entity.CommentsEnt;

/**
 * 评论接口
 * @author Administrator
 *
 */
public interface CommentsInt {
	/**
	 * 查找数据库中的所有评论
	 * @return List<CommentsEnt>
	 */
	public List<CommentsEnt> selectComm(int news_id);
	/**
	 * 删除评论
	 * @param CommentsEnt
	 * @return int数据 表示删除行数
	 */
	public int deleteComm(CommentsEnt ent);
	/**
	 * 添加评论
	 * @param CommentsEnt
	 * @return int数据 表示插入行数
	 */
	public int insertComm(CommentsEnt ent);
	/**
	 * 通过id找评论
	 * @param id (int型)
	 * @return CommentsEnt
	 */
	public CommentsEnt findById(int id);
	
}
