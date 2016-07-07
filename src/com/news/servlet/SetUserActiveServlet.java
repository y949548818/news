package com.news.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.news.dao.proxy.IUserDAOProxy;

@WebServlet("/SetUserActiveServlet")
public class SetUserActiveServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException 
	{
		int userId=Integer.parseInt(req.getParameter("userid"));
		try {
			IUserDAOProxy idao=new IUserDAOProxy();
			if(idao.setUserActive(userId))
				resp.getWriter().print("ok");
			else
				resp.getWriter().print("error");
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
