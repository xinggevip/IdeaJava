package com.gaoxing.demo1;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class GoodsDaoAspect {
    @Before(value = "execution(* com.gaoxing.demo1.GoodsDaoImpl.*(..))")
    public void log(){
        System.out.println("日志");
    }
}
