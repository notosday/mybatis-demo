package com.example.demo.filter;

import com.alibaba.fastjson.JSONObject;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by kewuwei on 2017/6/7.
 */
@WebFilter(filterName = "cityFilter")
public class CommonFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("过滤器初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("执行过滤操作");

        boolean checkAuth = checkAuth(servletRequest);

        if(checkAuth) {
            filterChain.doFilter(servletRequest,servletResponse);
        } else {
            HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
            httpServletResponse.setCharacterEncoding("utf-8");
            httpServletResponse.setContentType("application/json;charset=utf-8");
            httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("message","权限不足");
            httpServletResponse.getWriter().write(jsonObject.toString());
            return;
        }

    }

    @Override
    public void destroy() {
        System.out.println("过滤器销毁");
    }

    //比较http请求头部中的验证字段是否合法
    public boolean checkAuth(ServletRequest servletRequest) {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String authorization = request.getHeader("Authorization");
        boolean result = "basic crud".equals(authorization);
        return result;
    }
}
