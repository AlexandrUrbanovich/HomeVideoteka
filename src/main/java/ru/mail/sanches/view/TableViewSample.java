package ru.mail.sanches.view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class TableViewSample extends Application {

    private TableView table = new TableView();
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage){
        Scene scene = new Scene(new Group());
        stage.setTitle("Table View Sample");
        stage.setWidth(450);
        stage.setHeight(500);

        final Label label = new Label("Actors");
        label.setFont(new Font("Arial", 18));

        table.setEditable(true);

        TableColumn idNameCol = new TableColumn("Id");
        idNameCol.setMinWidth(20);

        TableColumn firstNameCol = new TableColumn("First Name");
        idNameCol.setMinWidth(100);

        TableColumn lastNameCol = new TableColumn("Last Name");
        idNameCol.setMinWidth(100);

        TableColumn middleNameCol = new TableColumn("Middle Name");
        idNameCol.setMinWidth(180);


        table.getColumns().addAll(idNameCol, firstNameCol, lastNameCol, middleNameCol);

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        stage.setScene(scene);
        stage.show();

    }
}
