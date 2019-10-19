<%--
  Created by IntelliJ IDEA.
  User: xingge
  Date: 2019/10/19
  Time: 17:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>requestmapping</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/testrequestmapping1">请求方式1</a><br/>
<a href="${pageContext.request.contextPath}/testrequestmapping2">请求方式2</a><br/>

<hr/>

<form action="${pageContext.request.contextPath}/testMethod" method="post">
    name:<input type="text" name="name">
    <input type="submit" value="提交">
</form>
</body>
</html>
