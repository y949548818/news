package com.news.servlet;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.news.dao.proxy.*;
/**
 * 删除标签
 * @author Administrator
 *
 */
@WebServlet("/CategoryServletDelete")
public class CategoryServletDelete extends  HttpServlet{
	private NewsCategoryPro ncp;
	private int type_id;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int num=0;
		ncp=new NewsCategoryPro();
		String str=req.getParameter("type_id");//从req接受一个标签id即可
		type_id=Integer.parseInt(str);
		num=ncp.deleteCategory(type_id);
		
		if(num==1)
			req.setAttribute("categorydeleteinfo", "1");//删除成功
		else
			req.setAttribute("categorydeleteinfo", "0");//删除失败
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}
	
}
