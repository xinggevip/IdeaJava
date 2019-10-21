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
    <fm:form modelAttribute="user" action="${pageContext.request.contextPath}/updata2">
        姓名：<fm:input path="username"/> <fm:errors path="username"/> <br>
        年龄<fm:input path="age"/> <fm:errors path="age"/>
        <br>
        性别：<fm:radiobutton path="gender" value="0" label="男"/>
        <fm:radiobutton path="gender" value="1" label="女"/>
        <br>
        爱好：<fm:checkboxes path="hobby" items="${allhobbys}"/>
        宠物：<fm:select path="pet.id" items="${petList}" itemValue="id" itemLabel="name"/>
        <input type="submit" value="提交">
    </fm:form>
</body>
</html>
