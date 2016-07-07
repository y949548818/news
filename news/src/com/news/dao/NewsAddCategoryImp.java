package com.news.dao;

import java.util.List;

import com.news.entity.NewsCategoryEnt;
import com.news.entity.News_Add_Category_Ent;

public interface NewsAddCategoryImp {
	/**
	 * �����żӱ���ʱ ���news_to_type����Ӽ�¼
	 * @param News_Add_Category_Ent ʵ��
	 * @return �����޸ĵ�����  int��  0��ʾ��Ч 1���ǲ���ɹ�  ����1��������
	 */
	public int newsAddCategory(News_Add_Category_Ent ent);
	public List<NewsCategoryEnt> findCategoryByNewsId(int newsid);
}
