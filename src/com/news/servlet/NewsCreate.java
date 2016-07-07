package com.news.servlet;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.news.cache.NewsCache;
import com.news.dao.proxy.NewsDaoProxy;
import com.news.entity.News;
import com.news.utils.Utils;

/**
 * Servlet implementation class NewsCreate
 */
@WebServlet("/NewsCreate")
public class NewsCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewsCreate() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("GBK");
		response.setCharacterEncoding("GBK");
		uploadImageAndSaveNews(request,response);
	}
	/**
	 * ��ͼƬ����
	 * @param request
	 * @param response
	 */
	public void uploadImageAndSaveNews(HttpServletRequest request, HttpServletResponse response)
	{
		News news=new News();
		DiskFileItemFactory factory=new DiskFileItemFactory();
		String root=this.getServletContext().getRealPath("/");
		File imageRoot=new File(root,"images");
		if(!imageRoot.exists())imageRoot.mkdirs();
		System.out.println(imageRoot);
		factory.setRepository(imageRoot);
		ServletFileUpload servletFileUpload=new ServletFileUpload(factory);
		try {
			//��ȡ���з�װ��fileitem�Ĳ���
			List<FileItem>items=servletFileUpload.parseRequest(request);
			for(FileItem item:items)
			{
				//����Ǳ�����
				if(item.isFormField())
				{
					if("title".equals(item.getFieldName()))
					{
						news.setTitle(item.getString());
					}
					if("content".equals(item.getFieldName()))
					{
						news.setContent(item.getString());
					}
					if("user_id".equals(item.getFieldName()))
					{
						news.setUser_id(Integer.parseInt(item.getString()));
					}
				}
				//������ļ��Ļ�
				else{
					/**
					 * ͼƬ���ļ���
					 */
					String imageName=Utils.getMD5(item.getName()+new Date())+getLastStr(item.getName());
					news.setImageUrl("images/"+imageName);
					item.write(new File(imageRoot,imageName));
				
//					NewsCache.refresh();
//					System.out.println("����ˢ��");
				}
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		NewsDaoProxy proxy=new NewsDaoProxy();
		SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-DD HH:mm");
		news.setDate(sdf.format(new Date()));
		if(!proxy.doCreate(news)){
			System.out.println("����ʧ��");
		}
		else
		{
			System.out.println("�����ɹ�");
			try {
				response.sendRedirect("admin.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	/**
	 * ��ȡ�ļ��ĸ�ʽ�ַ���
	 * @param s
	 * @return ����ֵ��.jpg.png
	 */
	public String getLastStr(String s)
	{
		int index=s.lastIndexOf(".");
		return s.substring(index);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
