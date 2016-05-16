package com.bpena.base;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.MenuBar.MenuItem;
import com.vaadin.ui.VerticalLayout;

/**
 *
 */
public class BaseContainerUI extends VerticalLayout implements View {
    protected MenuBar menubar;
    protected MenuItem newBtn;
    protected MenuItem editBtn;
    protected MenuItem deleteBtn;
    protected MenuItem filterBtn;
    protected MenuItem detailViewBtn;
    protected MenuItem listViewBtn;

    protected VerticalLayout container;
    protected BaseUI listView;
    protected BaseUI detailView;
    protected BaseUI filterView;

    public enum modes {
        BROWSE,
        EDIT
    }

    public enum views {
        DETAIL,
        FILTER,
        LIST
    }

    public enum actionMenu {
        NEW,
        EDIT,
        DELETE,
        FILTER,
        DETAIL,
        LIST
    }

    protected modes mode;
    protected views view;

    public BaseContainerUI() {
        menubar = getMenuBar();
        addComponent(menubar);

        container = new VerticalLayout();
        addComponent(container);
    }

    protected MenuBar getMenuBar() {
        mode = modes.BROWSE;
        view = views.LIST;

        MenuBar menubar = new MenuBar();
        menubar.setWidth("100%");
        newBtn = menubar.addItem("New", menuItem -> goToView(actionMenu.NEW));
        editBtn = menubar.addItem("Edit", menuItem -> goToView(actionMenu.EDIT));
        deleteBtn = menubar.addItem("Delete", menuItem -> deleteConfirm());
        filterBtn = menubar.addItem("Filtrar", menuItem -> goToView(actionMenu.FILTER));
        detailViewBtn = menubar.addItem("Detalle", menuItem ->  goToView(actionMenu.DETAIL));
        listViewBtn = menubar.addItem("Listado", menuItem -> goToView(actionMenu.LIST));

        return menubar;
    }

    protected void goToView(actionMenu menuAction) {
        BaseUI oldComponent = null;
        BaseUI newComponent;

        switch (menuAction) {
            case NEW:
                updateMenu(modes.EDIT, views.DETAIL);
                newComponent = detailView;
                newComponent.onNew();
                break;
            case EDIT:
                updateMenu(modes.EDIT, views.DETAIL);
                newComponent = detailView;
                newComponent.onEdit();
                break;
            case DELETE:
                newComponent = listView;
                break;
            case FILTER:
                updateMenu(modes.EDIT, views.DETAIL);
                newComponent = detailView;
                break;
            case DETAIL:
                updateMenu(modes.BROWSE, views.DETAIL);
                newComponent = detailView;
                break;
            case LIST:
                updateMenu(modes.BROWSE, views.LIST);
                newComponent = listView;
                break;
            default:
                newComponent = listView;
        }

        if (container.getComponentCount() > 0)
            oldComponent = (BaseUI) container.getComponent(0);

        newComponent.setParentContainer(this);
        container.replaceComponent(oldComponent, newComponent);
    }

    protected void deleteConfirm() {

    }

    protected void updateMenu(modes mode, views view) {
        this.view = view;
        this.mode = mode;

        newBtn.setEnabled(this.mode == modes.BROWSE);
        editBtn.setEnabled(this.mode == modes.BROWSE);
        deleteBtn.setEnabled(this.mode == modes.BROWSE);

        filterBtn.setEnabled(this.mode == modes.BROWSE);

        detailViewBtn.setEnabled(this.mode == modes.BROWSE && this.view == views.LIST);
        listViewBtn.setEnabled(this.mode == modes.BROWSE && this.view == views.DETAIL);

    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {

    }
}