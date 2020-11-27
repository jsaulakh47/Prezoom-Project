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

	public DrawingAdapter(GraphicsContext gc, Transform transform, double width, double height) {
		this.gc = gc ;
		this.width = width ;
		this.height = height ;
		this.transform = transform ;

		gc.setFill(Color.WHITE);
		gc.setStroke(Color.LIGHTBLUE);
        gc.clearRect(0, 0, width, height);

		gc.fillRect(0, 0, width, height);
        gc.strokeRect(0, 0, width, height);
	}

    @Override
    public void SetStrokeColor(String color) {
        this.gc.setStroke(Color.web(color));
    }

    @Override
    public void SetFillColor(String color) {
        this.gc.setFill(Color.web(color));
    }

    @Override
    public void SetTextColor(String color) {
        // TODO Auto-generated method stub
    }

    @Override
    public void SetTextFont(String font) {
        // TODO Auto-generated method stub
    }

    @Override
    public void SetLineWidth(double width) {
        this.gc.setLineWidth(width);
    }

    @Override
    public void drawRectangle(double x, double y, double width, double height) {
        Point2D p = transform.worldToView(x, y);
        gc.fillRect(p.getX(), p.getY(), width, height);
        gc.strokeRect(p.getX(), p.getY(), width, height);
    }

    @Override
    public void drawCircle(double x, double y, double radius) {
        Point2D p = transform.worldToView(x, y);
        
        double i = (int) p.getX() - radius;
        double j = (int) p.getY() - radius;
        double w = (int) 2 * radius;
        double h = (int) 2 * radius;

        gc.strokeOval(i, j, w, h);
		gc.fillOval(i, j, w, h);
    }

    @Override
    public void drawLine(double start_x, double start_y, double end_x, double end_y) {
        // TODO Auto-generated method stub
        Point2D p = transform.worldToView(start_x, start_y);
        Point2D q = transform.worldToView(end_x, end_y);

        gc.strokeLine(p.getX(), p.getY(), q.getX(), q.getY());
    }

    @Override
    public void drawText(double x, double y, double text) {
        // TODO Auto-generated method stub

    }

    @Override
    public void drawTextArea() {
        // TODO Auto-generated method stub

    }

    @Override
    public void getTransform() {
        // TODO Auto-generated method stub

    }

    @Override
    public void transform() {
        // TODO Auto-generated method stub

    }
    
}
