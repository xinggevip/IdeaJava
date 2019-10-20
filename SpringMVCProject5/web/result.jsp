<%--
  Created by IntelliJ IDEA.
  User: xingge
  Date: 2019/10/20
  Time: 22:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="fm"  %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>result</h1>
    <fm:form modelAttribute="user">
        <fm:input path="username"/>
        <fm:input path="age"/>
    </fm:form>
</body>
</html>
