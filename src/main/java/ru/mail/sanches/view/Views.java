package ru.mail.sanches.view;

import javafx.collections.ObservableList;
import javafx.scene.layout.Pane;

public interface Views<T> {
  Pane buildPane(final ObservableList<T> data);
}
