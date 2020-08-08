package com.super404.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//新版Servelt，也就是3.0之后，支持注解的方式
//@WebServlet("/userServlet")
@WebServlet(name = "userServlet", urlPatterns = {"/user1","/user2","/userServlet"})
public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("doGet");

        //设置响应内容
        resp.setContentType("text/html;charset=utf-8");

        PrintWriter printWriter = resp.getWriter();

        printWriter.write("<div> doGet hello Word! 你好，中文！ </div>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("doPost");

        //设置响应内容
        resp.setContentType("text/html;charset=utf-8");

        PrintWriter printWriter = resp.getWriter();

        printWriter.write("<div> doPost hello Word! 你好，中文！ </div>");
    }

    /**
     * destroy() 方法仅执行一次，即在服务器停止且卸装 Servlet 时执行该方法
     */
    @Override
    public void destroy() {
        System.out.println("servlet destroy");
        super.destroy();
    }

    /**
     * Servlet 的生命期中，仅执行一次 init() 方法，它是在服务器装入 Servlet 时执行的,即第一次访问这个Servlet才执行
     * @throws ServletException
     */
    @Override
    public void init() throws ServletException {
        System.out.println("servlet init");
        super.init();
    }
}
