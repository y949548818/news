package com.news.servlet;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.news.dao.proxy.NewsCategoryPro;

@WebServlet("/CategoryServletInsert")
public class CategoryServletInsert extends  HttpServlet{
	private NewsCategoryPro ncp;
	private int type_id;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int num=0;
		ncp=new NewsCategoryPro();
		String str=req.getParameter("type");//req接收一个标签类型即可
		num=ncp.addCategory(str);
		if(num==1)
			req.setAttribute("categoryinsertinfo", "1");//插入成功
		else
			req.setAttribute("categoryinsertinfo", "0");//插入失败
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}
	
}
