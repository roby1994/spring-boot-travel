package com.roby.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by Tao Pingping on 2018/3/21.
 */
public class TimeFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("=======初始化过滤器=========");

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        long start = System.currentTimeMillis();
        chain.doFilter(request,response);
        System.out.println("filter 耗时：" + (System.currentTimeMillis() - start));
    }

    @Override
    public void destroy() {
        System.out.println("=======销毁过滤器=========");
    }
}
