package com.super404.web.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;

public class JDBCTest {
    public static void main(String[] args) throws Exception {

        /*//加载JDBC驱动程序
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
        connection.close();*/

        //testInjectSQL();
        //testPrepareStatement();
        //testAdd();
        testDelete();
    }

    //SQL注入攻击的例子
    private static void testInjectSQL() throws Exception{
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

        String name = "jack";
        String pwd = "666' or 1=1 or'";

        String sql = "select * from user where username='" + name + "' and pwd='" + pwd + "'";
        System.out.println(sql);

        //处理执行结果ResultSet
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            System.out.println("用户名称 name=" + resultSet.getString("username") +
                    "  联系方式 wechat=" + resultSet.getString("wechat"));
        }

        //释放连接资源
        resultSet.close();
        statement.close();
        connection.close();
    }

    //防止攻击的例子
    private static void testPrepareStatement() throws Exception{
        //加载JDBC驱动程序
        Class.forName("com.mysql.jdbc.Driver");

        //建立数据库连接Connection
        String username = "root";
        String password = "123456";
        //协议:子协议://ip:端口/数据库名称?参数1=值1&参数2=值2
        String url = "jdbc:mysql://127.0.0.1:3306/xd_web?useUnicode=true&characterEncoding=utf-8&useSSL=false";
        Connection connection = DriverManager.getConnection(url, username, password);

        String name = "jack";
        String pwd = "666' or 1=1 or'";
        //创建执行SQL的语句Statement
        PreparedStatement preparedStatement = connection.prepareStatement("select * from user where username=? and pwd=?");
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, pwd);


        //处理执行结果ResultSet
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println("用户名称 name=" + resultSet.getString("username") +
                    "  联系方式 wechat=" + resultSet.getString("wechat"));
        }

        //释放连接资源
        resultSet.close();
        preparedStatement.close();
        connection.close();
    }

    //新增记录
    private static void testAdd() throws Exception{
        //加载JDBC驱动程序
        Class.forName("com.mysql.jdbc.Driver");

        //建立数据库连接Connection
        String username = "root";
        String password = "123456";
        //协议:子协议://ip:端口/数据库名称?参数1=值1&参数2=值2
        String url = "jdbc:mysql://127.0.0.1:3306/xd_web?useUnicode=true&characterEncoding=utf-8&useSSL=false";
        Connection connection = DriverManager.getConnection(url, username, password);

        //创建执行SQL的语句Statement
        PreparedStatement preparedStatement = connection.prepareStatement("insert into user(username,pwd,sex,role,create_time) values(?,?,?,?,?)");
        preparedStatement.setString(1,"二当家小D");
        preparedStatement.setString(2,"123456");
        preparedStatement.setInt(3,1);
        preparedStatement.setInt(4,2);
        preparedStatement.setTimestamp(5, new Timestamp(System.currentTimeMillis()));

        //处理执行
        preparedStatement.execute();

        preparedStatement.close();
        connection.close();
    }

    //删除记录
    private static void testDelete() throws Exception{
        //加载JDBC驱动程序
        Class.forName("com.mysql.jdbc.Driver");

        //建立数据库连接Connection
        String username = "root";
        String password = "123456";
        //协议:子协议://ip:端口/数据库名称?参数1=值1&参数2=值2
        String url = "jdbc:mysql://127.0.0.1:3306/xd_web?useUnicode=true&characterEncoding=utf-8&useSSL=false";
        Connection connection = DriverManager.getConnection(url, username, password);

        //创建执行SQL的语句Statement
        PreparedStatement preparedStatement = connection.prepareStatement("delete from user where id=?");
        preparedStatement.setInt(1, 5);

        //处理执行
        preparedStatement.execute();

        preparedStatement.close();
        connection.close();
    }
}
