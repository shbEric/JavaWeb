package com.super404.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/gene_cookie_test")
public class GeneCookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Cookie cookie = new Cookie("token", "fafwalcfdchkadkonac");
        //20秒过期时间，过期后不会自动携带过去
        cookie.setMaxAge(20);

        response.addCookie(cookie);

        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
