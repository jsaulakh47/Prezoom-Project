package gui.javafx;

import app.interfaces.DrawingAdapterI;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

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
    public void setStrokeColor(String color) {
        this.gc.setStroke(Color.web(color));
    }

    @Override
    public void setFillColor(String color) {
        this.gc.setFill(Color.web(color));
    }

    @Override
    public void setFont(String font) {
        this.gc.setFont(Font.font(font));
    }

    @Override
    public void setLineWidth(double width) {
        this.gc.setLineWidth(width);
    }

    @Override
    public void getTransform() {
        // TODO Auto-generated method stub

    }

    @Override
    public void transform() {
        // TODO Auto-generated method stub

    }

	@Override
	public void drawCamera(double x, double y, double width, double height) {
        Point2D p = transform.worldToView(x, y);
        Point2D q = transform.worldToView(x + width, y + height);

        double i = p.getX();
        double j = p.getY();
        double w = Math.abs(p.getX() - q.getX());
        double h = Math.abs(p.getY() - q.getY());

        gc.strokeRect(i, j, w, h);
	}

    @Override
    public void drawRectangle(double x, double y, double width, double height) {
        Point2D p = transform.worldToView(x, y);
        Point2D q = transform.worldToView(x + width, y + height);

        double i = p.getX();
        double j = p.getY();
        double w = Math.abs(p.getX() - q.getX());
        double h = Math.abs(p.getY() - q.getY());
        
        gc.fillRect(i, j, w, h);
        gc.strokeRect(i, j, w, h);
    }

    @Override
    public void drawCircle(double x, double y, double radius) {
        Point2D p = transform.worldToView(x, y);
        Point2D q = transform.worldToView(x - radius, y);

        double r = Math.abs(p.getX() - q.getX());

        double i = p.getX() - r;
        double j = p.getY() - r;
        double k = 2 * r;

		gc.fillOval(i, j, k, k);
        gc.strokeOval(i, j, k, k);
    }

    @Override
    public void drawLine(double start_x, double start_y, double end_x, double end_y) {
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
	public void drawImage() {
		// TODO Auto-generated method stub
		
	}    
}
