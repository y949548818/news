package com.news.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.news.dao.proxy.CommentsPro;
import com.news.entity.CommentsEnt;

@WebServlet("/CommentsDeleteCommServlet")
public class CommentsDeleteCommServlet extends HttpServlet{

	private CommentsPro pro;
	private CommentsEnt ent;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int num=0;
		pro=new CommentsPro();
		System.out.println(req.getParameter("comm_id"));
		ent=pro.findById(Integer.parseInt(req.getParameter("comm_id")));
		pro.deleteComm(ent);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}

}
