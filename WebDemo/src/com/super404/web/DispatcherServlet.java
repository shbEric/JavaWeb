package com.super404.web;

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

        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
