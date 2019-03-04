<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Register</title>

    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js">//每个界面都必须要有
    </script>

</head>


<script type="text/javascript">

    $(document).ready(function () {

        $("#User_Register").click(function () {

            var userid = $("#userid").val();
            var username = $("#username").val();
            var password = $("#password").val();

            $.ajax({
                type: "POST",
                url: "${pageContext.request.contextPath}/user/addUser.do",
                data: {
                    "userid": userid,
                    "username": username,
                    "password": password
                },
                dataType: "json",
                success: function (data) {
                    var reg_data = JSON.stringify(data);
                    var pj = $.parseJSON(reg_data);
                    console.info(pj);
                },
                error: function () {
                    console.log("error");

                }
            });
        });

        $("#returnLogin").click(function(){
            window.history.go(-1);
        })
    });

</script>

<%--<form action="${pageContext.request.contextPath}/user/addUser.do" method="post">--%>
<form>
    <table>
        <tr>
            <td>UserId</td>
            <td><input id="userid" name="user_id" type="text"></td>
        </tr>

        <tr>
            <td>Username:</td>
            <td><input id="username" name="username" type="text"></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input id="password" name="password" type="password"></td>
        </tr>
        <tr >
            <td><input type="button" value="Register" id="User_Register"></td>
        </tr>

        <tr>
            <td><input type="button" value="return" id="returnLogin"></td>
        </tr>

    </table>
</form>
</body>
</html>







