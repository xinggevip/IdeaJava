<%--
  Created by IntelliJ IDEA.
  User: xingge
  Date: 2019/10/10
  Time: 8:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String ctx = request.getContextPath();
    pageContext.setAttribute("ctx", ctx);
%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
    <title>index</title>
</head>
<body>
<form action="${ctx}/myform6.action">
    名称：<input type="text" placeholder="请输入商品名称..." name="goodsList[0].name"><br/>
    价格：<input type="text" placeholder="请输入商品价格..." name="goodsList[0].price"><br/>
    <hr/>
    名称：<input type="text" placeholder="请输入商品名称..." name="goodsList[1].name"><br/>
    价格：<input type="text" placeholder="请输入商品价格..." name="goodsList[1].price"><br/>
    <input type="submit" value="提交">
</form>

</body>
</html>
