<%--
  Created by IntelliJ IDEA.
  User: xingge
  Date: 2019/10/19
  Time: 15:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>convert</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/convert">
    年龄：<input type="text" name="age">
    生日：<input type="text" name="date">
    <input type="submit" value="提交">
</form>
</body>
</html>
