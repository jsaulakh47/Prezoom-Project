package app.model.objects;

import app.model.attributes.Radius;

import java.util.Map;

import app.interfaces.DrawingAdapterI;
import app.model.attributes.AttributeLabel;
import app.model.attributes.FillColor;
import app.model.attributes.StrokeColor;
import app.model.attributes.StrokeWidth;

public class Circle extends Objects {

    public static final String DEFAULT_RADIUS = "50";

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
    public Boolean locatedAt(double x, double y) {
        Map<String, String> attributes = this.getAttributes();
        double radius = Double.parseDouble(attributes.get(AttributeLabel.RADIUS.getLabel()));
        double xPos = Double.parseDouble(attributes.get(AttributeLabel.X_POSITION.getLabel()));
        double yPos = Double.parseDouble(attributes.get(AttributeLabel.Y_POSITION.getLabel()));

        double d = (x - xPos) * (x - xPos) + (y - yPos) * (y - yPos);
        return d <= (radius * radius) ? true : false;
    }

    @Override
    public void draw(DrawingAdapterI drawingAdapter) {
        Map<String, String> attributes = this.getAttributes();
        double x = Double.parseDouble(attributes.get(AttributeLabel.X_POSITION.getLabel()));
        double y = Double.parseDouble(attributes.get(AttributeLabel.Y_POSITION.getLabel()));

        double radius = Double.parseDouble(attributes.get(AttributeLabel.RADIUS.getLabel()));
        
        drawingAdapter.SetLineWidth(Double.parseDouble(attributes.get(AttributeLabel.STROKE_WIDTH.getLabel())));
        drawingAdapter.SetStrokeColor(attributes.get(AttributeLabel.STROKE_COLOR.getLabel()));
        drawingAdapter.SetFillColor(attributes.get(AttributeLabel.FILL_COLOR.getLabel()));

        drawingAdapter.drawCircle(x, y, radius);
    }
}

