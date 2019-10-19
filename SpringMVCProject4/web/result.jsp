<%--
  Created by IntelliJ IDEA.
  User: xingge
  Date: 2019/10/19
  Time: 22:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Result-------</h1>
<p>${name}</p>
<p>${requestScope.name}</p>
<h2>取对象属性</h2>
<p>${requestScope.goods.name}----${requestScope.goods.price}</p>
</body>
</html>
