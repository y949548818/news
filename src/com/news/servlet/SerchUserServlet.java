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

@WebServlet("/SerchUserServlet")
public class SerchUserServlet extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse resp)
		throws ServletException,IOException
	{
		String state=req.getParameter("state");
		//List<String> info=new ArrayList<String>();
		if(state.equals("all")==true)
		{
			try {
				IUserDAOProxy idao=new IUserDAOProxy();
				List<User> allUser=idao.findAll();
				req.setAttribute("allUser", allUser);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(state.equals("byId")==true)
		{
			int userId=Integer.parseInt(req.getParameter("byid"));
			try {
				IUserDAOProxy idao=new IUserDAOProxy();
				User u1=idao.findById(userId);
				req.setAttribute("userbyid", u1);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(state.equals("byName")==true)
		{
			String username=req.getParameter("byName");
			try {
				IUserDAOProxy idao=new IUserDAOProxy();
				User u1=idao.findByName(username);
				req.setAttribute("userbyname", u1);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void doPost(HttpServletRequest req,HttpServletResponse resp)
	throws ServletException,IOException
	{
		this.doGet(req, resp);
	}

}
