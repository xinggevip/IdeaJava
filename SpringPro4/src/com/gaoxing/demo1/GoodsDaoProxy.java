package com.gaoxing.demo1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class GoodsDaoProxy {
    // 增强
    public GoodsDao createeProxy(GoodsDao goodsDao) {
        GoodsDao goodsDaoProxy = (GoodsDao) Proxy.newProxyInstance(goodsDao.getClass().getClassLoader(),
                goodsDao.getClass().getInterfaces(), new InvocationHandler() {
                    @Override /*  当调用对象的时候，所有的方法都会到这里 */
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        if("save".equals(method.getName())){ // 调用对象的方法名称如果为save，则执行
                            System.out.println("权限校验-----"); // 执行对象方法前执行该语句
                            GoodsDao goodsDao1 = (GoodsDao)method.invoke(goodsDao,args);
                            System.out.println("日志添加-----"); // 执行对象方法后创建该语句
                            return goodsDao1;
                        }
                        return method.invoke(goodsDao, args);
                    }
                });
        return goodsDaoProxy;
    }
}
