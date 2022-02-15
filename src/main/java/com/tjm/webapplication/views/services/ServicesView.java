package com.tjm.webapplication.views.services;

import com.tjm.webapplication.repositories.ServicesRepository;
import com.tjm.webapplication.views.MainLayout;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "Services", layout = MainLayout.class)
@PageTitle("Contacts | Vaadin CRM")
public class ServicesView extends Composite<VerticalLayout> {
    private final ServicesRepository servicesRepository;

    private Grid<Services> grid = new Grid<>();
    private TextField name = new TextField("Name");
    private TextField website = new TextField("Website");
    private Button save = new Button("Save", VaadinIcon.CHECK.create());
    private Button create = new Button("New", VaadinIcon.PLUS.create());
    private VerticalLayout form = new VerticalLayout(name, website, save);

    private Binder<Services> binder = new Binder<>(Services.class);
    private Services services;

    public ServicesView(ServicesRepository servicesRepository) {
        this.servicesRepository = servicesRepository;

        grid.addColumn(Services::getMachine).setHeader("Machine");
        grid.addColumn(Services::getService).setHeader("Service");
        grid.addSelectionListener(event -> setService(grid.asSingleSelect().getValue()));
        updateGrid();

        save.addClickListener(event -> saveClicked());
        create.addClickListener(event -> createClicked());

        getContent().add(grid, create, form);
        binder.bindInstanceFields(this);
        binder.setBean(null);
    }

    private void createClicked() {
        grid.asSingleSelect().clear();
        setService(new Services());
    }

    private void setService(Services service) {
        this.services = service;
        form.setEnabled(service != null);
        binder.setBean(service);
    }

    private void saveClicked() {
        binder.readBean(services);
        if (services.getMachine() == null) {
            servicesRepository.create(services);
        } else {
            servicesRepository.update(services);
        }
        updateGrid();
        Notification.show("Saved!");
    }

    private void updateGrid() {
        grid.setItems(servicesRepository.findAll());
    }

}
