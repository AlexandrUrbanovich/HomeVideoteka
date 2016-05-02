package ru.mail.sanches.view;

import javafx.collections.ObservableList;
import javafx.scene.layout.Pane;
import ru.mail.sanches.entity.Actor;

public interface Views {
   Pane buildPane(final ObservableList<Actor> data);
}
