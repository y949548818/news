
<%@page import="com.news.entity.NewsCategoryEnt"%>
<%@page import="com.news.dao.proxy.NewsAddCategoryProxy"%>
<%@page import="com.news.dao.proxy.IAdminDAOProxy"%>
<%@page import="com.news.entity.User"%>
<%@page import="com.news.dao.proxy.IUserDAOProxy"%>
<%@page import="com.news.dao.proxy.NewsDaoProxy"%>
<%@page import="com.news.cache.NewsCache"%>
<%@page import="com.news.entity.News"%>
<%@page import="java.util.List"%>
<%@page language="java" contentType="text/html; charset=GBK"
   pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>Insert title here</title>
<link href="css/index.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="js/index.js"></script>
<script type="text/javascript">

</script>
</head>
<body>
   <div class="header">
      <div class="header-wrapper">
         <div class="top">
            <div class="top-item-warpper">
               <a href="#" class="top-item" id="top-item-focus">Home</a>
               <a href="#" class="top-item">Contact</a> <a href="#"
                  class="top-item">Sponsor</a>
            </div>
         </div>
         <a href="index.jsp" id="icon"><img src="images/icon.bmp"
            width="150" height="150"></a>
         <div class="nav">
            <a href="#" class="nav-item">REC</a> <a href="#"
               class="nav-item">HOT</a> <a href="#" class="nav-item">NEWEST</a>
            <div class="user-area">
               <%
               	String username = (String) session.getAttribute("username");
               	Object user_id_o = session.getAttribute("user_id");
               	int user_id = -1;
               	if (user_id_o != null) {
               		user_id = (Integer) user_id_o;
               	}
               	//&&user_id!=0
               	if (username != null && user_id != -1) {
               %>
               <%=username%>
                  <span class="loginout-btn">ע��</span>
               <div id="user-state" style="none;"><%=new IUserDAOProxy().findById(user_id).getState()%></div>
               <div id="user-id"><%=user_id%></div>
               <%
               	} else {
               %>
               <a href="other/login.html">��¼</a>
               <%
               	}
               %>
            </div>
         </div>
      </div>
   </div>

   <div class="content">

      <div class="content-wrapper">

         <%
         	NewsAddCategoryProxy categoryProxy = new NewsAddCategoryProxy();
         	IAdminDAOProxy adminDAOProxy = new IAdminDAOProxy();
         	String pageStr = request.getParameter("pageNumber");
         	int mPage = 1;
         	if ("".equals(pageStr) || pageStr == null) {

         	} else {
         		mPage = Integer.parseInt(pageStr);
         	}
         	int start = (mPage - 1) * 10;
         	List<News> items = new NewsDaoProxy().findListByNumber(start, 10);
         	//out.print(items.size());
         	for (News item : items) {
         %>
         <div class="item">
            <div class="item-img">
               <img src="<%=item.getImageUrl()%>" height="100%">
            </div>
            <div class="item-news-id"><%=item.getId()%></div>
            <div class="item-news-date"><%=item.getDate()%></div>
            <div class="item-title"><%=item.getTitle()%></div>
            <div class="item-content">
               <%=item.getContent()%>
            </div>
            <div class="item-extra">
               <div class="item-author">
                  <%
                  	User user = adminDAOProxy.findById(item.getUser_id());
                  		if (user != null)
                  			out.print(user.getUsername());
                  		else {
                  			out.print("�����û�");
                  		}
                  %>
               </div>
               <div class="news-category">
                  <%
                  	List<NewsCategoryEnt> categorys = categoryProxy.findCategoryByNewsId(item.getId());
                  		for (NewsCategoryEnt category : categorys) {
                  			out.println(category.getCategory() + " ");
                  		}
                  %>
               </div>
               <div class="comment-icon">
                  <div class="comment-number"><%=item.getCommentNumber()%></div>
               </div>
            </div>
         </div>
         <%
         	}
         %>
      </div>
   </div>
   </div>
   <div class="bottom">
      <div style="text-align: center;" class="copyright"><a href="#">���ڱ�վ</a>&nbsp;|&nbsp;<a href="#">��վ��Ƹ</a>&nbsp;|&nbsp;<a href="#">��ϵ����</a>&nbsp;|&nbsp;<a href="#">������</a>&nbsp;|&nbsp;<a href="#">��վ��ͼ</a>&nbsp;|&nbsp;<a href="#">����΢��</a>&nbsp;|&nbsp;<a href="#">��Ѷ΢��</a>&nbsp;|&nbsp;<a href="#">�ſ�ռ�</a></div>
      <div style="text-align: center;" class="copyright">Copyright@2016-1-1xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx</div>
   </div>
   <div id="newscontent">
      <div class="news-close">
         <img src="images/close.png" />
      </div>
      <div id="detailTitle-Area">
         <h1 id="detailTitle" align="center">�й�פ������ʹ�ݾ�����ֲ�Ϯ��������Ƶ����</h1>
         <div id="newsTimeAuthor">2016-1-6 Posted by:Admin</div>
      </div>

      <div id="news-content-main">
         <div id="img-wrapper">
            <img id="detailImage" src="images/1.jpg" width="100%" />
         </div>
         <div id="detailContent">1��4�գ��й��侯�ٷ�΢�š������侯�����ҹ�������Ƶ���ñ���骡�Ƭ�Σ�
            Ƭ�μ�¼��2015��7��26���й�פ�������ʹ�����ھƵ������ֲ�����ը��Ϯ���¼��У�ʹ�ݾ������侯սʿ����������˵�������Ч�������ֳ����档
         </div>

      </div>
      <div class="comment-area">
         <!-- �����ŵ����۵�״̬ -->
         <div id="comment-msg"></div>
         <!-- �������۵����� -->
         <div class="comment-publish">
            <textarea id="comment-publish-area"></textarea>
            <div id="publish-commit-area">
               <input id="comment-commit" type="button" value="����"></input>
            </div>
         </div>
         <div class="comment-list"></div>
      </div>

   </div>
   <div id="mask"></div>
</body>
</html>