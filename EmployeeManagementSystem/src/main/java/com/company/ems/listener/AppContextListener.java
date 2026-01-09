package com.company.ems.listener;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

public class AppContextListener
        implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("EMS Application Started");
    }

    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("EMS Application Stopped");
    }
}
