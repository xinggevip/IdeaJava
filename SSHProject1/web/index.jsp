<%--
  Created by IntelliJ IDEA.
  User: xingge
  Date: 2019/10/17
  Time: 9:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>ssh</title>
  </head>
  <body>
  <form action="${pageContext.request.contextPath}/account_save.action">
    name:<input type="text">
    monmey:<input type="text">
    <input type="submit" value="提交">
  </form>
  </body>
</html>
