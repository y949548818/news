package com.news.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.news.dao.proxy.CommentsPro;
import com.news.entity.CommentsEnt;

@WebServlet("/CommentsInsertServlet")
public class CommentsInsertServlet extends HttpServlet{

	private CommentsEnt ent;
	private CommentsPro pro;
	
	/**
	 * req需要的值       1评论id 2评论内容  3评论日期  4用户id  5新闻id
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		pro=new CommentsPro();
		ent=new CommentsEnt();
//		ent.setComments_id(Integer.parseInt(req.getParameter("comments_id")));
		ent.setComments_detail(req.getParameter("comments_detail"));
//		ent.setComments_date(req.getParameter("comments_date"));
		SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-DD HH:mm");
		ent.setComments_date(sdf.format(new Date()));
		ent.setUser_id(Integer.parseInt(req.getParameter("user_id")));
		ent.setNews_id(Integer.parseInt(req.getParameter("news_id")));
		int count=pro.insertComm(ent);
		if(count>0)
		{
			System.out.println("新增一条评论");
			resp.getWriter().print("ok");
		}
		else
		{
			resp.getWriter().print("error");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}

}
