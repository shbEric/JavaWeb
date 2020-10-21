package com.super404.web.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/session_servlet")
public class SessionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        //获取sessionid，java里面叫jsessionid
        System.out.println("sessionid="+session.getId());
        //创建时间戳,毫秒
        System.out.println("getCreationTime="+session.getCreationTime());

        //是否是初次创建，记得情况浏览器的cookie,验证sessionid
        System.out.println("isNew="+session.isNew());

        //往session存储东西
        session.setAttribute("name","小滴课堂 xdclass.net");
    }
}
