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
            // 获取表单所有数据，并改成json格式 提交纯粹key：value的简单数据ok，其他error
            var serialize = $("#myform").serializeJson();
            console.log(serialize); // {username: "xinggevip", age: "18", hobby: "篮球"}
            // JSON.stringify格式
            console.log(JSON.stringify(serialize)); // {"username":"xinggevip","age":"18","hobby":"篮球"}
            // 有化成Java都能接收的JSON.stringify格式
            if (typeof serialize.hobby == "string") {
                serialize.hobby = new Array(serialize.hobby);
            }
            console.log(JSON.stringify(serialize)); // {"username":"xinggevip","age":"18","hobby":["篮球"]}

            // 提交纯粹key：value的简单数据
            /*$.post("${pageContext.request.contextPath}/myForm",serialize,function (data) {
                console.log(data);
            });*/

            // 提交复杂的带数组的Json数据
            $.ajax({
                type:"post",
                url:"${pageContext.request.contextPath}/myForm",
                dataType:'json', // 指定接收返回数据的类型
                data:JSON.stringify(serialize), // 数据
                contentType:'application/json', // 指定发送数据类型
                success:function (data) { // 成功则执行
                    console.log(data);
                },
                error:function (data) { // 失败则执行
                    console.log("失败");
                    console.log(data);
                }
            });
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
