<%--
  Created by IntelliJ IDEA.
  User: xingge
  Date: 2019/10/18
  Time: 14:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <a href="${pageContext.request.contextPath}/first?id=1&name=gaoxing">发送请求</a>
  <br/>
  <a href="${pageContext.request.contextPath}/second?id=2&name=xinggevip">发送请求2</a>
  <br/>

  <form action="${pageContext.request.contextPath}/myform">
    name:<input type="text" name="user_name"/>
    age:<input type="text" name="user_age"/>
    <input type="submit" value="提交">
  </form>
  
  </body>
</html>
