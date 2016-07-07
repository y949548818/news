package com.news.servlet;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.news.dao.proxy.*;

@WebServlet("/CategoryServletUpdate")
public class CategoryServletUpdate extends  HttpServlet{
	private NewsCategoryPro ncp;
	private String category;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int num=0;
		ncp=new NewsCategoryPro();
		String id=req.getParameter("id");//  从req接收需要改变的标签  的ID和一个标签名
		String str=req.getParameter("category");
		num=ncp.updateCategory(Integer.parseInt(id),str);
		
		if(num==1)
			req.setAttribute("categoryupdateinfo", "1");//更新成功
		else
			req.setAttribute("categoryupdateinfo", "0");//跟新失败
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}
	
}
