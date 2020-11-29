package app.model.objects;

import java.util.Map;

import app.interfaces.DrawingAdapterI;
import app.model.attributes.AttributeLabel;
import app.model.attributes.Height;
import app.model.attributes.StrokeColor;
import app.model.attributes.Width;

public class Camera extends Objects{

    private static final String DEFAULT_WIDTH = "1080";
    private static final String DEFAULT_HEIGHT = "720";
    public static final String STROKE_COLOR = "#FF0000";

    public Camera(String x, String y, String width, String height) {
        super(x, y, ObjectType.CAMERA.getType());
        addAttribute(new Width(width));
        addAttribute(new Height(height));
        addAttribute(new StrokeColor(STROKE_COLOR));
    }

    public Camera(String x, String y) {
        this(x, y, DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
    
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
