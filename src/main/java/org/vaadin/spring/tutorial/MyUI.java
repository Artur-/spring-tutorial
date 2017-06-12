package org.vaadin.spring.tutorial;

import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SpringUI
public class MyUI extends UI {

    public static class TestObject {

    }

    @Override
    protected void init(VaadinRequest request) {
        // Note that getSession() returns VaadinSession, not the underlying HTTP
        // session. Use getSession().getSession() to get the wrapped HTTP
        // session
        getSession().setAttribute("not.serializable", new TestObject());
        final VerticalLayout root = new VerticalLayout();
        root.setSizeFull();
        setContent(root);

        root.addComponent(new Label("Good, now reload the app"));
    }

}
