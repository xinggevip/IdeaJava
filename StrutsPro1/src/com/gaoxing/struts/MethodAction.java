package com.gaoxing.struts;

import com.opensymphony.xwork2.ActionSupport;

public class MethodAction extends ActionSupport {
    public String add(){
        System.out.println("添加");
        return null;
    }
    public String delete(){
        System.out.println("删除");
        return null;
    }
    public String update(){
        System.out.println("修改");
        return null;
    }
    public String find(){
        System.out.println("查找");
        return null;
    }
}
