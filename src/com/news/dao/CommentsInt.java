package com.news.dao;

import java.util.List;

import com.news.entity.CommentsEnt;

/**
 * ���۽ӿ�
 * @author Administrator
 *
 */
public interface CommentsInt {
	/**
	 * �������ݿ��е���������
	 * @return List<CommentsEnt>
	 */
	public List<CommentsEnt> selectComm(int news_id);
	/**
	 * ɾ������
	 * @param CommentsEnt
	 * @return int���� ��ʾɾ������
	 */
	public int deleteComm(CommentsEnt ent);
	/**
	 * �������
	 * @param CommentsEnt
	 * @return int���� ��ʾ��������
	 */
	public int insertComm(CommentsEnt ent);
	/**
	 * ͨ��id������
	 * @param id (int��)
	 * @return CommentsEnt
	 */
	public CommentsEnt findById(int id);
	
}
