package com.super404.web.listener;

import com.super404.web.domain.Config;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("ContextListener contextInitialized");

        ServletContext servletContext = sce.getServletContext();

        String url = servletContext.getInitParameter("url");
        String topic = servletContext.getInitParameter("topic");

        Config config = new Config();
        config.setTopic(topic);
        config.setUrl(url);

        servletContext.setAttribute("config", config);

        //获取上下文对象
        servletContext.setAttribute("onlineNum",0);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("ContextListener contextDestroyed");
    }
}
