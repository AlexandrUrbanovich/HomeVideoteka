package ru.mail.sanches.view;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ru.mail.sanches.dao.ProducerDao;
import ru.mail.sanches.dao.impl.ProducerDaoImpl;
import ru.mail.sanches.entity.Producer;
import ru.mail.sanches.service.ProducerService;
import ru.mail.sanches.service.impl.ProducerServiceImpl;

import java.util.List;

public class TableViewProducer extends Application{

    private TableView table = new TableView();

    private ProducerService servise = new ProducerServiceImpl();

    private ProducerDao dao = new ProducerDaoImpl();

    private final ObservableList<Producer> data = FXCollections.observableArrayList();

    public  static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) throws Exception {
        List<Producer> producers = dao.getAll();
        data.addAll(producers);

        Scene scene = new Scene(new Group());
        stage.setTitle("Table View Sample");
        stage.setWidth(500);
        stage.setHeight(550);

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
        firstNameCol.setCellValueFactory(TextFieldTableCell.forTableColumn());
        firstNameCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Producer, String>>() {
                    public void handle(TableColumn.CellEditEvent<Producer, String> t) {
                        ((Producer) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setFirstName(t.getNewValue());
                    }
                }
        );

        lastNameCol.setCellValueFactory(
                new PropertyValueFactory<Producer, String>("lastName")
        );
        lastNameCol.setCellValueFactory(TextFieldTableCell.forTableColumn());
        lastNameCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Producer, String>>() {
                    public void handle(TableColumn.CellEditEvent<Producer, String> t) {
                        ((Producer) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setLastName(t.getNewValue());
                    }
                }
        );

        middleName.setCellValueFactory(
                new PropertyValueFactory<Producer,String>("middleName")
        );
        middleName.setCellFactory(TextFieldTableCell.forTableColumn());
        middleName.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Producer, String>>() {
                    public void handle(TableColumn.CellEditEvent<Producer, String> t) {
                        ((Producer) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                        ).setMiddleName(t.getNewValue());
                    }
                }
        );

        table.getColumns().addAll(firstNameCol, lastNameCol, middleName);






    }
}
