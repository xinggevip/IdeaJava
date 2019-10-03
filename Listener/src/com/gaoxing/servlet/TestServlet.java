package com.gaoxing.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("TestServlet-----" + req.getSession().getId());
        //req.getSession().invalidate();
        //req.getSession().setMaxInactiveInterval(60);// 设置60秒后session过期
        /**
         * sessionCreated--创建
         * 3062FC7B2789A1E01186A1A8D9056DBE
         * sessionDestoryed--销毁
         *
         * 浏览器关闭session并没有销毁，只不过浏览器的sessionId没了，和服务器比对不上，于是服务器又new了一个新的
         *session过期会被销毁:
         * 1.req.getSession().setMaxInactiveInterval(60); 单位为秒
         * 2.web.xml配置session过期时间  单位为分钟
         * 3.服务器关闭session会被销毁
         * 服务器关闭没有被监听到销毁是因为Tomcat6以后，session会被持久化，服务器重启后会复活session
         * 如果不想让session在服务器关闭后还持久化
         * 就在Tomcat/conf/context.xml中把<Manager pathname="" />注释取消
         */
    }
}
