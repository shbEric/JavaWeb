package com.super404.web.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class RequestListener implements ServletRequestListener {

    @Override
    public void requestInitialized(ServletRequestEvent sre) {

        System.out.println("RequestListener requestInitialized");

        ServletContext servletContext = sre.getServletRequest().getServletContext();

        Integer totalVisit = (Integer) servletContext.getAttribute("totalVisit");

        System.out.println("历史总访问次数：" + totalVisit);

        servletContext.setAttribute("totalVisit", ++totalVisit);

    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {

        System.out.println("RequestListener requestDestroyed");

    }
}
