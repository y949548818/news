package com.news.test;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.mysql.fabric.xmlrpc.base.Data;
import com.news.dao.impl.UserDAOImp1;
import com.news.dao.proxy.CommentsPro;
import com.news.dao.proxy.IUserDAOProxy;
import com.news.dao.proxy.NewsAddCategoryProxy;
import com.news.dao.proxy.NewsDaoProxy;
import com.news.entity.CommentsEnt;
import com.news.entity.News;
import com.news.utils.Utils;

public class MyTest {
	NewsDaoProxy proxy=null;
	@Before
	public void before(){
		proxy=new NewsDaoProxy();
	}
	/**
	 * 测试连接是否可用
	 */
	@Test
	public void test1(){
		Connection con=Utils.getConnection();
		System.out.println(con);
	}
	/**
	 * 测试插入news
	 */
	@Test
	public void test2(){
//		News news=new News("context", "title", "imageURL", 1, "2010-10-10");
		News news2=new News("context2", "title2", "imageURL2", 1, "2010-10-10");
		News news3=new News("context3", "title3", "imageURL3", 1, "2010-10-10");
		proxy.doCreate(news2);
		proxy.doCreate(news3);
	}
	/**
	 * 测试findbyid
	 */
	@Test
	public void test3(){
		News news=proxy.findById(1);
		System.out.println(news);
	}
	@Test
	public void test4(){
		List<News> lists=proxy.findAll();
		System.out.println(lists);
	}
	@Test
	public void test5(){
		List<News> lists=proxy.findListByNumber(1, 2);
		System.out.println(lists);
	}
	/**
	 * 测试修改功能
	 */
	@Test
	public void test6(){
		News news=proxy.findById(1);
//		news.setContent("修改后的内容");
		news.setCanComment(true);
		proxy.doUpdate(news);
	}
	@Test
	public void test7(){
		proxy.doDelete(5);
	}
	
	@Test
	public void test8(){
		proxy.setCanComment(1, false);
	}
	/**
	 * 测试添加评论
	 */
	@Test
	public void test9(){
		CommentsEnt com=new CommentsEnt();
		com.setComments_date("2010-10-10");
		com.setComments_detail("lolol");
		com.setNews_id(1);
		com.setUser_id(1);
		CommentsPro pro=new CommentsPro();
		pro.insertComm(com);
		
	}
	@Test
	public void test10(){
		SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-DD HH:mm:SS");
		
		System.out.println(sdf.format(new Date()));
	}
	@Test
	public void test11(){
		CommentsPro pro=new CommentsPro();
		System.out.println(pro.selectComm(1).size());
	}
	@Test
	public void test12(){
		IUserDAOProxy p=new IUserDAOProxy();
		System.out.println(p.findAll());
	}
	/**
	 * 通过新闻id查找标签
	 */
	@Test
	public void test13(){
		NewsAddCategoryProxy proxy=new NewsAddCategoryProxy();
		System.out.println(proxy.findCategoryByNewsId(2).size());
		System.out.println(proxy.findCategoryByNewsId(1).size());
	}
}
