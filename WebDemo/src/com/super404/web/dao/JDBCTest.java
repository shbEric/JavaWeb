package com.super404.web.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCTest {
    public static void main(String[] args) throws Exception {

        //加载JDBC驱动程序
        Class.forName("com.mysql.jdbc.Driver");

        //建立数据库连接Connection
        String username = "root";
        String password = "123456";
        //协议:子协议://ip:端口/数据库名称?参数1=值1&参数2=值2
        String url = "jdbc:mysql://127.0.0.1:3306/xd_web?useUnicode=true&characterEncoding=utf-8&useSSL=false";
        Connection connection = DriverManager.getConnection(url, username, password);

        //创建执行SQL的语句Statement
        Statement statement = connection.createStatement();

        //处理执行结果ResultSet
        ResultSet resultSet = statement.executeQuery("select * from user");
        while (resultSet.next()) {
            System.out.println("用户名称 name=" + resultSet.getString("username") +
                    "  联系方式 wechat=" + resultSet.getString("wechat"));
        }

        //释放连接资源
        resultSet.close();
        statement.close();
        connection.close();
    }
}
