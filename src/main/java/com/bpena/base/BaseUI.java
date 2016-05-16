package com.bpena.base;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.VerticalLayout;

/**
 * Created by Bernardo on 14/5/2016.
 */
public abstract class BaseUI extends VerticalLayout implements View {

    protected boolean validate() {
        return true;
    }

    protected boolean preSave() {
        return true;
    }

    protected boolean postSave() {
        return true;
    }

    protected boolean preCancel() {
        return true;
    }

    protected boolean postCancel() {
        return true;
    }

    protected boolean preNew() {
        return true;
    }

    protected boolean postNew() {
        return true;
    }

    protected boolean preEdit() {
        return true;
    }

    protected boolean postEdit() {
        return true;
    }

    protected boolean preDelete() {
        return true;
    }

    protected boolean postDelete() {
        return  true;
    }
}
