package app.model.objects;

import java.util.Map;

import app.interfaces.DrawingAdapterI;
import app.model.attributes.AttributeLabel;
import app.model.attributes.Height;
import app.model.attributes.StrokeColor;
import app.model.attributes.Width;

/**
 * @author Team Alfa
 * @declaration “This file was prepared by members of Team Alfa. It was completed by group members alone.”
 * 
 * Class: This class represents the Camera object and sets the attributes required for the same. 
 */

public class Camera extends Objects{

    private static final String DEFAULT_WIDTH = "1080";
    private static final String DEFAULT_HEIGHT = "720";
    public static final String STROKE_COLOR = "#FF0000";

    /**
     * This constructor is used to add attributes and sets default value of the attributes of the Camera object.
     * @param x - It is x-coordinates on canvas.
     * @param y - It is y-coordinates on canvas.
     * @param width - It is width of the Camera.
     * @param height - It is height of the Camera.
     */

    public Camera(String x, String y, String width, String height) {
        super(x, y, ObjectType.CAMERA.getType());
        addAttribute(new Width(width));
        addAttribute(new Height(height));
        addAttribute(new StrokeColor(STROKE_COLOR));
    }

    /**
     * This constructor overloads the constructor.
     * @param x - It is x-coordinates on canvas.
     * @param y - It is y-coordinates on canvas.
     */

    public Camera(String x, String y) {
        this(x, y, DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    /**
     * default constructor with X and Y position set to 0 and 0 recspectively;
     */


    
    public Camera() {
        this("0", "0", DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    

    @Override
    public boolean locatedAt(double x, double y) {
        return false;
    }

    @Override
    public void draw(DrawingAdapterI drawingAdapter) {
        double x = getX();
        double y = getY();
        
        Map<String, String> attributes = this.getAttributes();
        double width = Double.parseDouble(attributes.get(AttributeLabel.WIDTH.getLabel()));
        double height = Double.parseDouble(attributes.get(AttributeLabel.HEIGHT.getLabel()));
        
        drawingAdapter.setStrokeColor(attributes.get(AttributeLabel.STROKE_COLOR.getLabel()));

        drawingAdapter.drawCamera(x, y, width, height);
    }
}
