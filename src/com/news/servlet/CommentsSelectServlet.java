package com.news.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.news.dao.proxy.CommentsPro;
import com.news.entity.CommentsEnt;

@WebServlet("/CommentsSelectServlet")
public class CommentsSelectServlet extends HttpServlet{

	private CommentsPro pro;
	private List list;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("GBK");
		resp.setCharacterEncoding("GBK");
		resp.setContentType("text/html;charset=GBK");
		pro=new CommentsPro();
		list=new ArrayList<CommentsEnt>();
		String news_id=req.getParameter("news_id");
		System.out.println(news_id);
		if(news_id!=null&&"".equals(news_id));
		{
			list=pro.selectComm(Integer.parseInt(news_id));
		}
		
		JSONObject object=new JSONObject();
		object.put("list", list);
		System.out.println(list);
		System.out.println(object.toJSONString());
		resp.getWriter().println(object.toJSONString());
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}

}
