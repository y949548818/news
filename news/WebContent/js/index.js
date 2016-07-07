$(document)
.ready(function()
		{
	//ȫ�քӮ��r�g
	var ANIMATETIME=500;
	//�򿪺��ͼƬ
	var detailImage=$("#detailImage");
	//�򿪺��ʱ������
	var timeAndAuthor=$("#newsTimeAuthor");
	//�򿪺�ı���
	var detailTitle=$("#detailTitle");
	//�򿪺������
	var detailContent=$("#detailContent");
	//��ǰ�򿪵����ŵ�id,-1Ϊû��ѡ��
	var current_news_id=-1;
	//���۵�list��ȫ�ֶ�����һ��������Ԥ�ȶ�ȡ
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
		document.body.style.overflow="auto"; //�رչ���������
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
		//���������
		commentList.children().remove();
		//��ʾloding����
		$.post("CommentsSelectServlet","news_id="+current_news_id,function(data,statusText)
		{
			var t=eval("("+data+")");
			var itemTemp=$('<div class="comment-item"><div style="display:none;" class="comment-id"></div><div class="header-icon"><img src="images/default-header-icon.png" width="50"></div><div class="comment-username"></div><div class="comment-detail"></div><div class="comment-time"></div>');
			var comments=$(t.list);
			if(comments.length<=0)
				$("#comment-msg").html("��������");
			else
			{
				$("#comment-msg").html("����("+comments.length+"���Ѳ�������)");
				commentList
				.append($('<div style="color:#EB5A42;margin-top:10px;padding-left:10px;border-bottom:2px #000 solid;height:30px;line-height:30px;">��������</div>'));
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
		//����post������������
		/* 	$.post("", "news_id=" + news_id, function(data, statusText) {
		}); */
		//TODO�˴�����Ӧ����ͨ��ajax��������������
		$("#newscontent").css("display","block");
		$("#newscontent")
		.animate(
		{opacity:'1.0',width:'80%',height:'85%'},ANIMATETIME,function()
		{
					//�򿪺�ص�����ȡ���ۣ���ȡ����
		});
		$("#newscontent").scroll(function()
		{
			nScrollHight=$(this)[0].scrollHeight;
			nScrollTop=$(this)[0].scrollTop;
			nDivHight=$(this).height();
			if(nScrollTop+nDivHight>=nScrollHight)
				//��ȡ����
				console.log("���������ײ���");
		});
		$("#mask").css("display","block");
		$("#mask").animate(
				{opacity:'1.0'},ANIMATETIME);
		document.body.style.overflow="hidden"; //�رչ���������
	});
	//�����ύ
	$("#comment-commit").click(function()
	{
		var publishStr=$("#comment-publish-area").val();

		if($("#user-id").html()==null)
			alert('��Ҫ�ȵ�¼');
		else
		{
			if($.trim(publishStr)=='')
			{
				alert("������ʲô");
				return;
			}
			var user_state=$("#user-state").html();
			if(user_state=="locked")
			{
				alert("��ǰ�û��ѱ�����;���Ժ�����");
				return ;
			}
			$.post("CommentsInsertServlet","comments_detail="+publishStr+"&user_id="+$("#user-id").html()+"&news_id="+current_news_id,function(data)
			{
				//$.post("CommentsInsertServlet","comments_detail="+publishStr+"&user_id="+1+"&news_id="+current_news_id,function(data){
				if(data=='ok')
				{
					alert("���۷����ɹ�");
					$("#comment-publish-area")
					.val('');
					//���۷����ɹ���ˢ������
					refresh();
				}else
				{
					alert("���۷���ʧ��")
				}
			});
		}
	});
	//ˢ������
	function refresh(){
		commentList.children().remove();
		$.post("CommentsSelectServlet","news_id="+current_news_id,function(data,statusText)
				{
					var t=eval("("+data+")");
					var itemTemp=$('<div class="comment-item"><div style="display:none;" class="comment-id"></div><div class="header-icon"><img src="images/default-header-icon.png" width="50"></div><div class="comment-username"></div><div class="comment-detail"></div><div class="comment-time"></div>');
					var comments=$(t.list);
					if(comments.length<=0)
						$("#comment-msg").html("��������");
					else
					{
						$("#comment-msg").html("����("+comments.length+"���Ѳ�������)");
						commentList
						.append($('<div style="color:#EB5A42;margin-top:10px;padding-left:10px;border-bottom:2px #000 solid;height:30px;line-height:30px;">��������</div>'));
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