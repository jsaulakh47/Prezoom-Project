package app.model.objects;

import app.model.attributes.Width;
import app.model.attributes.Height;

import java.util.Map;

import app.interfaces.DrawingAdapterI;
import app.model.attributes.AttributeLabel;
import app.model.attributes.FillColor;
import app.model.attributes.StrokeColor;
import app.model.attributes.StrokeWidth;

public class Rectangle extends Objects {

    public static final String DEFAULT_WIDTH = "100";
    public static final String DEFAULT_HEIGHT = "80";

    public Rectangle(String x, String y, String width, String height) {
        super(x, y, ObjectType.RECTANGLE.getType());
        addAttribute(new Width(width));
        addAttribute(new Height(height));
        addAttribute(new StrokeWidth());
        addAttribute(new FillColor());
        addAttribute(new StrokeColor());
    }

    public Rectangle(String x, String y) {
        this(x, y, DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    @Override
    public void draw(DrawingAdapterI drawingAdapter) {
        Map<String, String> attributes = this.getAttributes();
        double x = Double.parseDouble(attributes.get(AttributeLabel.X_POSITION.getLabel()));
        double y = Double.parseDouble(attributes.get(AttributeLabel.Y_POSITION.getLabel()));

        double height = Double.parseDouble(attributes.get(AttributeLabel.HEIGHT.getLabel()));
        double width = Double.parseDouble(attributes.get(AttributeLabel.WIDTH.getLabel()));

        drawingAdapter.drawRectangle(x, y, width, height);
    }
}

