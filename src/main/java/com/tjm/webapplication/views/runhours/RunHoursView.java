package com.tjm.webapplication.views.runhours;

import ch.qos.logback.core.Layout;
import com.tjm.webapplication.views.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import javax.swing.*;
import java.awt.*;

@PageTitle("Machine Run-time")
@Route(value = "Run-Hours", layout = MainLayout.class)
public class RunHoursView extends VerticalLayout {

    private TextField name;
    private Button sayHello;

    public RunHoursView()
    {
        var layout = new HorizontalLayout(addbtn());
        add(layout);
        /*
        name = new TextField("Your name");
        sayHello = new Button("Say hello");
        sayHello.addClickListener(e -> {
            Notification.show("Hello " + name.getValue());
        });

        setMargin(true);
        setVerticalComponentAlignment(Alignment.END, name, sayHello);

        add(name, sayHello);

         */
    }

    public Button addbtn()
    {
        var button = new Button("Button");
        button.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        return button;
    }

}
