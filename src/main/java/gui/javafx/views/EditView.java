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
import javafx.scene.input.KeyCode;
import javafx.scene.input.TransferMode;

public class EditView extends Canvas implements PropertyChangeListener {
    private final Sheet model;
    private Transform transform;

    public EditView(Sheet model) {
        this.model = model;
        widthProperty().addListener(e -> draw());
        heightProperty().addListener(e -> draw());

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
            Transform transform = new Transform(getWidth(), getHeight(), model.getWidth(), model.getHeight());
            Point2D p = transform.viewToWorld(e.getX(), e.getY());
            model.selectObjectAt(p.getX(), p.getY());
            draw();
        });

        this.setOnMouseDragged(e -> {
            //     elasticEndLocation = new Point2D(ev.getX(), ev.getY());
            //     if (dragNode != null) {
            //         if (dragNode.isSelected()) {
            //             for (Node n:  graph.selectedNodes()) {
            //                 n.setLocation(n.getLocation().getX() + ev.getX() - dragPoint.getX(),
            //                               n.getLocation().getY() + ev.getY() - dragPoint.getY());
            //             }
            //             dragPoint = new Point2D(ev.getX(), ev.getY());
            //         }
            //     }
            //     if (dragEdge != null) {
            //         if (dragEdge.isSelected()) {
            //             dragEdge.getStartNode().setLocation(
            //                     dragEdge.getStartNode().getLocation().getX() + ev.getX() - dragPoint.getX(),
            //                     dragEdge.getStartNode().getLocation().getY() + ev.getY() - dragPoint.getY());
            //             dragEdge.getEndNode().setLocation(
            //                     dragEdge.getEndNode().getLocation().getX() + ev.getX() - dragPoint.getX(),
            //                     dragEdge.getEndNode().getLocation().getY() + ev.getY() - dragPoint.getY());
            //             dragPoint = new Point2D(ev.getX(), ev.getY());
            //         }
            //     }
            //     update(); 	// We have changed the model, so now update
            // }
        });

        this.requestFocus(); // Needed to handle key events

        this.setOnKeyReleased(e -> {
            if (e.getCode() == KeyCode.DELETE) {
                // Delete all selected Edges
                // for (Edge e:  graph.selectedEdges())
                //     graph.deleteEdge(e);
                // // Delete all selected Nodes
                // for (Node n:  graph.selectedNodes())
                //     graph.deleteNode(n);
                // Update the view, by redrawing the Graph
                update();
            }
        });

        draw();
    }

    public Transform getTransform() {
		return transform;
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
        this.transform = transform;
        model.draw(drawingAdapter);
    }

    @Override
    public void propertyChange(PropertyChangeEvent event) {
        update();
    }
}