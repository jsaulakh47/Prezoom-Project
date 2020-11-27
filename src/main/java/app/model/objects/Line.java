package app.model.objects;

import java.util.Map;

import app.interfaces.DrawingAdapterI;
import app.model.attributes.AttributeLabel;
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
    public Boolean locatedAt(double x, double y) {
        // TODO Auto-generated method stub
        Map<String, String> attributes = this.getAttributes();
        double start_x = Double.parseDouble(attributes.get(AttributeLabel.X_POSITION.getLabel()));
        double start_y = Double.parseDouble(attributes.get(AttributeLabel.Y_POSITION.getLabel()));
        double end_x = Double.parseDouble(attributes.get(AttributeLabel.END_X.getLabel()));
        double end_y = Double.parseDouble(attributes.get(AttributeLabel.END_Y.getLabel()));
        double i = Math.sqrt(Math.pow((x - start_x), 2) + Math.pow((y - start_y), 2));
        double j = Math.sqrt(Math.pow((x - end_x), 2) + Math.pow((y - end_y), 2));
        double k = Math.sqrt(Math.pow((start_x - end_x), 2) + Math.pow((start_x - end_y), 2));
        
        return i + j == k ? true : false;
    }

    @Override
    public void draw(DrawingAdapterI drawingAdapter) {
        
        Map<String, String> attributes = this.getAttributes();
        double start_x = Double.parseDouble(attributes.get(AttributeLabel.X_POSITION.getLabel()));
        double start_y = Double.parseDouble(attributes.get(AttributeLabel.Y_POSITION.getLabel()));
        double end_x = Double.parseDouble(attributes.get(AttributeLabel.END_X.getLabel()));
        double end_y = Double.parseDouble(attributes.get(AttributeLabel.END_Y.getLabel()));

        drawingAdapter.SetLineWidth(Double.parseDouble(attributes.get(AttributeLabel.STROKE_WIDTH.getLabel())));
        drawingAdapter.SetStrokeColor(attributes.get(AttributeLabel.STROKE_COLOR.getLabel()));

        drawingAdapter.drawLine(start_x, start_y, end_x, end_y);
    }
}

