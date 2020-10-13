package com.super404.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/fileDownload")
public class FileDownloadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //客户端传递需要下载的文件名
        String file = request.getParameter("file");

        //获取文件在我们项目中的路径,发布到tomcat的实际路径
        String path = request.getServletContext().getRealPath("/file/");

        String filePath = path + file;

        FileInputStream fis = new FileInputStream(filePath);

        response.setCharacterEncoding("UTF-8");

        //指明响应的配置信息，包含附件
        response.setHeader("Content-Disposition","attachment; filename="+file);

        //如果文件名不包含中文可以不设置该项
        //如果包含中文名，则需要设置编码，否则文件名下载后中文字符会乱码
        //getBytes指定了编码的方式，ISO-8859-1指定了解码（读取）的方式,想要转换编码，就是先编码，再解码
        response.setHeader("Content-Disposition","attachment; filename="+new String(file.getBytes("gb2312"),"ISO-8859-1"));

        ServletOutputStream out = response.getOutputStream();
        byte[] buf = new byte[1024];
        int len;

        while ((len= fis.read(buf)) != -1) {
            out.write(buf,0,len);
        }

        out.close();
        fis.close();


    }
}
