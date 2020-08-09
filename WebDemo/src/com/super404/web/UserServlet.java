package com.super404.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//新版Servelt，也就是3.0之后，支持注解的方式
//@WebServlet("/userServlet")
@WebServlet(name = "userServlet", urlPatterns = {"/user/login"})
public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);

        //对于以get方式传输的中文数据乱码需要另外一种方式，默认的还是使用ISO8859-1这个字符编码来接收数据
        //办法：对接收到的原始数据的字节数组，然后通过字节数组以指定的编码构建字符串，解决乱码问题
        /*String name = req.getParameter("name");//接收数据
        name =new String(name.getBytes("ISO8859-1"), "UTF-8");*/

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //POST方式遇到中文乱码，如果客户端是以UTF-8字符编码，需要服务器以UTF-8的编码接收数据
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        String userName = req.getParameter("userName");
        String pwd = req.getParameter("pwd");

        if (userName.equals("xdclass") && pwd.equals("123")) {
            resp.getWriter().write("登录成功");
        } else {
            resp.getWriter().write("账号密码错误");
        }
    }

}
