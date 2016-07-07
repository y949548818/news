package com.news.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.news.dao.proxy.IAdminDAOProxy;
import com.news.entity.User;

/**
 * Servlet implementation class AdminLoginServlet
 */
@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest req, HttpServletResponse resp)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("gbk");
		resp.setCharacterEncoding("gbk");
		String adminname=req.getParameter("adminname");
		String adminpassword=req.getParameter("adminpassword");
		IAdminDAOProxy idao=new IAdminDAOProxy();
		User u1=idao.findByName(adminname);
		if(u1==null||!u1.getPassword().equals(adminpassword))
		{
			resp.getWriter().print("error");
			System.out.println(adminname+" "+adminpassword);
			req.getSession().removeAttribute("adminname");
			req.getSession().removeAttribute("admin_id");
		}
		else
		{
			System.out.println(u1.toString());
			resp.getWriter().print("ok");
			req.getSession().setAttribute("adminname", adminname);
			req.getSession().setAttribute("admin_id", u1.getId());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest req, HttpServletResponse resp)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
