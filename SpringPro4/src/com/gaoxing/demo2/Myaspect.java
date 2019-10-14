package com.gaoxing.demo2;

import org.aspectj.lang.ProceedingJoinPoint;

public class Myaspect {
    public void check(){
        System.out.println("权限校验----");
    }
    public void log(Object res){
        System.out.println("日志记录----");
        System.out.println("接受都的返回值为：" + (String)res);
    }
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("开启事务");
        Object proceed = joinPoint.proceed();
        System.out.println("关闭事务");
        return proceed;
    }

    public void exceptionM(Throwable ex){
        System.out.println("有异常：" + ex.getMessage());
    }

    public void after(){
        System.out.println("最终通知");
    }
}
