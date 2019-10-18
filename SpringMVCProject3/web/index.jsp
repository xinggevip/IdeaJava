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
  <h3>使用原声request对象接收参数</h3>
  <a href="${pageContext.request.contextPath}/first?id=1&name=gaoxing">发送请求</a>
  <br/>
  <h3>简单类型参数RequestParam接收参数</h3>
  <a href="${pageContext.request.contextPath}/second?id=2&name=xinggevip">发送请求2</a>
  <br/>
  <h3>JavaBean接收参数</h3>
  <form action="${pageContext.request.contextPath}/myform">
    name:<input type="text" name="user_name"/>
    age:<input type="text" name="user_age"/>
    <input type="submit" value="提交">
  </form>
  <br/>
  <h3>数组接收参数</h3>
  <form action="${pageContext.request.contextPath}/myform2">
    name:<input type="text" name="user_hobby"/>
    name:<input type="text" name="user_hobby"/>
    <input type="submit" value="提交">
  </form>
  <br/>

  <h3>javabean接收参数含数组</h3>
  <form action="${pageContext.request.contextPath}/myform4">
    name:<input type="text" name="user_name"/><br/>
    age:<input type="text" name="user_age"/><br/>
    爱好:
    <input type="checkbox" name="user_hobby" value="看柯南">看柯南
    <input type="checkbox" name="user_hobby" value="看非诚勿扰">看非诚勿扰
    <input type="checkbox" name="user_hobby" value="写博客">写博客
    <input type="submit" value="提交">
  </form>

  <h3>包装类接收参数</h3>
  <form action="${pageContext.request.contextPath}/myform5">
    name:<input type="text" name="user_name"/><br/>
    age:<input type="text" name="user_age"/><br/>
    爱好:
    <input type="checkbox" name="user_hobby" value="看柯南">看柯南
    <input type="checkbox" name="user_hobby" value="看非诚勿扰">看非诚勿扰
    <input type="checkbox" name="user_hobby" value="写博客">写博客
    <br/>
    ----宠物----
    <br/>
    宠物名称：<input type="text" name="dog.name"> <br/>
    宠物颜色：<input type="text" name="dog.color"> <br/>
    <input type="submit" value="提交">
  </form>
  
  </body>
</html>
