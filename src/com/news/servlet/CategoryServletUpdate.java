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
		String id=req.getParameter("id");//  ��req������Ҫ�ı�ı�ǩ  ��ID��һ����ǩ��
		String str=req.getParameter("category");
		num=ncp.updateCategory(Integer.parseInt(id),str);
		
		if(num==1)
			req.setAttribute("categoryupdateinfo", "1");//���³ɹ�
		else
			req.setAttribute("categoryupdateinfo", "0");//����ʧ��
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}
	
}
