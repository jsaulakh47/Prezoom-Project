package gui.javafx.views;

import app.interfaces.DrawingAdapterI;
import app.model.Sheet;
import gui.javafx.DrawingAdapter;
import gui.javafx.Entry;
import gui.javafx.Transform;
import gui.javafx.controllers.PresentationController;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;

public class PresentationView extends Canvas {
    private final Sheet model;
    private final PresentationController controller;

    public PresentationView(PresentationController controller) {
        this.model = Entry.model;
        this.controller = controller;
        model.setCurrentStateIndex(0);
        widthProperty().addListener(e -> draw());
        heightProperty().addListener(e -> draw());

        this.setOnMousePressed(e -> {
            if (e.getButton() == MouseButton.PRIMARY) {
                controller.getNext();
            } else if (e.getButton() == MouseButton.SECONDARY) {
                controller.getPrevious();
            }
            
            draw();
        });

        this.requestFocus();
        this.setFocusTraversable(true);

        this.setOnKeyReleased(e -> {
            if (e.getCode() == KeyCode.RIGHT || e.getCode() ==KeyCode.UP) {
                controller.getNext();
            } else if (e.getCode() == KeyCode.LEFT || e.getCode() == KeyCode.DOWN) {
                controller.getPrevious();
            }

            draw();
        });

        draw();
    }

    public void update() {
		draw() ;
	}

    private void draw() {
        double width = getWidth();
        double height = getHeight();
        GraphicsContext gc = getGraphicsContext2D();

        Transform transform = new Transform(width, height, model.getWidth(), model.getHeight());	        	
        DrawingAdapterI drawingAdapter = new DrawingAdapter(gc, transform, width, height);
        model.draw(drawingAdapter);
    }
}