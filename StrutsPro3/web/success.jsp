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
    <%-- 根元素数据 value ognl表达式 取栈顶 --%>
    <s:property value="name"/>
    <%-- 取非根元素  ognl表达式 --%>
    <s:property value="#reqName"/>
    <s:property value="#session.sessionName"/>
    <s:property value="#application.ApplicationName"/>
    <br/>
    <%-- gnl表达式 调用普通方法方法 --%>
    <s:property value="'hello'.length()"/>
    <br/>
    <s:property value="@java.lang.Math@random()"/>
    <s:debug></s:debug>
    <h1>success</h1>
</body>
</html>
