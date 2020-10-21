package com.super404.web.controller;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/responseServlet")
public class ResponseServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {

        //设置编码格式为UTF-8
        response.setCharacterEncoding("UTF-8");

        //设置有多个值的http响应头,参数name表示响应头名称,参数value表示响应头的值
        /*response.addHeader("name", "java");
        response.addHeader("name", "spring");*/

        //设置只有一个值的http响应头,参数name表示响应头名称,参数value表示响应头的值
        //response.setHeader("name", "spring");

        //设置http状态码
        //response.setStatus(200);

        //通过设置响应头控制浏览器以UTF-8的编码显示数据，如果不加这句话，那么浏览器显示的将是乱码
        response.setHeader("Content-Type","text/html;charset=utf-8");

        String data = "小滴课堂java高级工程师成长系列";

        /**
         * getOutputStream()创建的字节输出流对象，可以按字节形式输出响应正文，直接输出字节数组中的二进制数据,更多用于下载输出文件流
         */
        /*//获取OutputStream输出流
        ServletOutputStream outputStream = response.getOutputStream();
        //将字符转换成字节数组，指定以UTF-8编码进行转换
        byte[] dataByteArr = data.getBytes("UTF-8");
        //使用OutputStream流向客户端输出字节数组
        outputStream.write(dataByteArr);*/

        /**
         * getWriter()创建的字符输出流对象，可以按字符形式输出响应正文，只能输出输出字符文本内容，和上面的getOutputStream()互斥
         * 只能拿到两者中的一个
         */
        //获取PrintWriter输出流
        PrintWriter out = response.getWriter();
        //使用PrintWriter流向客户端输出字符
        out.write(data);

    }
}
