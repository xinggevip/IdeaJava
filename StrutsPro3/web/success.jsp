<%--
  Created by IntelliJ IDEA.
  User: xingge
  Date: 2019/10/10
  Time: 15:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%
    String ctx = request.getContextPath();
    pageContext.setAttribute("ctx", ctx);
%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
    <title>success</title>
</head>
<body>
<s:debug></s:debug>
<h1>success</h1>
</body>
</html>
