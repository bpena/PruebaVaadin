package com.bpena.config;

import com.vaadin.server.UIClassSelectionEvent;
import com.vaadin.server.UICreateEvent;
import com.vaadin.server.UIProvider;
import com.vaadin.ui.UI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

/**
 * Created by Bernardo on 14/5/2016.
 */
public class VaadinUIProvider extends UIProvider {
    @Autowired
    ApplicationContext applicationContext;

    @Override
    public Class<? extends UI> getUIClass(UIClassSelectionEvent uiClassSelectionEvent) {
        return VaadinUI.class;
    }

    @Override
    public UI createInstance(UICreateEvent event) {
        UI instance = new VaadinUI();
        applicationContext.getAutowireCapableBeanFactory().autowireBean(instance);
        return instance;
    }
}
