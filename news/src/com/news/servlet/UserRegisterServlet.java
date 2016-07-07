package com.news.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.news.dao.proxy.IUserDAOProxy;
import com.news.dao.proxy.NewsCategoryPro;
import com.news.entity.User;

@WebServlet("/UserRegisterServlet")
public class UserRegisterServlet extends HttpServlet{
	private String username;
	private String password;
	private IUserDAOProxy idp;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		username=req.getParameter("username");
		password=req.getParameter("password");

		try {
			idp=new IUserDAOProxy();
			User us=idp.findByName(username);
			if(us==null){
				us=new User();
				us.setUsername(username);
				us.setPassword(password);
				
				if(idp.doCreate(us)){
					us=idp.findByName(username);
					req.getSession().setAttribute("username", username);
					req.getSession().setAttribute("user_id", us.getId());
					resp.getWriter().print("ok");
//					resp.sendRedirect("index.jsp");
				}
				else{
					req.setAttribute("Registerinfo", "0");
					req.getSession().removeAttribute("username");
					req.getSession().removeAttribute("user_id");
					resp.getWriter().print("error");
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}

}
