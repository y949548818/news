package com.news.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.news.dao.proxy.CommentsPro;
import com.news.entity.CommentsEnt;
@WebServlet("/ReturnCommXMLServlet")
public class ReturnCommXMLServlet extends HttpServlet{
	private CommentsPro cep;
	private String xmlstr="";
	private List<CommentsEnt> list;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		int news_id;
		news_id=Integer.parseInt(req.getParameter("newsid"));
		System.out.println(news_id);
		cep=new CommentsPro();
		list=new ArrayList<CommentsEnt>();
		list=cep.selectComm(news_id);
		int trnum=0;
		StringBuilder sb=new StringBuilder();
		for(CommentsEnt ent : list){
//			xmlstr=xmlstr+"<tr align='center' name='delbtn'>"+"<td id="+"del"+trnum+">"+ent.getComments_id()+"</td>"+"<td>"+ent.getUser_id()+"</td>"+"<td>"+ent.getComments_detail()+"</td>"+"<td>"+
//					ent.getComments_date()+"</td>"+"<td>"+"<input type='button' value='É¾³ý' name='delb' onclick='DelBtn(this)'>"+"</td>"+"</tr>";
			sb.append("<tr align='center' name='delbtn'>")
			.append("<td id=")
			.append("del")
			.append(trnum)
			.append(">")
			.append(ent.getComments_id())
			.append("</td>")
			.append("<td>")
			.append(ent.getUser_id())
			.append("</td>")
			.append("<td>")
			.append(ent.getComments_detail())
			.append("</td>")
			.append("<td>")
			.append(ent.getComments_date())
			.append("</td>")
			.append("<td>")
			.append("<input type='button' value='É¾³ý' name='delb' onclick='DelBtn(this)'>")
			.append("</td>")
			.append("</tr>");
			//xmlstr=xmlstr+"<Item>"+"<Userid>"+ ent.getUser_id() +"</Userid>"+"<detail>"+ent.getComments_detail()+"</detail>"+"<date>"+ent.getComments_date()+"</date>"+"</Item>";
			trnum++;
		}
		//xmlstr="<table>"+xmlstr+"</table>";
		System.out.println("xmlLength:"+xmlstr.length());
		System.out.println("sb:"+sb.length());
		resp.setCharacterEncoding("GBK");
		resp.setContentType("text/html;charset=GBK");
		PrintWriter out = resp.getWriter();
//		out.println(xmlstr);
		out.println(sb.toString());
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}

}
