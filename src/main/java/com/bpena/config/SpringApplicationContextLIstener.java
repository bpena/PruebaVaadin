package com.bpena.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Created by Bernardo on 14/5/2016.
 */
@WebListener
public class SpringApplicationContextLIstener implements ServletContextListener{

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfiguration.class);
        servletContextEvent.getServletContext().setAttribute("applicationContext", applicationContext);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
