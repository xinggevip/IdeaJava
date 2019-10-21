<%--
  Created by IntelliJ IDEA.
  User: xingge
  Date: 2019/10/21
  Time: 17:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="fm"  %>
<html>
<head>
    <title>结果页面2</title>
</head>
<body>
    <h1>结果页面2</h1>
    <fm:form modelAttribute="user" action="${pageContext.request.contextPath}/updata2">
        姓名：<fm:input path="username"/>
        年龄<fm:input path="age"/>
        <br>
        性别：<fm:radiobutton path="gender" value="0" label="男"/>
        <fm:radiobutton path="gender" value="1" label="女"/>
        <br>
        爱好：<fm:checkboxes path="hobby" items="${allhobbys}"/>
    </fm:form>
</body>
</html>
