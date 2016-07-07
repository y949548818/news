package com.news.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.news.dao.proxy.NewsAddCategoryProxy;

public class FindCategoryByNewsIdServlet extends HttpServlet {
	private NewsAddCategoryProxy nacp;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int newsid;
		newsid=Integer.parseInt(req.getParameter("newsid"));
		nacp=new NewsAddCategoryProxy();
		req.setAttribute("CategoryList",nacp.findCategoryByNewsId(newsid) );
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}
	
}
