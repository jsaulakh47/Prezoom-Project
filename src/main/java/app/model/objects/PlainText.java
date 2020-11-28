package app.model.objects;

import app.model.attributes.Text;
import app.model.attributes.Width;
import app.interfaces.DrawingAdapterI;
import app.model.attributes.AttributeLabel;
import app.model.attributes.FillColor;
import app.model.attributes.FontSize;
import app.model.attributes.StrokeColor;
import app.model.attributes.StrokeWidth;
import java.util.Map;

public class PlainText extends Objects {

    public static final String DEFAULT_TEXT = "Alfa";
    public static final String DEFAULT_FONTSIZE = "10";

    public PlainText(String x, String y, String text, String fontsize) {
        super(x, y, ObjectType.PLAIN_TEXT.getType());
        addAttribute(new Text(text));
        addAttribute(new FontSize(fontsize));
        addAttribute(new Width());
        addAttribute(new StrokeWidth());
        addAttribute(new FillColor());
        addAttribute(new StrokeColor());
    }

    public PlainText(String x, String y) {
        this(x, y, DEFAULT_TEXT, DEFAULT_FONTSIZE);
    }

    @Override
    public boolean locatedAt(double x, double y) {
        double xPos = getX();
        double yPos = getY();
        
        Map<String, String> attributes = this.getAttributes();
        double width = Double.parseDouble(attributes.get(AttributeLabel.WIDTH.getLabel()));
        double height = Double.parseDouble(attributes.get(AttributeLabel.FONT_SIZE.getLabel()));

        return (x >= xPos && x <= (xPos + width) && y >= yPos && y <= (yPos + height)) ? true : false;
    }

    @Override
    public void draw(DrawingAdapterI drawingAdapter) {
        double x = getX();
        double y = getY();
        
        Map<String, String> attributes = this.getAttributes();
        String text = attributes.get(AttributeLabel.TEXT.getLabel());
        double width = Double.parseDouble(attributes.get(AttributeLabel.WIDTH.getLabel()));
        
        drawingAdapter.setFont(attributes.get(AttributeLabel.FONT.getLabel()));
        drawingAdapter.setFillColor(attributes.get(AttributeLabel.FILL_COLOR.getLabel()));
        drawingAdapter.setStrokeColor(attributes.get(AttributeLabel.STROKE_COLOR.getLabel()));
        drawingAdapter.setLineWidth(Double.parseDouble(attributes.get(AttributeLabel.STROKE_WIDTH.getLabel())));

        drawingAdapter.drawText(text, x, y, width);
    }
}

