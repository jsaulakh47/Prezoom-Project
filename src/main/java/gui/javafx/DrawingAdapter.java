package gui.javafx;

import app.interfaces.DrawingAdapterI;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * @author Team Alfa
 * @declaration “This file was prepared by members of Team Alfa. It was completed by group members alone.”
 * Class : This class inharites the properties from the Drawingadapter interface that allows the drawing the object using model.
 
 */
public class DrawingAdapter implements DrawingAdapterI{
	private final GraphicsContext gc;
	private final Transform transform ;
	private final double width;
    private final double height;


    /**
     * This constructor is used to set the graphicsContext and Transform.
     * @param gc -graphicscontext .
     * @param transform - world view transformation .
     * @param width - It is width of viewport .
     * @param height - It is height of the viewport.
     */

	public DrawingAdapter(GraphicsContext gc, Transform transform, double width, double height) {
		this.gc = gc ;
		this.width = width ;
		this.height = height ;
		this.transform = transform ;

		gc.setStroke(Color.LIGHTBLUE);
        gc.clearRect(0, 0, width, height);

		gc.fillRect(0, 0, width, height);
        gc.strokeRect(0, 0, width, height);
    }
    
    /**This sub-routine is used to set the strokecolor.
     * @param :color:- It is stoke color.
     */
    @Override
    public void setStrokeColor(String color) {
        this.gc.setStroke(Color.web(color));
    }
    
    /**This sub-routine is used to set the strokecolor.
     * @param :color:- It is fill color.
     */
    @Override
    public void setFillColor(String color) {
        this.gc.setFill(Color.web(color));
    }

    /**This sub-routine is used to set the font.
     * @param :font:- It is font.
     */
    @Override
    public void setFont(String font) {
        this.gc.setFont(Font.font(font));
    }

    /**This sub-routine is used to set the linewidth.
     * @param :width:- It is width of line.
     */
    @Override
    public void setLineWidth(double width) {
        this.gc.setLineWidth(width);
    }
  
    /**This sub-routine is used to draw the camera.
     * @param :x :- x co-ordinates of camera.
     * @param :y :- x co-ordinates of camera.
     * @param : width :- width of camera.
     * @param : height :- height of camera.
     */
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

    /**This sub-routine is used to draw Rectangle. 
     * @param :x :- x co-ordinates of ractangle.
     * @param :y :- x co-ordinates of ractangle.
     * @param :width :- width of ractangle.
     * @param :height :- height of ractangle.
    */
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

    /**This sub-routine is used to draw circle. 
     * @param :x :- x co-ordinates of circle.
     * @param :y :- x co-ordinates of circle.
     * @param :radius :- radius of circle. 
    */
    @Override
    public void drawCircle(double x, double y, double radius) {
        Point2D p = transform.worldToView(x, y);
        Point2D q = transform.worldToView(x - radius, y);

        double r = Math.abs(p.getX() - q.getX());

        double i = p.getX() - r;
        double j = p.getY() - r;
        double d = 2 * r;

		gc.fillOval(i, j, d, d);
        gc.strokeOval(i, j, d, d);
    }

    /**This sub-routine is used to draw line.
     * @param :start_x :- x co-ordinates of starting of line.
     * @param :start_y :- y co-ordinates of starting of line.
     * @param :end_x :- x co-ordinates of ending of line.
     * @param :end_y :- y co-ordinates of ending of line.
     */
    @Override
    public void drawLine(double start_x, double start_y, double end_x, double end_y) {
        Point2D p = transform.worldToView(start_x, start_y);
        Point2D q = transform.worldToView(end_x, end_y);

        double i = p.getX();
        double j = p.getY();
        double a = q.getX();
        double b = q.getX();

        gc.strokeLine(i, j, a, b);
    }

    /**This sub-routine is used to draw Text.
     * @param :text :- text. 
     * @param :x :- x co-ordinates of text.
     * @param :y :- x co-ordinates of text.
     * @param :width :- width of text.    
    */
    @Override
    public void drawText(String text, double x, double y, double width) {
        Point2D p = transform.worldToView(x, y);
        Point2D q = transform.worldToView(x + width, y);

        double i = p.getX();
        double j = p.getY();
        double w = Math.abs(p.getX() - q.getX());

        gc.fillText(text, i, j, w);
        gc.strokeText(text, i, j, w);
    }

    /**This sub-routine is used to draw textarea.
     * @param :text :- textarea. 
     * @param :x :- x co-ordinates of textarea.
     * @param :y :- x co-ordinates of textarea.
     * @param :width :- width of textarea. 
     * @param :height :- height of textarea.   
    */
    @Override
    public void drawTextArea(String text, double x, double y, double width, double height) {
        Point2D p = transform.worldToView(x, y);
        Point2D q = transform.worldToView(x + width, y + height);

        double i = p.getX();
        double j = p.getY();
        double w = Math.abs(p.getX() - q.getX());
        double h = Math.abs(p.getY() - q.getY());
        
        gc.strokeRect(i, j, w, h);
        gc.fillText(text, i, j, w);
        gc.strokeText(text, i, j, w);
    }

    /**This sub-routine is used to draw image.
     * @param :url :- x co-ordinates of Image.
     * @param :x :- x co-ordinates of Image.
     * @param :y :- x co-ordinates of Image.
     * @param :width :- width of Image. 
     * @param :height :- height of Image.
     */
	@Override
	public void drawImage(String url, double x, double y, double width, double height) {
        Point2D p = transform.worldToView(x, y);
        Point2D q = transform.worldToView(x + width, y + height);

        double i = p.getX();
        double j = p.getY();
        double w = Math.abs(p.getX() - q.getX());
        double h = Math.abs(p.getY() - q.getY());
        
        gc.drawImage(new Image(url), i, j, w, h);
	}    
}
