package ru.mail.sanches.view.impl;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import ru.mail.sanches.entity.Actor;
import ru.mail.sanches.view.Views;

public class Window implements Views {

    private Views tableActor = (Views) new TableViewActor();
    private Views tableProducer = (Views) new TableViewProducer();


    public Pane buildPane(final ObservableList<Actor> data) {
        final VBox vbox = new VBox();

        final ChangedButton viewActor = new ChangedButton(tableActor.buildPane(data));
        final ChangedButton viewProducer = new ChangedButton(tableProducer.buildPane(data));

        HBox cont = new HBox();
        cont.getChildren().addAll(viewActor, viewProducer);

        viewActor.setText("Table Actors");
        viewActor.setOnAction(
                e -> {
                    vbox.getChildren().clear();
                    vbox.getChildren().addAll(cont, viewActor.getControl());
                }
        );

        viewProducer.setText("Table Producer");
        viewProducer.setOnAction(
                e -> {
                    vbox.getChildren().clear();
                    vbox.getChildren().addAll(cont, viewProducer.getControl());
                }
        );


        vbox.setFillWidth(true);
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(cont);


        return vbox;
    }

}
