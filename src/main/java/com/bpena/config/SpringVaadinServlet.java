package com.bpena.config;

import com.vaadin.server.ServiceException;
import com.vaadin.server.SessionInitEvent;
import com.vaadin.server.SessionInitListener;
import com.vaadin.server.VaadinServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

/**
 * Created by Bernardo on 14/5/2016.
 */
public class SpringVaadinServlet extends VaadinServlet implements SessionInitListener {
    @Autowired
    protected VaadinUIProvider applicationProvider;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        AutowireCapableBeanFactory ctx = ((ApplicationContext) getServletContext().getAttribute(
                "applicationContext")).getAutowireCapableBeanFactory();
        // The following line does the magic
        ctx.autowireBean(this);
    }

    @Override
    protected void servletInitialized() throws ServletException {
        getService().addSessionInitListener(this);
    }

    @Override
    public void sessionInit(SessionInitEvent event) throws ServiceException {
        event.getSession().addUIProvider(applicationProvider);
    }
}
