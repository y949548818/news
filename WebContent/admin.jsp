<%@ page language="java" contentType="text/html;" pageEncoding="gbk"%>
<%@ page import="com.news.entity.*"%>
<%@ page import="com.news.dao.proxy.*"%>
<%@ page import="java.util.*"%>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>¹ÜÀí</title>
<link href="css/admincss.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="js/labelChange.js"></script>
<script type="text/javascript" src="js/SearchNewsJS.js"></script>
<script type="text/javascript" src="js/NewsTypeCheck.js"></script>
<script type="text/javascript" src="js/DelBtnJS.js"></script>
<script type="text/javascript" src="js/newsPublish.js"></script>
</head>
<body>
   <div class="box" id="box">
      <div id="adminname" style="display: none;"><%=session.getAttribute("adminname")%></div>
      <div id="admin_id" style="display: none;"><%=session.getAttribute("admin_id")%></div>
      <div class="topwuyong"></div>
      <div class="top" id="top"></div>
      <div class="leftwuyong"></div>
      <div class="left" id="left">
         <ul class="label" id="label">
            <li class="selected"><a href="#">ÓÃ»§¹ÜÀí</a></li>
            <li><a href="#">ÐÂÎÅ¹ÜÀí</a></li>
            <li><a href="#">ÆÀÂÛ¹ÜÀí</a></li>
            <li><a href="#">ÐÂÎÅ·¢²¼</a></li>
         </ul>
      </div>
      <div class="right" id="right">
         <div class="rightson" style="display: block;">
            <form action="" method="post">
               <%
               	try {
               		IUserDAOProxy idao = new IUserDAOProxy();
               		List<User> all = idao.findAll();
               		Iterator<User> it1 = all.iterator();
               %>
               <table border="1" width="80%" align="center">
                  <tr align="center">
                     <td>ÓÃ»§id</td>
                     <td>ÓÃ»§Ãû</td>
                     <td>ÓÃ»§×´Ì¬</td>
                     <td>²Ù×÷</td>
                  </tr>
                  <%
                  	while (it1.hasNext()) {
                  			User u1 = it1.next();
                  %>
                  <tr align="center">
                     <td><%=u1.getId()%></td>
                     <td><%=u1.getUsername()%></td>
                     <td><%=u1.getState()%></td>
                     <td><input type="button" value="½âËø/Ëø¶¨"
                        onclick="setUserState(<%=u1.getId()%>,'<%=u1.getState()%>')"></td>
                  </tr>
                  <%
                  	}
                  %>
               </table>
               <%
               	} catch (Exception e) {
               		e.printStackTrace();
               	}
               %>
            </form>
         </div>

         <div class="rightson" style="display: none;">

            <%
            	try {
            		NewsDaoProxy ndi = new NewsDaoProxy();
            		List<News> all1 = ndi.findAllForUnchecked();

            		NewsCategoryPro ncp = new NewsCategoryPro();
            		List<NewsCategoryEnt> all2 = ncp.findAll();

            		String[] str = new String[all2.size()];
            		int[] idarr = new int[all2.size()];
            		int num = 0;
            		for (NewsCategoryEnt nce : all2) {
            			idarr[num] = nce.getCategoryId();
            			str[num] = nce.getCategory().toString();
            			num++;
            		}
            %>
            <form action="" method="post">
               <Table border=1 width="80%" height="80" align="center">
                  <tr align="center">
                     <td>ÐÂÎÅID</td>
                     <td>ÐÂÎÅ±êÌâ</td>
                     <td colspan="4">±êÇ©</td>
                  </tr>
                  <%
                  	int trnum = 0;
                  		for (News news : all1) {
                  %>
                  <tr align="center">
                     <td><%=news.getId()%></td>
                     <td><%=news.getContent()%></td>
                     <%
                     	for (int i = 0; i < str.length; i++) {
                     %>
                     <td><input type="checkbox" name=<%=trnum%>
                        value=<%=idarr[i]%> /><%=str[i]%></td>
                     <%
                     	}
                     %>
                     <td><input type="button" value="È·ÈÏ"
                        onclick="check(<%=trnum%>,<%=news.getId()%>)"></td>
                  </tr>
                  <%
                  	trnum++;
                  		}
                  	} catch (Exception e) {

                  	}
                  %>
               </Table>
            </form>

         </div>

         <div class="rightson" style="display: none;">
            ÆÀÂÛ¹ÜÀíÒ³Ãæ

            <form name="SearchForm" action="" method="post">
               ËÑË÷ÐÂÎÅºó²Ù×÷£º<br> <input type="text"
                  placeholder="ÇëÊäÈëÐÂÎÅID" id="SearchNews"
                  name="SearchNews" size="23" style="height: 30px;">
               <input type="button" name="SearchBtn" class="searchbtn"
                  value="ËÑË÷"><br>
            </form>
            <form name="delform" action="" method="post">
               <table id="SearchTable" border=1 align="center" width=90%>
               </table>
            </form>
         </div>

         <div class="rightson" style="display: none;">
            <div class="news-publish-area">
               <form action="NewsCreate" method="post"
                  id="news-publish-form" enctype="multipart/form-data">

                  <div>
                     <input class="newsTitle" type="text" name="title"
                        placeholder="ÐÂÎÅ±êÌâ" />
                  </div>
                  <div></div>
                  <div>
                     <textarea class="newsContent" placeholder="ÇëÊäÈëÐÂÎÅÕýÎÄ"
                        type="text" name="content" row="20" cols="50"></textarea>
                  </div>
                  <div class="select-file">
                     <span class="select-file-txt">ÉÏ´«Í¼Æ¬ </span> <input
                        id="file" type="file" name="image" />

                  </div>
                  <input id="publish" type='button' value="·¢²¼ÐÂÎÅ" />
                  <input style="display: none;" name="user_id" />
                   <span id="file-name"></span>
                   <input id="show-img" value="Ô¤ÀÀ" type="button"/>
                   <img src='' id="img-small"/>
                   <div id="img-close"></div>
               </form>
            </div>
         </div>
      </div>
   </div>
</body>
</html>