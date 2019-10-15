package com.gaoxing.demo1;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class GoodsDaoAspect {
    // 前置通知
    @Before(value = "GoodsDaoAspect.pointcute1() || GoodsDaoAspect.pointcute4() || GoodsDaoAspect.pointcute5()")
    public void log(){
        System.out.println("日志");
    }
    // 后置通知
    @AfterReturning(value = "execution(* com.gaoxing.demo1.GoodsDaoImpl.update(..))",returning = "res")
    public void afterreturning(Object res){
        System.out.println("后置通知" + res);
    }
    // 环绕通知
    @Around(value = "execution(* com.gaoxing.demo1.GoodsDaoImpl.delete(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("delete----之前");
        Object proceed = joinPoint.proceed();
        System.out.println("delete----之后");
        return proceed;
    }
    // 异常通知
    @AfterThrowing(value = "execution(* com.gaoxing.demo1.GoodsDaoImpl.find(..))",throwing = "ex")
    public void afterThrowing(Throwable ex){
        System.out.println("异常通知" + ex);
    }
    // 最终通知
    @After(value = "execution(* com.gaoxing.demo1.GoodsDaoImpl.find(..))")
    public void afterM(){
        System.out.println("最终通知");
    }

    // 给全路径起别名
    @Pointcut(value = "execution(* com.gaoxing.demo1.GoodsDaoImpl.save(..))")
    private void pointcute1(){}
    @Pointcut(value = "execution(* com.gaoxing.demo1.GoodsDaoImpl.update(..))")
    private void pointcute2(){}
    @Pointcut(value = "execution(* com.gaoxing.demo1.GoodsDaoImpl.delete(..))")
    private void pointcute3(){}
    @Pointcut(value = "execution(* com.gaoxing.demo1.GoodsDaoImpl.find(..))")
    private void pointcute4(){}
    @Pointcut(value = "execution(* com.gaoxing.demo1.UserDao.save(..))")
    private void pointcute5(){}


}