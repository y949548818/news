$(document)
.ready(function()
		{
	//全局動畫時間
	var ANIMATETIME=500;
	//打开后的图片
	var detailImage=$("#detailImage");
	//打开后的时间坐着
	var timeAndAuthor=$("#newsTimeAuthor");
	//打开后的标题
	var detailTitle=$("#detailTitle");
	//打开后的正文
	var detailContent=$("#detailContent");
	//当前打开的新闻的id,-1为没有选中
	var current_news_id=-1;
	//评论的list，全局都是用一个，所以预先读取
	var commentList=$(".comment-list");
	$(".loginout-btn").click(function(){
		$.post("UserLoginoutServlet",'',function(){
			window.location.reload();
		});
	});
	$(".news-close").click(function()
	{
		current_news_id=-1;
		$("#newscontent")
		.animate(
		{opacity:'0.0',width:'0%',height:'0%'},ANIMATETIME,function()
				{
					$("#newscontent").css("display","none");
				});
		$("#mask").animate(
				{opacity:'0.0'},ANIMATETIME,function()
		{
		$("#mask").css("display","none");
		});
		document.body.style.overflow="auto"; //关闭滚动条功能
	});
	$(".item").click(function()
	{
		var imageURL=$(this).find("img").attr("src");
		var titleStr=$(this).find(".item-title").html();
		current_news_id=$(this).find(".item-news-id").html();
		var news_author=$(this).find(".item-author").html();
		var news_date=$(this).find(".item-news-date").html();
		detailImage.attr("src",imageURL);
		detailTitle.html(titleStr);
		timeAndAuthor
		.html(news_date+" Posted by "+news_author);
		detailContent.html($(this).find(".item-content")
				.html());
		//将评论清空
		commentList.children().remove();
		//显示loding界面
		$.post("CommentsSelectServlet","news_id="+current_news_id,function(data,statusText)
		{
			var t=eval("("+data+")");
			var itemTemp=$('<div class="comment-item"><div style="display:none;" class="comment-id"></div><div class="header-icon"><img src="images/default-header-icon.png" width="50"></div><div class="comment-username"></div><div class="comment-detail"></div><div class="comment-time"></div>');
			var comments=$(t.list);
			if(comments.length<=0)
				$("#comment-msg").html("暂无评论");
			else
			{
				$("#comment-msg").html("评论("+comments.length+"人已参与评论)");
				commentList
				.append($('<div style="color:#EB5A42;margin-top:10px;padding-left:10px;border-bottom:2px #000 solid;height:30px;line-height:30px;">最新评论</div>'));
				comments
				.each(function(index)
				{
					var item=itemTemp
					.clone();
					item
					.find(".comment-username")
					.html(this.user_id);
					item
					.find(".comment-detail")
					.html(this.comments_detail);
					item
					.find(".comment-time")
					.html(this.comments_date);
					item
					.find(".comment-id")
					.html(this.comments_id);
					commentList
					.append(item);
				});
			}
		});
		//发送post请求，请求评论
		/* 	$.post("", "news_id=" + news_id, function(data, statusText) {
		}); */
		//TODO此处正文应该是通过ajax请求完整的正文
		$("#newscontent").css("display","block");
		$("#newscontent")
		.animate(
		{opacity:'1.0',width:'80%',height:'85%'},ANIMATETIME,function()
		{
					//打开后回调，读取评论，读取正文
		});
		$("#newscontent").scroll(function()
		{
			nScrollHight=$(this)[0].scrollHeight;
			nScrollTop=$(this)[0].scrollTop;
			nDivHight=$(this).height();
			if(nScrollTop+nDivHight>=nScrollHight)
				//读取评论
				console.log("滚动条到底部了");
		});
		$("#mask").css("display","block");
		$("#mask").animate(
				{opacity:'1.0'},ANIMATETIME);
		document.body.style.overflow="hidden"; //关闭滚动条功能
	});
	//评论提交
	$("#comment-commit").click(function()
	{
		var publishStr=$("#comment-publish-area").val();

		if($("#user-id").html()==null)
			alert('需要先登录');
		else
		{
			if($.trim(publishStr)=='')
			{
				alert("务必填点什么");
				return;
			}
			var user_state=$("#user-state").html();
			if(user_state=="locked")
			{
				alert("当前用户已被锁定;请稍候再试");
				return ;
			}
			$.post("CommentsInsertServlet","comments_detail="+publishStr+"&user_id="+$("#user-id").html()+"&news_id="+current_news_id,function(data)
			{
				//$.post("CommentsInsertServlet","comments_detail="+publishStr+"&user_id="+1+"&news_id="+current_news_id,function(data){
				if(data=='ok')
				{
					alert("评论发布成功");
					$("#comment-publish-area")
					.val('');
					//评论发布成功后刷新评论
					refresh();
				}else
				{
					alert("评论发布失败")
				}
			});
		}
	});
	//刷新评论
	function refresh(){
		commentList.children().remove();
		$.post("CommentsSelectServlet","news_id="+current_news_id,function(data,statusText)
				{
					var t=eval("("+data+")");
					var itemTemp=$('<div class="comment-item"><div style="display:none;" class="comment-id"></div><div class="header-icon"><img src="images/default-header-icon.png" width="50"></div><div class="comment-username"></div><div class="comment-detail"></div><div class="comment-time"></div>');
					var comments=$(t.list);
					if(comments.length<=0)
						$("#comment-msg").html("暂无评论");
					else
					{
						$("#comment-msg").html("评论("+comments.length+"人已参与评论)");
						commentList
						.append($('<div style="color:#EB5A42;margin-top:10px;padding-left:10px;border-bottom:2px #000 solid;height:30px;line-height:30px;">最新评论</div>'));
						comments
						.each(function(index)
						{
							var item=itemTemp
							.clone();
							item
							.find(".comment-username")
							.html(this.user_id);
							item
							.find(".comment-detail")
							.html(this.comments_detail);
							item
							.find(".comment-time")
							.html(this.comments_date);
							item
							.find(".comment-id")
							.html(this.comments_id);
							commentList
							.append(item);
						});
					}
				});
	};
});