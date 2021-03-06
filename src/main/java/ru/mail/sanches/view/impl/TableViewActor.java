package ru.mail.sanches.view.impl;


import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import ru.mail.sanches.entity.Actor;
import ru.mail.sanches.service.ActorService;
import ru.mail.sanches.service.impl.ActorServiceImpl;
import ru.mail.sanches.view.Views;

public class TableViewActor implements Views<Actor>
{
    private TableView table = new TableView();

    private ActorService service = new ActorServiceImpl();

    @Override
    public Pane buildPane(ObservableList<Actor> data) {

        table.setEditable(true);

        TableColumn firstNameCol = new TableColumn("First Name");
        firstNameCol.setMinWidth(150);
        TableColumn lastNameCol = new TableColumn("Last Name");
        lastNameCol.setMinWidth(150);
        TableColumn middleNameCol = new TableColumn("Middle Name");
        middleNameCol.setMinWidth(150);


        final TextField addFirstName = new TextField();
        addFirstName.setMaxWidth(firstNameCol.getPrefWidth());
        addFirstName.setPromptText("First Name");

        final TextField addLastName = new TextField();
        addLastName.setMaxWidth(lastNameCol.getPrefWidth());
        addLastName.setPromptText("Last Name");

        final TextField addMiddleName = new TextField();
        addMiddleName.setMaxWidth(middleNameCol.getPrefWidth());
        addMiddleName.setPromptText("Middle Name");

        firstNameCol.setCellValueFactory(
                new PropertyValueFactory<Actor,String>("firstName")
        );
        firstNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        firstNameCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Actor, String>>() {
                    public void handle(TableColumn.CellEditEvent<Actor, String> t) {
                        ((Actor) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setFirstName(t.getNewValue());
                    }
                }
        );


        lastNameCol.setCellValueFactory(
                new PropertyValueFactory<Actor,String>("lastName")
        );
        lastNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        lastNameCol.setOnEditCommit( new EventHandler<TableColumn.CellEditEvent<Actor, String>>() {
            public void handle(TableColumn.CellEditEvent<Actor, String> t) {
                ((Actor) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                ).setLastName(t.getNewValue());
            }
        });


        middleNameCol.setCellValueFactory(
                new PropertyValueFactory<Actor,String>("middleName")
        );
        middleNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        middleNameCol.setOnEditCommit( new EventHandler<TableColumn.CellEditEvent<Actor, String>>() {
            public void handle(TableColumn.CellEditEvent<Actor, String> t) {
                ((Actor) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                ).setMiddleName(t.getNewValue());
            }
        });

        table.getColumns().addAll(firstNameCol, lastNameCol, middleNameCol);

        table.setItems(data);


        final Button button = new Button("Add");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                String firstName = addFirstName.getText();
                String lastName = addLastName.getText();
                String middleName = addMiddleName.getText();
                if (!firstName.isEmpty())
                    data.add(new Actor(firstName, lastName, middleName));
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
        vbox.getChildren().addAll(table, hBox, see);

        return vbox;
    }
}