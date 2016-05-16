package com.bpena.app.user;

import com.bpena.base.BaseContainerUI;
import com.vaadin.navigator.ViewChangeListener;

/**
 * Representa la vista principal de la entidad usuarios.
 * Creado por bpena el 15/5/2016.
 */
public class UserView extends BaseContainerUI {
    public UserView() {
        super();

        this.detailView = new UserDtl();
        this.listView = new UserLst();
        this.filterView = new UserDtl();
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {

    }
}
