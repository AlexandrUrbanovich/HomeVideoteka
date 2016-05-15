package ru.mail.sanches.view.impl;


import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import ru.mail.sanches.entity.Producer;
import ru.mail.sanches.service.ProducerService;
import ru.mail.sanches.service.impl.ProducerServiceImpl;
import ru.mail.sanches.view.Views;

public class TableViewProducer implements Views<Producer>{

    private TableView table = new TableView();

    private ProducerService service = new ProducerServiceImpl();


    @Override
    public Pane buildPane(final ObservableList<Producer> data) {

        final Label label = new Label("Producers");
        label.setFont(new Font("Arial", 20));

        table.setEditable(true);

        TableColumn firstNameCol = new TableColumn("First Name");
        firstNameCol.setMinWidth(150);
        TableColumn lastNameCol = new TableColumn("Last Name");
        lastNameCol.setMinWidth(150);
        TableColumn middleName = new TableColumn("Middle Name");
        middleName.setMinWidth(150);


        final TextField addFirstName = new TextField();
        addFirstName.setMaxWidth(firstNameCol.getPrefWidth());
        addFirstName.setPromptText("First Name");

        final TextField addLastName = new TextField();
        addLastName.setMaxWidth(lastNameCol.getPrefWidth());
        addLastName.setPromptText("Last Name");

        final TextField addMiddleName = new TextField();
        addMiddleName.setMaxWidth(middleName.getPrefWidth());
        addMiddleName.setPromptText("Middle Name");

        firstNameCol.setCellValueFactory(
                new PropertyValueFactory<Producer, String>("firstName")
        );
        firstNameCol.setCellFactory(TextFieldTableCell.forTableColumn());


        lastNameCol.setCellValueFactory(
                new PropertyValueFactory<Producer, String>("lastName")
        );
        lastNameCol.setCellFactory(TextFieldTableCell.forTableColumn());

        middleName.setCellValueFactory(
                new PropertyValueFactory<Producer,String>("middleName")
        );
        middleName.setCellFactory(TextFieldTableCell.forTableColumn());


        table.getColumns().addAll(firstNameCol, lastNameCol, middleName);

        table.setItems(data);

        final Button button = new Button("Add");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                String firstName = addFirstName.getText();
                String lastName = addLastName.getText();
                String middleName = addMiddleName.getText();
                if (!firstName.isEmpty())
                    data.add(new Producer (firstName, lastName, middleName));
                addFirstName.clear();
                addLastName.clear();
                addMiddleName.clear();
            }
        });

        final Button save = new Button("Save");
        save.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                service.save(data);
            }
        });

        final Button refresh = new Button("Refresh");
        refresh.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                data.clear();
                data.addAll(service.getAll());
            }
        });

        HBox hBox = new HBox();
        hBox.getChildren().addAll(addFirstName, addLastName, addMiddleName, button, save, refresh);


        final TextField query = new TextField();
        query.setPromptText("Query");

        final Button search = new Button("Search");
        search.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                data.clear();
                data.addAll(service.getByParameter("firstName", query.getText()));
            }
        });

        HBox see = new HBox();
        see.getChildren().addAll(query,search);

        final VBox vbox = new VBox();
        vbox.setFillWidth(true);
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(table,hBox, see);

        return vbox;
    }
}
