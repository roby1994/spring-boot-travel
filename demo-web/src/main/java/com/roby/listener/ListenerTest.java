package com.roby.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by Tao Pingping on 2018/3/21.
 */
public class ListenerTest implements ServletContextListener {
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("监听器销毁...");
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("监听器初始化...");
    }
}
