
function DelBtn(button){
	var table = document.getElementById("SearchTable");
    var str="";
    for(var i=0; i<delform.delb.length ;i++){
      if(delform.delb[i] == button){
    	var onerow = table.rows[i];
    	str =onerow.cells[0].innerHTML;
        break;
      }
    }
    $.post("CommentsDeleteCommServlet","comm_id="+str,function(data){
		window.location.reload();
	});
  }