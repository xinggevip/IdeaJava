package com.gaoxing.web;

import com.gaoxing.domain.Goods;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;

public class HelloAction extends ActionSupport implements ModelDriven<Goods> {
    private Goods goods = new Goods();
    @Override
    public Goods getModel() {
        return goods;
    }
    public String execute(){
        // 获取值栈
        // 根区 非根区
        // 根区：当前action相关数据都存到根区
        // 非根区：是一些整个程序相关数据 相关域 req session application
        ValueStack valueStack = ActionContext.getContext().getValueStack();
        Goods goods1 = new Goods();
        goods1.setName("DF-17");
        goods1.setPrice(99999.0);
        // 入栈
        // valueStack.getRoot().push(goods1);
        valueStack.push(goods1);  // 简写 效果同上一句
        // 出栈
        // valueStack.getRoot().pop();
        // valueStack.pop(); // 简写 效果同上一句

        // 往域中写入数据
        // req
        ActionContext.getContext().put("reqName","reqValue");
        // session
        ActionContext.getContext().getSession().put("sessionName","sessionValue");
        // application
        ActionContext.getContext().getApplication().put("ApplicationName","ApplicationValue");

        return SUCCESS;
    }

}
