package com.gaoxing.demo1;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.Arrays;

@Component
@Aspect// 用来标注当前类为切面
@Order(2) // 多个切面，指定执行顺序，数字越小，执行越靠前
public class GoodsDaoAspect {

    /**
     * @Before： 将方法标注为前置通知
     * 前置通知：作用于方法执行之前
     * @param joinPoint
     */
    @Before(value = "GoodsDaoAspect.pointcute1() || GoodsDaoAspect.pointcute4() || GoodsDaoAspect.pointcute5()")
    public void log(JoinPoint joinPoint){
        // 获取方法参数
        Object[] args = joinPoint.getArgs();
        // 获取方法名
        // Signature signature = joinPoint.getSignature(); // 会获取到全路径的方法名 void com.gaoxing.demo1.GoodsDao.save(int,int)
        String methodName = joinPoint.getSignature().getName(); // 仅仅获取到方法名 sava

        System.out.println();
        System.out.println("前置通知====" + "方法名字为：" + methodName + "方法参数为：" + Arrays.toString(args));
    }

    /**
     * @AfterReturning： 将方法标注为返回通知
     * 返回通知： 作用于方法执行之后
     * 可通过returning设置接受方法返回值的变量名
     * @param res
     */
    @AfterReturning(value = "execution(* com.gaoxing.demo1.GoodsDaoImpl.update(..))",returning = "res")
    public void afterreturning(Object res){
        System.out.println("返回通知" + res);
    }



    // 环绕通知 抛异常写法
    /*@Around(value = "execution(* com.gaoxing.demo1.GoodsDaoImpl.delete(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("delete----之前");
        Object proceed = joinPoint.proceed();
        System.out.println("delete----之后");
        return proceed;
    }*/

    // // 环绕通知 try/catch写法
    @Around(value = "execution(* com.gaoxing.demo1.GoodsDaoImpl.delete(..))")
    public Object around(ProceedingJoinPoint joinPoint){

        Object proceed = null;
        try {
            // 前置通知
            proceed = joinPoint.proceed();
            // 返回通知
        } catch (Throwable throwable) {
            // 异常通知
            throwable.printStackTrace();
        }finally {
            // 最终通知
            return proceed;
        }

    }


    // 异常通知，例外通知
    @AfterThrowing(value = "execution(* com.gaoxing.demo1.GoodsDaoImpl.find(..))",throwing = "ex")
    public void afterThrowing(Throwable ex){
        System.out.println("异常通知" + ex);
    }
    /**
     * @After： 将方法标注为后置通知，也叫最终通知
     * 后置通知： 作用于方法的finally语句块，即不管有没有异常都会执行
     */
    @After(value = "execution(* com.gaoxing.demo1.GoodsDaoImpl.find(..))")
    public void afterM(){
        System.out.println("后置通知");
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
