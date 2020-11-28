package app.model.objects;

import app.model.attributes.Text;
import app.model.attributes.Width;
import app.model.attributes.Height;
import app.interfaces.DrawingAdapterI;
import app.model.attributes.AttributeLabel;
import app.model.attributes.FillColor;
import app.model.attributes.StrokeColor;
import app.model.attributes.StrokeWidth;
import java.util.Map;

public class TextArea extends Objects {

    public static final String DEFAULT_TEXT = "Alfa";
    public static final String DEFAULT_WIDTH = "100";
    public static final String DEFAULT_HEIGHT = "100";

    public TextArea(String x, String y, String text, String width, String height) {
        super(x, y, ObjectType.TEXT_AREA.getType());
        addAttribute(new Text(text));
        addAttribute(new Width(width));
        addAttribute(new Height(height));
        addAttribute(new StrokeWidth());
        addAttribute(new FillColor());
        addAttribute(new StrokeColor());
    }

    public TextArea(String x, String y) {
        this(x, y, DEFAULT_TEXT, DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    @Override
    public boolean locatedAt(double x, double y) {
        // TODO Auto-generated method stub
        Map<String, String> attributes = this.getAttributes();
        double width = Double.parseDouble(attributes.get(AttributeLabel.WIDTH.getLabel()));
        double height = Double.parseDouble(attributes.get(AttributeLabel.HEIGHT.getLabel()));
        double xPos = Double.parseDouble(attributes.get(AttributeLabel.X_POSITION.getLabel()));
        double yPos = Double.parseDouble(attributes.get(AttributeLabel.Y_POSITION.getLabel()));

        return (x >= xPos && x <= (xPos + width) && y >= yPos && y <= (yPos + height)) ? true : false;
    
    }

    @Override
    public void draw(DrawingAdapterI drawingAdapter) {
        // TODO Auto-generated method stub
        Map<String, String> attributes = this.getAttributes();
        double x = Double.parseDouble(attributes.get(AttributeLabel.X_POSITION.getLabel()));
        double y = Double.parseDouble(attributes.get(AttributeLabel.Y_POSITION.getLabel()));

        double width = Double.parseDouble(attributes.get(AttributeLabel.WIDTH.getLabel()));
        double height = Double.parseDouble(attributes.get(AttributeLabel.HEIGHT.getLabel()));

        String text = attributes.get(AttributeLabel.TEXT_AREA.getLabel());
        
        
        drawingAdapter.SetStrokeColor(attributes.get(AttributeLabel.STROKE_COLOR.getLabel()));
        drawingAdapter.SetLineWidth(Double.parseDouble(attributes.get(AttributeLabel.STROKE_WIDTH.getLabel())));

        drawingAdapter.drawTextArea(x, y,text, width, height);
    }
}

