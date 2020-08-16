package com.super404.web.servlet;

import com.super404.web.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String pwd = req.getParameter("pwd");

        System.out.println(name + " " + pwd);

        if (name.equals("xdclass") && pwd.equals("123")) {

            if (req.getSession().isNew()) {
                req.setAttribute("msg", "登录失效，请再次登录");
                req.getRequestDispatcher("/login.jsp").forward(req, resp);
            } else {
                User user = new User();
                user.setId(123);
                user.setName(name);
                user.setHost("xdclass.net");
                req.getSession().setAttribute("loginUser", user);
                req.getRequestDispatcher("/WEB-INF/user.jsp").forward(req, resp);
            }
        } else {
            req.setAttribute("msg", "账号密码错误");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }
}
