/**
 * Created by Administrator on 2016/1/5.
 */
function checkNameAndPwd()
{
    if ($("#username").val() == "" || $("#password").val() == "")
        alert("用户名或密码不能为空！");
    else
    {
        $.post("UserLoginServlet","username="
            + $("#username").val()+"&password="+$("#password").val(),
            function(msg){alert(msg);});
    }
}