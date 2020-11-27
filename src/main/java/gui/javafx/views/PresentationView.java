package gui.javafx.views;

import app.interfaces.DrawingAdapterI;
import app.model.Sheet;
import gui.javafx.DrawingAdapter;
import gui.javafx.Transform;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;

public class PresentationView extends Canvas {
    private final Sheet model;

    public PresentationView(Sheet model) {
        this.model = model;
        widthProperty().addListener(e -> draw());
        heightProperty().addListener(e -> draw());

        this.setOnMousePressed(e -> {
            Transform transform = new Transform(getWidth(), getHeight(), model.getWidth(), model.getHeight());
            Point2D p = transform.viewToWorld(e.getX(), e.getY());
            model.selectObjectAt(p.getX(), p.getY());
            if (model.getCurrentObjectId() != 0) {
                model.setStatus("selection");
            }
            draw();
        });

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