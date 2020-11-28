package gui.javafx.controllers;

import java.security.DrbgParameters.NextBytes;

import app.interfaces.DrawingAdapterI;
import app.model.Sheet;
import gui.javafx.Entry;
import gui.javafx.Transform;
import gui.javafx.views.PresentationView;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class PresentationController {
    private Sheet model;

    private Canvas next;
    private Canvas current;

    @FXML
    private Pane pane;

    public void initialize() {
        this.model = Entry.model;
        this.current = new PresentationView(this);

        pane.getChildren().clear();
        pane.getChildren().add(current);
        current.widthProperty().bind(pane.widthProperty());
        current.heightProperty().bind(pane.heightProperty());
    }

    public void getNext() {
        int index = model.getCurrentStateIndex();

        if (index < model.getSheetSize() - 1) {
            model.setCurrentStateIndex(++index);
        }
    }

    public void getPrevious() {
        int index = model.getCurrentStateIndex();

        if (index > 0) {
            model.setCurrentStateIndex(--index);
        }

    }
}
