package com.news.dao.proxy;

import java.util.List;

import com.news.dao.INewsDao;
import com.news.dao.impl.NewsDaoImpl;
import com.news.entity.News;

public class NewsDaoProxy implements INewsDao{
	
	INewsDao dao=null;
	public NewsDaoProxy() {
		this.dao=new NewsDaoImpl();
	}
	
	@Override
	public boolean setCheckState(int id, int state) {
		// TODO Auto-generated method stub
		boolean flag=dao.setCheckState(id, state);
		if(flag)
		{
			System.out.println("�޸ĳɹ�");
		}
		else{
			System.out.println("�޸�ʧ��");
		}
		return flag;
	}

	@Override
	public boolean doCreate(News news) {
		// TODO Auto-generated method stub
		boolean flag=dao.doCreate(news);
		if(flag)System.out.println("����ɹ�");
		else System.out.println("����ʧ��");
		return flag;
	}
	@Override
	public News findById(int id) {
		// TODO Auto-generated method stub
		News news=dao.findById(id);
		if(news==null)
		{
			System.out.println("����ʧ��");
			return news;
		}
		else{
			System.out.println("���ҳɹ�");
			return news;
		}
	}

	@Override
	public boolean doUpdate(News news) {
		// TODO Auto-generated method stub
		boolean flag=dao.doUpdate(news);
		if(flag)
		{
			System.out.println("�޸ĳɹ�");
		}
		else
		{
			System.out.println("�޸�ʧ��");
		}
		return flag;
	}


	@Override
	public List<News> findAllForUnchecked() {
		// TODO Auto-generated method stub
		return dao.findAllForUnchecked();
	}

	@Override
	public List<News> findListByNumberForUnchecked(int start, int count) {
		// TODO Auto-generated method stub
		return dao.findListByNumberForUnchecked(start, count);
	}

	@Override
	public List<News> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public List<News> findListByNumber(int start, int count) {
		// TODO Auto-generated method stub
		return dao.findListByNumber(start, count);
	}

	@Override
	public boolean doDelete(int id) {
		// TODO Auto-generated method stub
		boolean flag=dao.doDelete(id);
		if(flag)
		{
			System.out.println("ɾ���ɹ�");
		}
		else{
			System.out.println("ɾ��ʧ��");
		}
		return flag;
	}

	@Override
	public boolean setCanComment(int id,boolean isCanComment) {
		// TODO Auto-generated method stub
		boolean flag=dao.setCanComment(id,isCanComment);
		if(flag)
		{
			System.out.println("�޸ĳɹ�");
		}
		else{
			System.out.println("�޸�ʧ��");
		}
		return flag;
	}

}
