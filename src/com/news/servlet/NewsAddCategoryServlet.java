package com.news.servlet;

import java.io.IOException;

/**
 * 
 * 给新闻添加标签
 */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.news.dao.proxy.NewsAddCategoryProxy;
import com.news.entity.News_Add_Category_Ent;


@WebServlet("/NewsAddCategoryServlet")
public class NewsAddCategoryServlet extends HttpServlet{

	private News_Add_Category_Ent ent;
	private NewsAddCategoryProxy nacpro;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int type_id=0;
		int news_id=0;
		ent=new News_Add_Category_Ent();
		type_id=Integer.parseInt(req.getParameter("type_id"));// 从req接收一个标签ID和新闻ID
		news_id=Integer.parseInt(req.getParameter("news_id"));
		ent.setNews_id(news_id);
		ent.setType_id(type_id);
		nacpro=new NewsAddCategoryProxy();
		
		/**
		 * 如果返回插入成功  返回Request Attribute 键 NACSInfo，值 1    否则返回 0;
		 */
		if(nacpro.newsAddCategory(ent)==1)
			req.setAttribute("NACSInfo", "1");
		else
			req.setAttribute("NACSInfo", "1");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}

}
