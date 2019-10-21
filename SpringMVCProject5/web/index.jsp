<%--
  Created by IntelliJ IDEA.
  User: xingge
  Date: 2019/10/20
  Time: 22:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <img src="${pageContext.request.contextPath}/images/solo.png" alt="图片"> <br>
  <a href="${pageContext.request.contextPath}/testView">testView</a>
  <hr>
  <a href="${pageContext.request.contextPath}/testUpdata/1">testUpdata</a>
  <hr>
  <input type="button" id="btn" value="请求JSON">
  <input type="button" id="btn2" value="请求JSON数组">
  <hr>
  <form id="myform">
    user:<input type="text" name="username"><br>
    age:<input type="text" name="age" ><br>
    爱好:<input type="checkbox" name="hobby" value="篮球"> 篮球
    <input type="checkbox" name="hobby" value="乒乓球"> 乒乓球
    <input type="checkbox" name="hobby" value="足球"> 足球
  </form>
  <input type="button" id="formbtn" value="发送form">

  <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
  <script>
    $(function(){

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
        
        $("#formbtn").click(function () {
            // 获取表单所有数据，并改成json格式
            var serialize = $("#myform").serializeJson();
            console.log(serialize);
        });
        
        $("#btn").click(function () {
            // 发送ajax请求
            $.post("${pageContext.request.contextPath}/getJson",function (data) {
                console.log(data);
            })
        });
        $("#btn2").click(function () {
            // 发送ajax请求
            $.post("${pageContext.request.contextPath}/getJson2",function (data) {
                console.log(data);
            })
        });
    })
  </script>

  </body>
</html>
