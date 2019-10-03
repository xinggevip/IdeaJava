package com.gaoxing.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/RequestListnerTest")
public class RequestListnerTest extends HttpServlet implements ServletRequestListener {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("request创建");
    }

    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("request销毁");
    }
}
