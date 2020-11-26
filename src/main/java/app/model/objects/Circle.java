package app.model.objects;

import app.model.attributes.Radius;
import app.model.attributes.FillColor;
import app.model.attributes.StrokeColor;
import app.model.attributes.StrokeWidth;

public class Circle extends Objects {

    public static final String DEFAULT_RADIUS = "50";

    public Circle(String x, String y, String radius) {
        super(x, y, "Circle");
        addAttribute(new Radius(radius));
        addAttribute(new StrokeWidth());
        addAttribute(new FillColor());
        addAttribute(new StrokeColor());
    }

    public Circle(String x, String y) {
        this(x, y, DEFAULT_RADIUS);
    }

    @Override
    public void draw() {
        // TODO Auto-generated method stub

    }
}

