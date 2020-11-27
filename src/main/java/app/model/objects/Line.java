package app.model.objects;

import app.interfaces.DrawingAdapterI;
import app.model.attributes.EndX;
import app.model.attributes.EndY;
import app.model.attributes.FillColor;
import app.model.attributes.StrokeColor;
import app.model.attributes.StrokeWidth;

public class Line extends Objects {

    public static final int DEFAULT_OFFSET = 100;

    public Line(String x, String y, String end_x, String end_y) {
        super(x, y, ObjectType.LINE.getType());
        addAttribute(new EndX(end_x));
        addAttribute(new EndY(end_y));
        addAttribute(new StrokeWidth());
        addAttribute(new FillColor());
        addAttribute(new StrokeColor());
    }

    public Line(String x, String y) {
        this(x, y, String.valueOf(Double.parseDouble(x) + DEFAULT_OFFSET), String.valueOf(Double.parseDouble(y) + DEFAULT_OFFSET));
    }

    @Override
    public boolean locatedAt(double x, double y) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void draw(DrawingAdapterI drawingAdapter) {
        // TODO Auto-generated method stub

    }
}

