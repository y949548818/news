package com.news.servlet;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.news.dao.proxy.*;
/**
 * ɾ����ǩ
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
		String str=req.getParameter("type_id");//��req����һ����ǩid����
		type_id=Integer.parseInt(str);
		num=ncp.deleteCategory(type_id);
		
		if(num==1)
			req.setAttribute("categorydeleteinfo", "1");//ɾ���ɹ�
		else
			req.setAttribute("categorydeleteinfo", "0");//ɾ��ʧ��
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}
	
}
