<%--
  Created by IntelliJ IDEA.
  User: xingge
  Date: 2019/10/9
  Time: 21:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%
  String ctx = request.getContextPath();
  pageContext.setAttribute("ctx", ctx);
%>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h3>ActionContext</h3>
  <form action="${ctx}/myform.action">
    用户名：<input type="text" placeholder="请输入用户名..." name="username"><br/>
    昵 称：<input type="text" placeholder="请输入爱好..." name="nick"><br/>
    爱 好：<input type="checkbox"  value="足球" name="hobby">足球
    <input type="checkbox"  value="篮球" name="hobby">篮球
    <input type="checkbox"  value="乒乓球" name="hobby">乒乓球
    <input type="submit" value="提交">
  </form>

  <hr>

  <h3>原声api</h3>
  <form action="${ctx}/myform2.action">
    用户名：<input type="text" placeholder="请输入用户名..." name="username"><br/>
    昵 称：<input type="text" placeholder="请输入爱好..." name="nick"><br/>
    爱 好：<input type="checkbox"  value="足球" name="hobby">足球
    <input type="checkbox"  value="篮球" name="hobby">篮球
    <input type="checkbox"  value="乒乓球" name="hobby">乒乓球
    <input type="submit" value="提交">
  </form>

  <hr>

  <h3>提供set方法的方式</h3>
  <form action="${ctx}/myform3.action">
    用户名：<input type="text" placeholder="请输入用户名..." name="username"><br/>
    年 龄：<input type="text" placeholder="请输入年龄..." name="age"><br/>
    爱 好：<input type="checkbox"  value="足球" name="hobby">足球
    <input type="checkbox"  value="篮球" name="hobby">篮球
    <input type="checkbox"  value="乒乓球" name="hobby">乒乓球
    <input type="submit" value="提交">
  </form>

  <hr>

  <h3>domain属性接收参数</h3>
  <form action="${ctx}/myform4.action">
    用户名：<input type="text" placeholder="请输入用户名..." name="user.username"><br/>
    年 龄：<input type="text" placeholder="请输入年龄..." name="user.age"><br/>
    爱 好：<input type="checkbox"  value="足球" name="user.hobby">足球
    <input type="checkbox"  value="篮球" name="user.hobby">篮球
    <input type="checkbox"  value="乒乓球" name="user.hobby">乒乓球
    <input type="submit" value="提交">
  </form>

  <hr>

  <h3>采用模型驱动接收参数</h3>
  <form action="${ctx}/myform5.action">
    用户名：<input type="text" placeholder="请输入用户名..." name="username"><br/>
    年 龄：<input type="text" placeholder="请输入年龄..." name="age"><br/>
    爱 好：<input type="checkbox"  value="足球" name="hobby">足球
    <input type="checkbox"  value="篮球" name="hobby">篮球
    <input type="checkbox"  value="乒乓球" name="hobby">乒乓球
    <input type="submit" value="提交">
  </form>

  </body>
</html>
