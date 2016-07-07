/**
 * 
 */
function check(trnum,newsid){
	obj = document.getElementsByName(trnum);
	check_val = [];
	for(k in obj){
		if(obj[k].checked){
			$.post("NewsAddCategoryServlet","type_id="+obj[k].value+"&news_id="+newsid,function(data){
				alert(data);
				window.location.reload();
			});
		}
	}
}