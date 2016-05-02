package ru.mail.sanches.view.impl;

import javafx.scene.control.Button;
import javafx.scene.layout.Pane;


public class ChangedButton extends Button {

    private Pane control;

    public ChangedButton (Pane control){
        this.control = control;
    }

    public Pane getControl(){
        return control;
    }
}

