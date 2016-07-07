package com.news.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.news.dao.proxy.IUserDAOProxy;
import com.news.entity.User;

@WebServlet("/DeleteUserServlet")
public class DeleteUserServlet extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse resp)
		throws ServletException,IOException
	{
		int userid=Integer.parseInt(req.getParameter("userid"));
		try {
			IUserDAOProxy idao=new IUserDAOProxy();
			idao.doDelete(userid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void doPost(HttpServletRequest req,HttpServletResponse resp)
		throws ServletException,IOException
	{
		this.doGet(req, resp);
	}

}
