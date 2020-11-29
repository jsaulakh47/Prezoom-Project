package app.model.objects;

import app.model.attributes.Radius;

import java.util.Map;

import app.interfaces.DrawingAdapterI;
import app.model.attributes.AttributeLabel;
import app.model.attributes.FillColor;
import app.model.attributes.StrokeColor;
import app.model.attributes.StrokeWidth;

public class Circle extends Objects {

    public static final String DEFAULT_RADIUS = "100";

    public Circle(String x, String y, String radius) {
        super(x, y, ObjectType.CIRCLE.getType());
        addAttribute(new Radius(radius));
        addAttribute(new StrokeWidth());
        addAttribute(new FillColor());
        addAttribute(new StrokeColor());
    }

    public Circle(String x, String y) {
        this(x, y, DEFAULT_RADIUS);
    }

    @Override
    public boolean locatedAt(double x, double y) {
        double xPos = getX();
        double yPos = getY();
        
        Map<String, String> attributes = this.getAttributes();
        double radius = Double.parseDouble(attributes.get(AttributeLabel.RADIUS.getLabel()));

        return (x - xPos) * (x - xPos) + (y - yPos) * (y - yPos) <= (radius * radius) ? true : false;
    }

    @Override
    public void draw(DrawingAdapterI drawingAdapter) {
        double x = getX();
        double y = getY();

        Map<String, String> attributes = this.getAttributes();
        double radius = Double.parseDouble(attributes.get(AttributeLabel.RADIUS.getLabel()));
        
        drawingAdapter.setLineWidth(Double.parseDouble(attributes.get(AttributeLabel.STROKE_WIDTH.getLabel())));
        drawingAdapter.setStrokeColor(attributes.get(AttributeLabel.STROKE_COLOR.getLabel()));
        drawingAdapter.setFillColor(attributes.get(AttributeLabel.FILL_COLOR.getLabel()));

        drawingAdapter.drawCircle(x, y, radius);
    }
}

