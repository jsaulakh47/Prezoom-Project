package app.model.objects;

import app.model.attributes.Width;

import java.util.Map;

import app.interfaces.DrawingAdapterI;
import app.model.attributes.AttributeLabel;
import app.model.attributes.Height;
import app.model.attributes.Source;

public class Image extends Objects {

    public static final String DEFAULT_SOURCE = "/alfa.png";
    public static final String DEFAULT_WIDTH = "100";
    public static final String DEFAULT_HEIGHT = "80";

    public Image(String x, String y, String source, String width, String height) {
        super(x, y, ObjectType.IMAGE.getType());
        addAttribute(new Source(source));
        addAttribute(new Width(width));
        addAttribute(new Height(height));
    }

    public Image(String x, String y) {
        this(x, y, DEFAULT_SOURCE, DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    @Override
    public boolean locatedAt(double x, double y) {
        double xPos = getX();
        double yPos = getY();
        
        Map<String, String> attributes = this.getAttributes();
        double width = Double.parseDouble(attributes.get(AttributeLabel.WIDTH.getLabel()));
        double height = Double.parseDouble(attributes.get(AttributeLabel.HEIGHT.getLabel()));

        return (x >= xPos && x <= (xPos + width) && y >= yPos && y <= (yPos + height)) ? true : false;
    }

    @Override
    public void draw(DrawingAdapterI drawingAdapter) {
        double x = getX();
        double y = getY();
        
        Map<String, String> attributes = this.getAttributes();
        String url = attributes.get(AttributeLabel.SOURCE.getLabel());
        double width = Double.parseDouble(attributes.get(AttributeLabel.WIDTH.getLabel()));
        double height = Double.parseDouble(attributes.get(AttributeLabel.HEIGHT.getLabel()));

        drawingAdapter.drawImage(url, x, y, width, height);
    }
}

