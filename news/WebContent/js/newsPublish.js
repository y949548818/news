$(document).ready(function(){
	var form=$("#news-publish-form");
	//�Ƿ����Ԥ���ϴ���ͼƬ
	var canShow=false;
	$("#file").change(function(e){
//		alert($(this).val());
		var filename=$("#file").val();
		if(filename==""||!(/.+\.(jpg|png)/).test(filename))
		{
			alert("��ѡ��jpg��ʽ�Ļ���png��ʽ��ͼƬ");
			return ;
		}
		$("#file-name").html($(this).val());
//		var img = e.target.files||e.dataTransfer.files;
		var img = $("#file")[0].files[0];
		canShow=false;
		$("#show-img").css("cursor","");
        $("#show-img").css("color","#bbb");
        if(img){
            var reader = new FileReader();
            reader.onload=function(){
            	canShow=true;
//            	alert(this.result);
                   $("#img-small").attr("src",this.result);
//                   append($("<img width='200' src='"+this.result+"'/>"));
                   $("#show-img").css("cursor","pointer");
                   $("#show-img").css("color","#888");
                   
            }
           reader.readAsDataURL(img);
       }
	});
	$("#show-img").click(function(){
		if(canShow)
		{
			$("#img-small").css("display","block");
			$("#img-close").css("display","block");
			$("#img-small").animate({opacity:1.0},500);
		}
		else{
		}
	});
	$("#img-close").click(function(){
		$("#img-small").animate({opacity:0.0},500,function(){
			$("#img-close").css("display","none");
			$("#img-small").css("display","none");
		});	
	
	});
	$("#publish").click(function(){
		var filename=$("#file").val();
		if($.trim($(".newsTitle").val())==''){
			alert("���������ű���");
			return ;
		}
		if($.trim($(".newsContent").val())==''){
			alert("��������������");
			return ;
		}
		if(filename==""||!(/.+\.(jpg|png)/).test(filename))
		{
			alert("��ѡ��jpg��ʽ�Ļ���png��ʽ��ͼƬ");
			return;
		}
//		alert(form.serialize());
		form[0].user_id.value=$("#admin_id").html();
//		alert(form[0].user_id.value);
		form.submit();
	});
});