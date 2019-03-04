<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Login</title>

    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js">
    </script>

    <script type="text/javascript">

        var val;
        var html="";

        $(document).ready(function () {

            $("#Login").click(function () {

                var id = $("#id").val();
                var username = $("#username").val();
                var password = $("#password").val();

                $.ajax({
                    type: "POST",
                    url: "${pageContext.request.contextPath}/user/checkUser.do",
                    data: {//客户端传到服务器端的数据
                        "id": id,
                        "username": username,
                        "password": password
                    },
                    dataType: "json",
                    success: function (data) {//此处的data是服务器端返回客户端的数据
                        val = JSON.stringify(data);
                        var pj = $.parseJSON(val);

                        if(pj.success){
                            window.location.href = "jsp/userFilter.jsp";
                        }else{
                            alert("login failed");
                        }
                    },
                    error: function () {
                        console.log("error");

                    }
                });
            });
        });
    </script>

</head>
<span id="jsonDemo" ></span>


<%--<form action="${pageContext.request.contextPath}/user/checkUser.do" method="post">--%>
    <table>
        <tr>
            <td>ID:</td>
            <td>
                <input id="id" name="id" type="text">
            </td>
        </tr>

        <tr>
            <td>Username:</td>
            <td>
                <input id="username" name="username" type="text">
            </td>
        </tr>
        <tr>
            <td>Password:</td>
            <td>
                <input id="password" name="password" type="password">
            </td>
        </tr>
        <tr>

            <td>
                <input id="Login" type="button"  value="Login">
            </td>

            <td>
                <input id="Register" type="button" value="Register"  onclick="window.location.href='jsp/userRig.jsp'">
                <%--<input id="Register" type="submit" value="Register"  onclick="window.location.href='userRig.jsp'">--%>

            </td>
        </tr>

    </table>
    <p id="user_info"></p>
</form>
</body>
</html>






