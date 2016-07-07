package com.news.dao;

import java.util.List;

import com.news.entity.News;

public interface INewsDao {
	/**
	 * ����һ���µ�����
	 * @return �����Ƿ���ӳɹ�
	 */
	boolean doCreate(News news);
	/**
	 * 
	 * @param news
	 * @return �����޸ĵĸ���
	 */
	boolean doUpdate(News news);
	/**
	 * ɾ��һ������
	 * @param id ����id
	 * @return �����Ƿ�ɹ�
	 */
	boolean doDelete(int id);
	/**
	 * �����Ƿ��������
	 * @param id news id
	 * @param isCanComment
	 */
	boolean setCanComment(int id ,boolean isCanComment);
	/**
	 * ͨ��id������Ӧ��news ע����ȡ�������ͨ��������
	 * @param id
	 * @return 
	 */
	News findById(int id);
	/**
	 * �������е�news
	 * @return ��ȡ�������ͨ��������
	 */
	List<News> findAll();
	/**
	 * ע����ȡ�������ͨ��������
	 * @param start ��ʼ��id
	 * @param count һ��Ҫ��ȡ���ٸ�news
	 * @return 
	 */
	List<News> findListByNumber(int start,int count);
	
	/**
	 * �������ŵ����״̬
	 * 
	 * @param id ����id
	 * @param state 1����ʾ���ͨ�� 0:��ʾ���δͨ��
	 * @return
	 */
	boolean setCheckState(int id,int state);
	/**
	 * ��ȡ�������δͨ��������
	 * @return
	 */
	List<News> findAllForUnchecked();
	/**
	 * ע����ȡ�������δͨ��������
	 * @param start ��ʼ��id
	 * @param count һ��Ҫ��ȡ���ٸ�news
	 * @return 
	 */
	List<News> findListByNumberForUnchecked(int start,int count);
	
}
