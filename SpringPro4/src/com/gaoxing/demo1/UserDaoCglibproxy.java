package com.gaoxing.demo1;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class UserDaoCglibproxy implements MethodInterceptor {
    public UserDao createCglibproxy(UserDao userDao){
        // 1.创建核心类
        Enhancer enhancer = new Enhancer();
        // 2.设置父类 继承方式 创建一个子类，自动继承 UserDao
        enhancer.setSuperclass(userDao.getClass());
        // 3.设置回调
        enhancer.setCallback(this);
        // 4.创建代理对象 就是把子类给你
        UserDao userDao1 = (UserDao) enhancer.create();
        return userDao1;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        if("save".equals(method.getName())){ // 调用save则调用以下
            System.out.println("权限操作-----");
            Object obj = methodProxy.invokeSuper(o, objects);
            System.out.println("日志保存操作----");
            return obj;

        }
        return methodProxy.invokeSuper(o,objects);

    }
}
