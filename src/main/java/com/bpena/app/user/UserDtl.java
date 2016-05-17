package com.bpena.app.user;

import com.bpena.app.StringGenerator;
import com.bpena.base.BaseDetailUI;

import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.UserError;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

import java.util.Calendar;

/**
 *
 * @since
 * @author Vaadin Ltd
 */
public class UserDtl extends BaseDetailUI {

    private TextField name;
    private DateField birthday;
    private TextField username;
    private OptionGroup sex;
    private TextField email;
    private TextField location;
    private TextField phone;
    private ComboBox period;
    private TextField website;
    private TextArea shortbio;
    private RichTextArea bio;

    public UserDtl() {
        super();
    }

    @Override
    protected void setTitle(String title) {
        super.setTitle("Forms");
    }

    @Override
    protected void setForm() {
        super.setForm();

        Label section = new Label("Personal Info");
        section.addStyleName(ValoTheme.LABEL_H2);
        section.addStyleName(ValoTheme.LABEL_COLORED);
        form.addComponent(section);

        StringGenerator sg = new StringGenerator();

        name = new TextField("Name");
        name.setWidth("50%");
        name.setValue("Lorem Ipsum");
        form.addComponent(name);

        birthday = new DateField("Birthday");
        form.addComponent(birthday);

        username = new TextField("Username");
        username.setRequired(true);
        form.addComponent(username);

        sex = new OptionGroup("Sex");
        sex.addItem("Female");
        sex.addItem("Male");
        sex.addStyleName(ValoTheme.OPTIONGROUP_HORIZONTAL);
        form.addComponent(sex);

        section = new Label("Contact Info");
        section.addStyleName(ValoTheme.LABEL_H3);
        section.addStyleName(ValoTheme.LABEL_COLORED);
        form.addComponent(section);

        email = new TextField("Email");
        email.setWidth("50%");
        email.setRequired(true);
        form.addComponent(email);

        location = new TextField("Location");
        location.setWidth("50%");
        location.setComponentError(new UserError("This address doesn't exist"));
        form.addComponent(location);

        phone = new TextField("Phone");
        phone.setWidth("50%");
        form.addComponent(phone);

        HorizontalLayout wrap = new HorizontalLayout();
        wrap.setSpacing(true);
        wrap.setDefaultComponentAlignment(Alignment.MIDDLE_LEFT);
        wrap.setCaption("Newsletter");
        CheckBox newsletter = new CheckBox("Subscribe to newsletter", true);
        wrap.addComponent(newsletter);

        period = new ComboBox();
        period.setTextInputAllowed(false);
        period.addItem("Daily");
        period.addItem("Weekly");
        period.addItem("Montly");
        period.setNullSelectionAllowed(false);
        period.addStyleName(ValoTheme.COMBOBOX_SMALL);
        period.setWidth("10em");
        wrap.addComponent(period);
        form.addComponent(wrap);

        section = new Label("Additional Info");
        section.addStyleName(ValoTheme.LABEL_H4);
        section.addStyleName(ValoTheme.LABEL_COLORED);
        form.addComponent(section);

        website = new TextField("Website");
        website.setInputPrompt("http://");
        website.setWidth("100%");
        form.addComponent(website);

        shortbio = new TextArea("Short Bio");
        shortbio.setWidth("100%");
        shortbio.setRows(2);
        form.addComponent(shortbio);

        bio = new RichTextArea("Bio");
        bio.setWidth("100%");
        form.addComponent(bio);
    }

    @Override
    protected void setEntityValues() {
        StringGenerator sg = new StringGenerator();
        Calendar cal = Calendar.getInstance();
        cal.set(80, 0, 31);
        birthday.setValue(cal.getTime());
        username.setValue(sg.nextString(false) + sg.nextString(false));
        sex.select("Male");
        email.setValue(sg.nextString(false) + "@" + sg.nextString(false)+ ".com");
        location.setValue(sg.nextString(true) + ", " + sg.nextString(true));
        period.select("Weekly");
        shortbio.setValue("Quis aute iure reprehenderit in voluptate velit esse. Cras mattis iudicium purus sit amet fermentum.");
        bio.setValue("<div><p><span>Integer legentibus erat a ante historiarum dapibus.</span> <span>Vivamus sagittis lacus vel augue laoreet rutrum faucibus.</span> <span>A communi observantia non est recedendum.</span> <span>Morbi fringilla convallis sapien, id pulvinar odio volutpat.</span> <span>Ab illo tempore, ab est sed immemorabili.</span> <span>Quam temere in vitiis, legem sancimus haerentia.</span></p><p><span>Morbi odio eros, volutpat ut pharetra vitae, lobortis sed nibh.</span> <span>Quam diu etiam furor iste tuus nos eludet?</span> <span>Cum sociis natoque penatibus et magnis dis parturient.</span> <span>Quam diu etiam furor iste tuus nos eludet?</span> <span>Tityre, tu patulae recubans sub tegmine fagi  dolor.</span></p><p><span>Curabitur blandit tempus ardua ridiculus sed magna.</span> <span>Phasellus laoreet lorem vel dolor tempus vehicula.</span> <span>Etiam habebis sem dicantur magna mollis euismod.</span> <span>Hi omnes lingua, institutis, legibus inter se differunt.</span></p></div>");
    }

    @Override
    protected void cleanValues() {
        birthday.setValue(null);
        username.setValue("");
        sex.select(null);
        email.setValue("");
        location.setValue("");
        period.select(null);
        shortbio.setValue("");
        bio.setValue("");

    }

    @Override
    public void enter(ViewChangeEvent viewChangeEvent) {

    }
}