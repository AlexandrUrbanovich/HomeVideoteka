package ru.mail.sanches;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ru.mail.sanches.entity.Actor;
import ru.mail.sanches.entity.Producer;
import ru.mail.sanches.view.impl.Window;
import java.util.HashMap;
import java.util.Map;


public class App extends Application{

    private final ObservableList<Actor> dataactors = FXCollections.observableArrayList();
    private final ObservableList<Producer> dataproducers = FXCollections.observableArrayList();
    Map<Class, ObservableList> data = new HashMap<>();

    public static void main(String[] args){
        launch(args);
    }

    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(new Group());
        stage.setTitle("Table View Sample");
        stage.setWidth(500);
        stage.setHeight(550);

        final Label label = new Label("Home Videoteka");
        label.setFont(new Font("Arial", 20));

        ((Group) scene.getRoot()).getChildren().addAll(initLayout(), initLayout());

        stage.setScene(scene);
        stage.show();
    }


    private Pane initLayout() {

        data.put(Actor.class, dataactors);
        data.put(Producer.class, dataproducers);

        Window views = new Window();
        return views.buildPane(data);
    }
}
