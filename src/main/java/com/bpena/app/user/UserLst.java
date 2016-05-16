package com.bpena.app.user;

import com.bpena.base.BaseUI;
import com.bpena.config.VaadinUI;
import com.vaadin.data.Container;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

/**
 * Created by Bernardo on 15/5/2016.
 */
public class UserLst extends BaseUI {
    final Container normalContainer = VaadinUI.generateContainer(200, false);

    Table table;
    public UserLst() {
        setMargin(true);
        setSpacing(true);

        Label h1 = new Label("Tables");
        h1.addStyleName(ValoTheme.LABEL_H1);
        addComponent(h1);

        table = new Table();
        table.setContainerDataSource(normalContainer);
        addComponent(table);
    }


    @Override
    public void enter(ViewChangeEvent event) {
        // TODO Auto-generated method stub

    }
}
