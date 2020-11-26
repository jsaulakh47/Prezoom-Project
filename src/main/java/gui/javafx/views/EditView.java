package gui.javafx.views;

import app.model.Sheet;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.TransferMode;

public class EditView extends Canvas {
    private final Sheet model;

    public static final int  WIDTH = 500;
    public static final int  HEIGHT = 250;

    public EditView(Sheet model) {
        super(WIDTH, HEIGHT);
        this.model = model;

        this.setOnDragOver(e -> {
            if (e.getDragboard().hasString()){
                e.getDragboard().getString();
                e.setDropCompleted(true);
            }
        });

        this.setOnDragDropped(e -> {
            if (e.getDragboard().hasString()) {
                e.acceptTransferModes(TransferMode.ANY);
                e.consume();
            }
        });

		this.paint();
    }

    private void paint() {
		GraphicsContext gc = this.getGraphicsContext2D() ;
		double width = this.getWidth() ;
        double height = this.getHeight() ;
        
        System.out.println("PAINT!!!");
		
		// TransformFX xform = new TransformFX( width, height,
		//          model.getMazeWidth(), model.getMazeWidth() ) ;
		
		// DrawingAdapter da = new FXDrawingAdapter( gc, xform,
		// 		width, height ) ;
		
		// model.draw( da ); 
	}

    
}
