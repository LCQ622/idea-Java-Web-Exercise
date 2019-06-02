<%--
  Created by IntelliJ IDEA.
  User: XiaoXin-700
  Date: 2018/11/3
  Time: 19:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试ajax</title>
    <script src="jquery-3.3.1.js"></script>
    <script>
        var xmlhttp = new XMLHttpRequest();
        var btn = document.getElementById("btn");

        $(function () {
           $("#btn").click(function () {
               var url=encodeURI("/test?name="+$("input").val());
               xmlhttp.open("GET",url,true);
               xmlhttp.send();
           });
        });
    </script>
</head>
<body>
<input type="text" name="name">
<button id="btn" >按钮</button>
</body>
</html>
