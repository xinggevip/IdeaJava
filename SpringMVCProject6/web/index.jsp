<%--
  Created by IntelliJ IDEA.
  User: xingge
  Date: 2019/10/22
  Time: 22:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <a href="${pageContext.request.contextPath}/test1">测试跳转</a>
  <hr>
  <a href="${pageContext.request.contextPath}/download/solo.png">下载solo.png</a>
  <a href="${pageContext.request.contextPath}/download/妹子.jpg">下载妹子.jpg</a>
  <hr>
  <form action="${pageContext.request.contextPath}/upload" method="post" enctype="multipart/form-data">
    <input type="file" name="file"> <br>
    <input type="submit" value="上传">
  </form>

  </body>
</html>
