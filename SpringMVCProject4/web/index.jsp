<%--
  Created by IntelliJ IDEA.
  User: xingge
  Date: 2019/10/19
  Time: 22:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <a href="${pageContext.request.contextPath}/testModelAndView">测试testModelAndView</a>
  <hr/>
  <a href="${pageContext.request.contextPath}/testModel">测试testModel</a>
  <hr/>
  <a href="${pageContext.request.contextPath}/testMap">测试testMap</a>
  <hr/>
  <a href="${pageContext.request.contextPath}/testSession">测试testSession</a>
  <hr/>
  <a href="${pageContext.request.contextPath}/testSession2">测试testSession2</a>

  <form action="${pageContext.request.contextPath}/testModelAttribute">
    名称：<input type="text" name="name">
    价格：<input type="text" name="price">
    <input type="submit" value="提交">
  </form>

  </body>
</html>
