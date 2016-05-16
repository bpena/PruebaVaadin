package com.bpena.app.user;

import com.bpena.app.TestIcon;
import com.bpena.base.BaseUI;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.MenuBar.Command;
import com.vaadin.ui.MenuBar.MenuItem;
import com.vaadin.ui.Notification;

/**
 * Created by Bernardo on 15/5/2016.
 */
public class UserView extends BaseUI {
    public UserView() {
        MenuBar menuBar = getMenuBar();
        addComponent(menuBar);
    }

    public static MenuBar getMenuBar() {
        Command click = new Command() {
            @Override
            public void menuSelected(MenuItem selectedItem) {
                Notification.show("Clicked " + selectedItem.getText());
            }
        };

        MenuBar menubar = new MenuBar();
        menubar.setWidth("100%");
        final MenuBar.MenuItem file = menubar.addItem("File", null);
        final MenuBar.MenuItem newItem = file.addItem("New", null);
        file.addItem("Open file...", click);
        file.addSeparator();

        newItem.addItem("File", click);
        newItem.addItem("Folder", click);
        newItem.addItem("Project...", click);

        file.addItem("Close", click);
        file.addItem("Close All", click);
        file.addSeparator();

        file.addItem("Save", click);
        file.addItem("Save As...", click);
        file.addItem("Save All", click);

        final MenuBar.MenuItem edit = menubar.addItem("Edit", null);
        edit.addItem("Undo", click);
        edit.addItem("Redo", click).setEnabled(false);
        edit.addSeparator();

        edit.addItem("Cut", click);
        edit.addItem("Copy", click);
        edit.addItem("Paste", click);
        edit.addSeparator();

        final MenuBar.MenuItem find = edit.addItem("Find/Replace", null);

        find.addItem("Google Search", click);
        find.addSeparator();
        find.addItem("Find/Replace...", click);
        find.addItem("Find Next", click);
        find.addItem("Find Previous", click);

        Command check = new Command() {
            @Override
            public void menuSelected(MenuItem selectedItem) {
                Notification.show(selectedItem.isChecked() ? "Checked"
                        : "Unchecked");
            }
        };

        final MenuBar.MenuItem view = menubar.addItem("View", null);
        view.addItem("Show Status Bar", check).setCheckable(true);
        MenuItem title = view.addItem("Show Title Bar", check);
        title.setCheckable(true);
        title.setChecked(true);
        view.addItem("Customize Toolbar...", click);
        view.addSeparator();

        view.addItem("Actual Size", click);
        view.addItem("Zoom In", click);
        view.addItem("Zoom Out", click);

        TestIcon testIcon = new TestIcon(50);

        MenuItem fav = menubar.addItem("", check);
        fav.setIcon(testIcon.get());
        fav.setStyleName("icon-only");
        fav.setCheckable(true);
        fav.setChecked(true);

        fav = menubar.addItem("", check);
        fav.setIcon(testIcon.get());
        fav.setStyleName("icon-only");
        fav.setCheckable(true);
        fav.setCheckable(true);

        menubar.addItem("Attach", click).setIcon(FontAwesome.PAPERCLIP);
        menubar.addItem("Undo", click).setIcon(FontAwesome.UNDO);
        MenuItem redo = menubar.addItem("Redo", click);
        redo.setIcon(FontAwesome.REPEAT);
        redo.setEnabled(false);
        menubar.addItem("Upload", click).setIcon(FontAwesome.UPLOAD);

        return menubar;
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {

    }
}
