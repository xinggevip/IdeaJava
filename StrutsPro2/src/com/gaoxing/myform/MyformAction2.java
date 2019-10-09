package com.gaoxing.myform;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

public class MyformAction2 extends ActionSupport {
    public String execute(){
        // 获取原声api
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();
        // 获取参数
        String username = request.getParameter("username");
        String nick = request.getParameter("nick");
        String[] hobbies = request.getParameterValues("hobby");

        System.out.println(username);
        System.out.println(nick);
        System.out.println(Arrays.toString(hobbies));

        // 原生api往域中存数据
        request.setAttribute("reqName","reqValue");
        request.getSession().setAttribute("sessionName","ApplicationValue");
        ServletActionContext.getServletContext().setAttribute("ApplicationName","ApplicationValue");
        return null;
    }
}
