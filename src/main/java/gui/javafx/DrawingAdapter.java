package gui.javafx;

import app.interfaces.DrawingAdapterI;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class DrawingAdapter implements DrawingAdapterI{
	private final GraphicsContext gc;
	private final Transform transform ;
	private final double width;
    private final double height;

    private Color strokeColor;
    private Color textColor;
    private Color fillColor;

	public DrawingAdapter(GraphicsContext gc, Transform transform, double width, double height) {
		this.gc = gc ;
		this.transform = transform ;
		this.width = width ;
		this.height = height ;
		
		gc.clearRect(0, 0, width, height);
		gc.setFill(Color.WHITE);
		gc.setStroke(Color.BLACK);
		gc.fillRect(0, 0, width, height);
		gc.strokeRect(0, 0, width, height);
	}

    @Override
    public void SetStrokeColor(String color) {
        this.strokeColor = Color.web(color);
    }

    @Override
    public void SetFillColor(String color) {
        this.fillColor = Color.web(color);
    }

    @Override
    public void SetTextColor(String color) {
        this.textColor = Color.web(color);
    }

    @Override
    public void SetTextFont(String font) {
        // TODO Auto-generated method stub

    }

    @Override
    public void SetLineWidth(double color) {
        // TODO Auto-generated method stub

    }

    @Override
    public void drawRectangle(double x, double y, double width, double height) {

    }

    @Override
    public void drawCircle(double x, double y, double radius) {
		Point2D p0 = transform.worldToView(x - radius, y -radius);
        Point2D p1 = transform.worldToView(x + radius, y + radius);

        double i = p0.getX();
        double j = p0.getY();
		double w = p1.getX()-x, h = p1.getY()-y ;
		// grCxt.setFill( Color.RED) ;
		// grCxt.fillOval((int)x, (int)y, (int)w+1, (int)h+1) ;
        
        // gc.setFill(Color.WHITESMOKE);
        //      gc.fillRect(rect.getX(),      
        //                  rect.getY(), 
        //                  rect.getWidth(), 
        //                  rect.getHeight());
        //      gc.setFill(Color.GREEN);
        //      gc.setStroke(Color.BLUE);
        //      return gc;

    }

    @Override
    public void drawLine(double start_x, double start_y, double end_x, double end_y) {
        // TODO Auto-generated method stub

    }

    @Override
    public void drawText(double x, double y, double text) {
        // TODO Auto-generated method stub

    }

    @Override
    public void drawTextArea() {
        // TODO Auto-generated method stub

    }
    
}
