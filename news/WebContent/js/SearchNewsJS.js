
$(document).ready(function(){
	$(".searchbtn").click(function(){
		$.post("ReturnCommXMLServlet","newsid="+document.getElementById('SearchNews').value ,function(data){
			$("#SearchTable").html(data);
//			$("#SearchTable").html("1");
		});
	});
	
});
	

