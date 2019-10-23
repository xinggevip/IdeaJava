package com.gaoxing.web.interceptor;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MySecondnterceptor implements HandlerInterceptor {
    // 处理器方法执行前调用
    // 返回值：true  放行  false 不放行  不放行就执行不了处理器方法
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle处理器方法执行前调用2");
        return true;
    }

    // 处理器方法执行后调用
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle处理器方法执行后调用2");
    }

    // 请求处理完毕后调用
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        System.out.println("afterCompletion请求处理完毕后调用2");
        /**
         * 拦截器执行顺序，preHandle按照顺序拦截，postHandle，afterCompletion倒序拦截
         * preHandle处理器方法执行前调用1
         * preHandle处理器方法执行前调用2
         * postHandle处理器方法执行后调用2
         * postHandle处理器方法执行后调用1
         * afterCompletion请求处理完毕后调用2
         * afterCompletion请求处理完毕后调用1
         */
    }
}
