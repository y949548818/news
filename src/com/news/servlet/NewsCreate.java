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
	 * 将图片保存
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
			//获取所有封装成fileitem的参数
			List<FileItem>items=servletFileUpload.parseRequest(request);
			for(FileItem item:items)
			{
				//如果是表单参数
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
				//如果是文件的话
				else{
					/**
					 * 图片的文件名
					 */
					String imageName=Utils.getMD5(item.getName()+new Date())+getLastStr(item.getName());
					news.setImageUrl("images/"+imageName);
					item.write(new File(imageRoot,imageName));
				
//					NewsCache.refresh();
//					System.out.println("正在刷新");
				}
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		NewsDaoProxy proxy=new NewsDaoProxy();
		SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-DD HH:mm");
		news.setDate(sdf.format(new Date()));
		if(!proxy.doCreate(news)){
			System.out.println("发布失败");
		}
		else
		{
			System.out.println("发布成功");
			try {
				response.sendRedirect("admin.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	/**
	 * 获取文件的格式字符串
	 * @param s
	 * @return 返回值如.jpg.png
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
