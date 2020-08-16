package com.super404.web.filter;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

//@WebFilter(filterName = "customFilter",servletNames = {"getCookieServlet"}, urlPatterns = {"/user/*","/order/*"})
@WebFilter(filterName = "customFilter",urlPatterns = {"/*"},
        initParams = {
        @WebInitParam(name = "encoding", value = "UTF-8"),
        @WebInitParam(name = "loginPage", value = "/login.jsp")
        },
        dispatcherTypes = {DispatcherType.FORWARD, DispatcherType.REQUEST})
public class CustomFilter implements Filter {

    private FilterConfig filterConfig;
    private String encoding;
    private String loginPage;

    //只容器初始化的时候调用一次，即应用启动的时候加载一次
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        System.out.println("CustomFilter init");

        this.filterConfig = filterConfig;
        String filterName = filterConfig.getFilterName();
        System.out.println("filterName=" + filterName);
        this.encoding = filterConfig.getInitParameter("encoding");
        this.loginPage = filterConfig.getInitParameter("loginPage");

    }

    //只要命中过滤规则就触发，可以在filter中根据条件决定是否调用chain.doFilter(request, response)方法， 即是否让目标资源执行
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        System.out.println("CustomFilter doFilter");

        request.setCharacterEncoding(encoding);
        response.setCharacterEncoding(encoding);
        response.setContentType("text/html;charset=utf-8");

        //让请求继续往下走
        chain.doFilter(request, response);

    }

    //只容器销毁的时候调用一次，即应用停止的时候调用一次
    @Override
    public void destroy() {

        System.out.println("CustomFilter destroy");

    }
}
