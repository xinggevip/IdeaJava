<%--
  Created by IntelliJ IDEA.
  User: xingge
  Date: 2019/10/9
  Time: 22:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%
    String ctx = request.getContextPath();
    pageContext.setAttribute("ctx", ctx);
%>
<html>
<head>
    <title>res</title>
</head>
<body>
req:${reqName}
session:${sessionName}
application:${ApplicationName}
</body>
</html>
