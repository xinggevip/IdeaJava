package com.gaoxing.web.filter;

import javax.servlet.*;
import java.io.IOException;

public class SecFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 当服务器调用时执行
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 当有请求时执行，匹配xml中的map时
        System.out.println("来到了过滤器2");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        // 服务器关闭时执行
    }
}
