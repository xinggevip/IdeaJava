<%--
  Created by IntelliJ IDEA.
  User: xingge
  Date: 2019/10/20
  Time: 22:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <img src="${pageContext.request.contextPath}/images/solo.png" alt="图片"> <br>
  <a href="${pageContext.request.contextPath}/testView">testView</a>
  <hr>
  <a href="${pageContext.request.contextPath}/testUpdata/1">testUpdata</a>
  <hr>
  <input type="button" id="btn" value="请求JSON">
  <input type="button" id="btn2" value="请求JSON数组">

  <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
  <script>
    $(function(){
        $("#btn").click(function () {
            // 发送ajax请求
            $.post("${pageContext.request.contextPath}/getJson",function (data) {
                console.log(data);
            })
        });
        $("#btn2").click(function () {
            // 发送ajax请求
            $.post("${pageContext.request.contextPath}/getJson2",function (data) {
                console.log(data);
            })
        });
    })
  </script>

  </body>
</html>
