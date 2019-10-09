package com.gaoxing.struts;

import com.opensymphony.xwork2.ActionSupport;

public class HelloAction3 extends ActionSupport {
    @Override
    public String execute() throws Exception {
        System.out.println("extends ActionSupport------------");
        return SUCCESS;
    }
}
