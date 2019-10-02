<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String ctx = request.getContextPath();
	pageContext.setAttribute("ctx", ctx);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="${ctx }/TestServlet?action=add">添加</a>
<a href="${ctx }/TestServlet?action=del"">删除</a>
<a href="${ctx }/TestServlet?action=update"">更新</a>
</body>
</html>