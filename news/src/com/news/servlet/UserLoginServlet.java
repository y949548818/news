package com.news.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.news.dao.proxy.IUserDAOProxy;
import com.news.entity.User;

@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse resp)
			throws ServletException,IOException
	{
		req.setCharacterEncoding("GBK");
		resp.setCharacterEncoding("GBK");
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		try {
			IUserDAOProxy idao=new IUserDAOProxy();
			User u1=idao.findByName(username);
			if(u1==null || u1.getPassword().equals(password)!=true)
			{
				System.out.println("δ�ҵ��û�");
				String info ="�û������������";
				req.setAttribute("info", info);
				req.getSession().removeAttribute("username");
				req.getSession().removeAttribute("user_id");
				
				resp.getWriter().print("error");
			}
			else
			{
				System.out.println("�ҵ��û�");
//				resp.getWriter().println("��½�ɹ���");
				req.getSession().setAttribute("username", username);
				req.getSession().setAttribute("user_id", u1.getId());
//				resp.sendRedirect("index.jsp");
				resp.getWriter().print("ok");
			}
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
