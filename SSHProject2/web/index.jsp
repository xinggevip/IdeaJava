<%--
  Created by IntelliJ IDEA.
  User: 码蚁小强
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="${pageContext.request.contextPath}/account_save.action">
    name:<input type="text" name="name">
    money:<input type="text" name="money">
    <input type="submit" value="提交">
  </form>
  </body>
</html>
