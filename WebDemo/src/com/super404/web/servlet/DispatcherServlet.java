package com.super404.web.servlet;

import com.super404.web.domain.Config;
import com.super404.web.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/forward")
public class DispatcherServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Config config = (Config) req.getServletContext().getAttribute("config");
        System.out.println(config.getTopic());
        System.out.println(config.getUrl());


        System.out.println("DispatcherServlet doGet");

        //req.getRequestDispatcher("/WEB-INF/admin.jsp").forward(req, resp);

        //存储java对象到request作用域，转发后一样可以获取到值，具体怎么获取？JSP或者EL表达式
        /*req.setAttribute("name","jack");
        req.getRequestDispatcher("requestServlet").forward(req, resp);*/

        req.setAttribute("name","jack");

        User user = new User();
        user.setId(1);
        user.setName("xdclass");
        user.setHost("https://xdclass.net");
        req.setAttribute("user", user);

        //req.getRequestDispatcher("/index.jsp").forward(req, resp);


        //请求重定向，不能访问WEB-INF下的文件，浏览器上的窗口地址会改版，可以用于跳转第三方地址或者应用里面的其他Servelt、jsp等
        //重定向是取不到request中的存储的数据,如果当前servlet是重定向，浏览器可以看到两个请求

        //重定向路径问题：如果没有加 http 开头，则认为是当前应用里面的servlet重定向，默认加上应用上下文；如果有加http则会使用配置的全路径进行跳转
        //如果请求转发可以满足需要时，尽量使用请求转发，而不是重定向，效率性能更好
        resp.sendRedirect("/index.jsp");
        //resp.sendRedirect("https://xdclass.net");
    }
}
