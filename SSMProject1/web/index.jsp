<%--
  Created by IntelliJ IDEA.
  User: xingge
  Date: 2019/10/28
  Time: 13:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <%--<form action="${pageContext.request.contextPath}/addcustomer">--%>
  <%--客户名称：<input type="text" name="cust_name" /> <br>--%>
  <%--客户职业：<input type="text" name="cust_profession" /> <br>--%>
  <%--客户电话：<input type="text" name="cust_phone" /> <br>--%>
  <%--客户邮件：<input type="text" name="email" /> <br>--%>
  <%--<input type="submit" value="添加">--%>
  <%--</form>--%>

  <%--<form action="${pageContext.request.contextPath}/login" id="myform">--%>
  <form action="${pageContext.request.contextPath}/login"  id="myform" method="post">
    用户名：<input type="text" name="user_id" /> <br>
    密码：<input type="text" name="user_password" /> <br>
    <input type="submit" value="登录" id="formbtn">
    <%--<button id="formbtn">登录</button>--%>
  </form>

  <script
          src="https://code.jquery.com/jquery-3.4.1.min.js"
          integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
          crossorigin="anonymous"></script>
  <script>
    $(function () {

        (function($){
            $.fn.serializeJson=function(){
                var serializeObj={};
                var array=this.serializeArray();
                var str=this.serialize();
                $(array).each(function(){
                    if(serializeObj[this.name]){
                        if($.isArray(serializeObj[this.name])){
                            serializeObj[this.name].push(this.value);
                        }else{
                            serializeObj[this.name]=[serializeObj[this.name],this.value];
                        }
                    }else{
                        serializeObj[this.name]=this.value;
                    }
                });
                return serializeObj;
            };
        })(jQuery);

        <%--$("#formbtn").click(function () {--%>



            <%--var serialize = $("#myform").serializeJson();--%>

            <%--$.ajax({--%>
                <%--type:"post",--%>
                <%--url:"${pageContext.request.contextPath}/login",--%>
                <%--dataType:'json', // 指定接收返回数据的类型--%>
                <%--data:JSON.stringify(serialize), // 数据--%>
                <%--contentType:'application/json', // 指定发送数据类型--%>
                <%--success:function (data) { // 成功则执行--%>
                    <%--console.log(data);--%>
                <%--},--%>
                <%--error:function (data) { // 失败则执行--%>
                    <%--console.log("失败");--%>
                    <%--console.log(data);--%>
                <%--}--%>
            <%--});--%>
        <%--})--%>

    })
  </script>


  </body>
</html>
