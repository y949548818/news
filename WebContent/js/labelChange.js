/**
 * Created by Administrator on 2016/1/6.
 */
//function $(id){
//    return typeof id=="string"?document.getElementById(id):id;
//}




window.onload=function(){
//    var label=$("label").getElementsByTagName("li");
//    var right=$("right").getElementsByTagName("div");
	var label=$(".label li");
	var right=$(".right div");
    //alert(label.length);
    //alert(right.length);
	if(label!=null){
	    for(var i=0;i<label.size();i++)
	    {
	        label[i].id=i;
	        label[i].onmouseup=function(){
	            for(var j=0;j<label.length;j++)
	            {
	                label[j].className="";
	                right[j].style.display="none";
	            }
	            this.className="selected";
	            right[this.id].style.display="block";
	        };
	        label[i].onmouseover=function(){
	            for(var j=0;j<label.length;j++)
	            {
	                if(label[j].className!="selected")
	                    label[j].className="";
	            }
	            if(this.className!="selected")
	                this.className="hover";
	        };
	        label[i].onmouseout=function(){
	            if(this.className!="selected")
	                this.className="";
	        };
	    }
	}
}

function setUserState(id,state)
{	
	if(state=="locked")
		$.post("SetUserActiveServlet","userid="+id,function(data){
			alert(data);
			window.location.reload();
		});
	else if(state=="active")
	{
		$.post("SetUserLoackedServlet","userid="+id,function(data){
			alert(data);
			window.location.reload();
		});
	}
	
}