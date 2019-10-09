package com.gaoxing.struts;

import com.opensymphony.xwork2.Action;

public class HelloAction2 implements Action {
    @Override
    public String execute() throws Exception {
        System.out.println("implements Action------------");
        return SUCCESS;
    }
}
