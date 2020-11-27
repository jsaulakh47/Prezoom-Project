package gui.javafx.views;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import app.exceptions.InvalidObjectTypeException;
import app.interfaces.DrawingAdapterI;
import app.model.Sheet;
import gui.javafx.DrawingAdapter;
import gui.javafx.Transform;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.TransferMode;

public class EditView extends Canvas implements PropertyChangeListener {
    private final Sheet model;

    public EditView(Sheet model) {
        widthProperty().addListener(e -> draw());
        heightProperty().addListener(e -> draw());

        this.model = model;
        // this.model.addPropertyChangeListener(this);

        this.setOnDragOver(e -> {
            if (e.getDragboard().hasString()) {
                e.acceptTransferModes(TransferMode.ANY);
                e.consume();
            }
        });

        this.setOnDragDropped(e -> {
            Transform transform = new Transform(getWidth(), getHeight(), model.getWidth(), model.getHeight());
            Point2D point = transform.viewToWorld(e.getX(), e.getY());
            String type = e.getDragboard().getString();

            try {                
                model.addObject(type, point.getX(), point.getY());
            } catch (InvalidObjectTypeException exception) {
                exception.printStackTrace();
            }
            
            e.setDropCompleted(true);
            draw();
        });
        
        this.setOnMousePressed(e -> {
            // Transform transform = new Transform(getWidth(), getHeight(), model.getWidth(), model.getHeight());
            // Point2D point = transform.viewToWorld(e.getX(), e.getY());
            // Node     aNode = graph.nodeAt(ev.getX(), ev.getY());
            //     if (ev.getClickCount() == 2) {
            //         if (aNode == null) {
            //             // We missed a node, now try for an edge midpoint
            //             Edge anEdge = graph.edgeAt(ev.getX(), ev.getY());
            //             if (anEdge == null)
            //                 graph.addNode(new Node(ev.getX(), ev.getY()));
            //             else
            //                 anEdge.toggleSelected();
            //         }
            //         else
            //             aNode.toggleSelected();
            //         // Update the view, by redrawing the Graph
            //         update();
            //     }
            //     else {
            //         if (aNode != null) {
            //             dragNode = aNode; 	// If we pressed on a node, store it
            //             dragEdge = null;
            //         }
            //         else
            //             dragEdge = graph.edgeAt(ev.getX(), ev.getY());
            //         dragPoint = new Point2D(ev.getX(), ev.getY());
            //     }
            // }
        });

        draw();
    }

    private void draw() {
        double width = getWidth();
        double height = getHeight();
        GraphicsContext gc = getGraphicsContext2D();

        Transform transform = new Transform(width, height, model.getWidth(), model.getHeight());	        	
        DrawingAdapterI drawingAdapter = new DrawingAdapter(gc, transform, width, height);
        model.draw(drawingAdapter);
    }

    @Override
    public void propertyChange(PropertyChangeEvent event) {
        draw();
    }
}