package com.bpena.base;

import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

/**
 * Created by Bernardo on 16/5/2016.
 */
public class BaseDetailUI extends BaseUI {
    protected Label title;
    protected FormLayout form;
    protected Button headerAccept;
    protected Button headerCancel;
    protected Button footerAccept;
    protected Button footerCancel;
    protected HorizontalLayout header;
    protected HorizontalLayout footer;
    protected boolean showHeader;

    public BaseDetailUI() {
        setSpacing(true);
        setMargin(true);

        setTitle("");
        setHeader();
        setForm();
        setFooter();
    }

    protected void setTitle(String title) {
        this.title = new Label(title);
        this.title.addStyleName(ValoTheme.LABEL_H1);
        addComponent(this.title);
    }

    protected void setHeader() {
        setHeader(true);
    }

    protected void setHeader(boolean showHeader) {
        this.showHeader = showHeader;
        if (this.showHeader == true) {
            header = new HorizontalLayout();
            header.setWidth("100%");
            header.setMargin(false);
            header.setSpacing(false);

            HorizontalLayout buttonSection = new HorizontalLayout();
            buttonSection.setMargin(false);
            buttonSection.setSpacing(true);

            headerAccept = new Button("Accept", clickEvent -> onSave());
            buttonSection.addComponent(headerAccept);

            headerCancel = new Button("Cancel", clickEvent -> onCancel());
            buttonSection.addComponent(headerCancel);

            header.addComponent(buttonSection);
            header.setComponentAlignment(buttonSection, Alignment.MIDDLE_RIGHT);

            addComponent(header);
        }
    }

    protected void setForm() {
        form = new FormLayout();
        form.setMargin(false);
        form.setWidth("800px");
        form.addStyleName(ValoTheme.FORMLAYOUT_LIGHT);
        addComponent(form);
    }

    protected void setFooter() {
        footer = new HorizontalLayout();
        footer.setWidth("100%");
        footer.setMargin(true);
        footer.setSpacing(true);
        footer.setDefaultComponentAlignment(Alignment.MIDDLE_RIGHT);


        HorizontalLayout buttonSection = new HorizontalLayout();
        buttonSection.setMargin(false);
        buttonSection.setSpacing(true);

        footerAccept = new Button("Accept", clickEvent -> onSave());
        buttonSection.addComponent(footerAccept);

        footerCancel = new Button("Cancel", clickEvent -> onCancel());
        buttonSection.addComponent(footerCancel);

        footer.addComponent(buttonSection);

        addComponent(footer);
    }

    @Override
    public void setReadOnly(boolean readOnly) {
        super.setReadOnly(readOnly);
//        for (Component c : form)
//            c.setReadOnly(readOnly);

        udpateButtons(readOnly);
    }

    private void udpateButtons(boolean readOnly) {
        if (this.showHeader)
            this.header.setVisible(!readOnly);
        footerAccept.setVisible(!readOnly);
        footerCancel.setVisible(!readOnly);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {

    }
}
