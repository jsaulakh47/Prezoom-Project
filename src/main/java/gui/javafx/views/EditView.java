package gui.javafx.views;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.InvalidObjectException;

import app.exceptions.InvalidObjectTypeException;
import app.interfaces.DrawingAdapterI;
import app.model.Sheet;
import gui.javafx.DrawingAdapter;
import gui.javafx.Transform;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.TransferMode;

public class EditView extends Canvas implements PropertyChangeListener {
    private final Sheet model;

    public static final int WIDTH = 500;
    public static final int HEIGHT = 250;

    public EditView(Sheet model) {
        super(WIDTH, HEIGHT);

        this.model = model;
        this.model.addPropertyChangeListener(this);

        this.setOnDragOver(e -> {
            if (e.getDragboard().hasString()) {
                e.acceptTransferModes(TransferMode.ANY);
                e.consume();
            }
        });

        this.setOnDragDropped(e -> {
            String type = e.getDragboard().getString();

            try {
                this.model.addObject(type, e.getX(), e.getY());
            } catch (InvalidObjectTypeException exception) {
                exception.printStackTrace();
            }
            
            e.setDropCompleted(true);
        });

        this.paint();
    }

    private void paint() {
        GraphicsContext gc = this.getGraphicsContext2D();
        double width = this.getWidth();
        double height = this.getHeight();

		Transform transform = new Transform( width, height, this.model.getWidth(), this.model.getHeight());		
		DrawingAdapterI drawingAdapter = new DrawingAdapter(gc, transform, width, height);
        // this.model.draw(drawingAdapter);
    }

    @Override
    public void propertyChange(PropertyChangeEvent event) {
        paint();
    }
}