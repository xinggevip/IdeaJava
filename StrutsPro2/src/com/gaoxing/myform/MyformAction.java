package com.gaoxing.myform;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.dispatcher.HttpParameters;

import java.util.Arrays;

public class MyformAction extends ActionSupport {
    public String execute(){
        // 接收表单中的参数
        ActionContext context = ActionContext.getContext();
        HttpParameters parameters = context.getParameters();
        // 获取参数
        String username = parameters.get("username").getValue();
        String nick = parameters.get("nick").getValue();
        String[] hobbies = parameters.get("hobby").getMultipleValues();

        System.out.println(username);
        System.out.println(nick);
        System.out.println(Arrays.toString(hobbies));

        // 往域中存数据
        // request
        context.put("reqName","reqValue");
        // session
        context.getSession().put("sessionName","ApplicationValue");
        // application
        context.getApplication().put("ApplicationName","ApplicationValue");

        System.out.println("接收到表单");
        return SUCCESS;
    }
}
