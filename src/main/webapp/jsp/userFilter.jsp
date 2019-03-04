<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>dataFilter</title>

    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js">
    </script>

    <script type="text/javascript">


        var val;
        var html="";
        var pj;

        $(document).ready(function () {

            $("#dataFilter").click(function () {

                var department = $("#department option:selected").text();

                //todo 对于position的选择方式有问题，建议采用区域选择，需要进行进一步研究讨论，可以采用区的方式初步定下用户所在的位置
                var userLat = $("#userLat").val();
                var userLng = $("#userLng").val();

                var startTime = $("#startTime option:selected").text();
                var endTime = $("#endTime option:selected").text();
                var language = $("#language option:selected").text();

                $.ajax({
                    type: "POST",
                    url: "${pageContext.request.contextPath}/doc/modelFilter.do",
                    data: {//客户端传到服务器端的数据
                        "userLat":userLat,
                        "userLng":userLng,
                        "department": department,
                        "startTime": startTime,
                        "endTime": endTime,
                        "language":language
                    },
                    dataType: "json",
                    success: function (data) {//此处的data是服务器端返回客户端的数据

                        val = JSON.stringify(data);
                        pj = $.parseJSON(val);
                        console.info(pj);
                        for(var i = 0; i < val.length; i++){
                            html += "<span>"+val[i]+"</span>";
                        }

                        html += "<p></p>";
                        $("#doc_info").html(html);
                    },
                    error: function () {
                        console.log("error");
                    }
                });
            });
        });
    </script>

</head>
<p>
<span id="dataProcess" ></span>
</p>
    <table>
        <tr>
            <td>
                <select id="department">
                    <option value="a">a</option>
                    <option value="b">b</option>
                    <option value="c">c</option>
                    <option value="head">head</option>
                </select>

                <select id="startTime">
                    <option value="begin">2018-11-29 10:00:00</option>
                    <option value="begin">2018-11-29 11:00:00</option>
                    <option value="begin">2018-11-29 12:00:00</option>
                    <option value="begin">2018-11-29 13:00:00</option>
                </select>

                <select id="endTime">
                    <option value="end">2018-11-29 10:00:00</option>
                    <option value="end">2018-11-29 11:00:00</option>
                    <option value="end">2018-11-29 12:00:00</option>
                    <option value="end">2018-11-29 13:00:00</option>
                </select>

                <select id="language">
                    <option value="English">English</option>
                    <option value="Chinese">Chinese</option>
                    <option value="France">France</option>
                    <option value="Japanese">Japanese</option>
                </select>


            </td>
        </tr>


        <tr>
            <td>latitude:</td>
            <td>
                <input id="userLat" name="userLat" type="text">
            </td>
        </tr>
        <tr>
            <td>longitude:</td>
            <td>
                <input id="userLng" name="userLng" type="text">
            </td>
        </tr>

        <tr>
            <td>
                <input id="dataFilter" type="button"  value="dataFilter">
            </td>
            <%--<td>--%>
                <%--<input id="Register" type="button" value="Register"  onclick="window.location.href='jsp/userRig.jsp'">--%>
                <%--&lt;%&ndash;<input id="Register" type="submit" value="Register"  onclick="window.location.href='userRig.jsp'">&ndash;%&gt;--%>
            <%--</td>--%>
        </tr>

        <%--<tr>--%>
            <%--<td>--%>
                <%--<input id="modelFilter" type="button" value="modelFilter" onclick="modelFilter()">--%>
            <%--</td>--%>
        <%--</tr>--%>
    </table>

<table id="ResultTable"></table>

    <p id="doc_info"></p>
</form>
</body>
</html>






